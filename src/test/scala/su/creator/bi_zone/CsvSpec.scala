package su.creator.bi_zone

import java.io.File
import java.time.LocalDateTime

import org.scalatest.{FlatSpec, Matchers}
import su.creator.bi_zone.TestHelpers._
import su.creator.bi_zone.model.{LogEntry, Login, SuspiciousActivity}
import su.creator.bi_zone.utils.DateTimeHelpers

import scala.io.Source

class CsvSpec extends FlatSpec with Matchers {

  implicit def strToLDT(string: String): LocalDateTime = LocalDateTime.parse(string, DateTimeHelpers.dtFormatter)

  "Csv" should "read log file" in {
    val expectedResult = List(
      LogEntry("boyboy11", "94.254.198.11", "2015-11-30 23:16:47"),
      LogEntry("Wiola193", "94.254.198.11", "2015-11-30 23:17:25"),
      LogEntry("Stefan123", "94.254.198.11", "2015-11-30 23:17:21"),
      LogEntry("username25", "50.160.168.157", "2015-11-30 23:17:48"),
      LogEntry("trashx", "50.160.168.157", "2015-11-30 23:17:56"),
      LogEntry("Clear94", "31.162.217.43", "2015-11-30 23:17:58"),
      LogEntry("monsterlabel", "179.233.26.140", "2015-11-30 23:18:32")
    )
    val actualResult = Csv.getData("logins.csv")

    actualResult shouldBe expectedResult
  }

  it should "write analisys result" in {
    val input = List(
      SuspiciousActivity(
        "94.254.198.11",
        "2015-11-30 23:16:47",
        "2015-11-30 23:17:25",
        List(
          Login("boyboy11", "2015-11-30 23:16:47"),
          Login("Wiola193", "2015-11-30 23:17:25"),
          Login("Stefan123", "2015-11-30 23:17:21")
        )
      ),
      SuspiciousActivity(
        "50.160.168.157",
        "2015-11-30 23:17:48",
        "2015-11-30 23:17:56",
        List(
          Login("username25", "2015-11-30 23:17:48"),
          Login("trashx", "2015-11-30 23:17:56")
        )
      )
    )

    val tempFile = File.createTempFile("BiZoneAppTest-", ".csv")
    Csv.postData(tempFile, input)

    readTextFile(tempFile) shouldBe readTextSource("/processed.csv")

    tempFile.delete
  }

}
