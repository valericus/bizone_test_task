package su.creator.bi_zone.model

import java.time.LocalDateTime

import su.creator.bi_zone.utils.DateTimeHelpers.dtFormatter

case class Login(user: String, timestamp: LocalDateTime) {

  override def toString: String = s"$user:${timestamp.format(dtFormatter)}"

}
