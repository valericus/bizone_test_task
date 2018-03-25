package su.creator.bi_zone.model

import java.time.LocalDateTime

import su.creator.bi_zone.utils.DateTimeHelpers.dtFormatter

import scala.util.Try

case class LogEntry(user: String, ip: String, timestamp: LocalDateTime)

object LogEntry {

  implicit def stringToLocalDateTime(string: String): LocalDateTime = LocalDateTime.parse(string, dtFormatter)

  def apply(csvString: String): Option[LogEntry] = {
    val splited = csvString.split(',').map(_.replace("\"", ""))
    Try(LogEntry(splited.head, splited(1), splited.last)).toOption
  }

}