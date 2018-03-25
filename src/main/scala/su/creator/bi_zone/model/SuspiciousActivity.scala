package su.creator.bi_zone.model

import java.time.LocalDateTime

import su.creator.bi_zone.utils.DateTimeHelpers.dtFormatter

case class SuspiciousActivity(ip: String, start: LocalDateTime, end: LocalDateTime, logins: Iterable[Login]) {

  override def toString: String = s"""$ip,${start.format(dtFormatter)},${end.format(dtFormatter)},"${logins.mkString(",")}"\n"""

}
