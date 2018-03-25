package su.creator.bi_zone.model

import java.time.LocalDateTime

import org.scalatest.{FlatSpec, Matchers}

class SuspiciousActivitySpec extends FlatSpec with Matchers {

  "SuspiciousActivity" should "be converted to correct string" in {
    val activity = SuspiciousActivity(
      "127.0.0.1",
      LocalDateTime.of(2015, 12, 5, 20, 15, 0),
      LocalDateTime.of(2015, 12, 5, 23, 15, 5),
      List(
        Login("user1", LocalDateTime.of(2015, 12, 5, 20, 15, 0)),
        Login("user2", LocalDateTime.of(2015, 12, 5, 21, 15, 3)),
        Login("user3", LocalDateTime.of(2015, 12, 5, 23, 15, 5))
      )
    )

    activity.toString shouldBe "127.0.0.1,2015-12-05 20:15:00,2015-12-05 23:15:05," +
      "\"user1:2015-12-05 20:15:00,user2:2015-12-05 21:15:03,user3:2015-12-05 23:15:05\""
  }

}
