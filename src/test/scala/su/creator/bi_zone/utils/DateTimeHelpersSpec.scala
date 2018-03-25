package su.creator.bi_zone.utils

import java.time.LocalDateTime

import org.scalatest.{FlatSpec, Matchers}

class DateTimeHelpersSpec extends FlatSpec with Matchers {
  "DateTimeHelpers.dtFormatter" should "parse string correctly" in {
    LocalDateTime.parse("2019-05-15 23:15:08", DateTimeHelpers.dtFormatter) shouldBe LocalDateTime.of(2019, 5, 15, 23, 15, 8)
  }

  it should "format local date time correctly" in {
    LocalDateTime.of(2011, 4, 1, 3, 7, 1).format(DateTimeHelpers.dtFormatter) shouldBe "2011-04-01 03:07:01"
  }

}
