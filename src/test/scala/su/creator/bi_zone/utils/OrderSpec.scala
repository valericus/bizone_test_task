package su.creator.bi_zone.utils

import java.time.LocalDateTime

import org.scalatest.{FlatSpec, Matchers}

class OrderSpec extends FlatSpec with Matchers {

  val input = Seq(
    LocalDateTime.of(2017, 3, 5, 12, 47),
    LocalDateTime.of(2017, 4, 7, 10, 31),
    LocalDateTime.of(2017, 5, 1, 19, 29)
  )

  "Order.localDateTimeOrdering" should "give correct maximum" in {
    input.max(Order.localDateTimeOrdering) shouldBe input.last
  }

  it should "give correct minimum" in {
    input.min(Order.localDateTimeOrdering) shouldBe input.head
  }

}
