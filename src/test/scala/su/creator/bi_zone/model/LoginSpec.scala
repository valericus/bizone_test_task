package su.creator.bi_zone.model

import java.time.LocalDateTime

import org.scalatest.{FlatSpec, Matchers}

class LoginSpec extends FlatSpec with Matchers {

  "Login" should "be converted to correct string" in {
    val login = Login("user", LocalDateTime.of(2015, 12, 2, 23, 15, 7))
    login.toString shouldBe "user:2015-12-02 23:15:07"
  }

}
