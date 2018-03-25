package su.creator.bi_zone.utils

import java.time.LocalDateTime

object Order {

  implicit val localDateTimeOrdering: Ordering[LocalDateTime] = Ordering.fromLessThan[LocalDateTime](_ isBefore _)

}
