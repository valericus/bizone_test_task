package su.creator.bi_zone.model

import java.time.{LocalDate, LocalDateTime}

import org.scalatest.{FlatSpec, Matchers, MustMatchers}

class LogEntrySpec extends FlatSpec with Matchers {

  "LogEntry.stringToLocalDateTime" should "parse strings to LocalDateTime" in {
    val input = "2015-11-30 23:23:19"
    val expected = LocalDateTime.of(2015, 11, 30, 23, 23, 19)
    LogEntry.stringToLocalDateTime(input) shouldBe expected
  }

  "LogEnrty.apply" should "create correct LogEntry from CSV string" in {
    val input = """"bjbjbj","23.27.250.249","2015-11-30 23:23:19""""
    val expected = LogEntry("bjbjbj", "23.27.250.249", LocalDateTime.of(2015, 11, 30, 23, 23, 19))
    LogEntry.apply(input) shouldBe Some(expected)
  }

  it should "return None for bad lines in CSV" in {
    LogEntry.apply("qefqbcdwqwq") shouldBe None
  }

}
