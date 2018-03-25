package su.creator.bi_zone

import java.time.ZoneOffset

import su.creator.bi_zone.model.{LogEntry, Login, SuspiciousActivity}
import su.creator.bi_zone.utils.Order.localDateTimeOrdering

object LoginAnalyzer {

  def groupData(data: List[LogEntry], timeInterval: Int): Iterable[SuspiciousActivity] = {
    val result = data.groupBy(_.ip).map {
      case (ip, loginEntries) =>
        ip -> loginEntries
          .groupBy(_.timestamp.toEpochSecond(ZoneOffset.UTC) / timeInterval)
          .values.filter(_.size > 1)
    }

    result.flatMap { case (ip, entries) =>
      entries.map { activity =>
        val timestamps = activity.map(_.timestamp)
        SuspiciousActivity(
          ip,
          timestamps.min,
          timestamps.max,
          activity.map(e => Login(e.user, e.timestamp))
        )
      }
    }
  }

}
