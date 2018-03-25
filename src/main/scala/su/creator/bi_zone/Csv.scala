package su.creator.bi_zone

import java.io.{File, PrintWriter}
import java.time.LocalDateTime

import su.creator.bi_zone.model.{LogEntry, SuspiciousActivity}

import scala.io.Source

object Csv {

  implicit def dateTimeOrdering: Ordering[LocalDateTime] = Ordering.fromLessThan(_ isBefore _)

  def getData(file: File): List[LogEntry] = Source.fromFile(file).getLines
    .flatMap(LogEntry(_))
    .toList

  def postData(file: File, data: Iterable[SuspiciousActivity]): Unit = {
    val pw = new PrintWriter(file)
    data.foreach(i => pw.write(i.toString))
    pw.close()
  }

}
