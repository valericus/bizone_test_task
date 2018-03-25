package su.creator.bi_zone

import java.io.File

import org.scalatest.{FlatSpec, Matchers}
import su.creator.bi_zone.TestHelpers._

class BiZoneAppSpec extends FlatSpec with Matchers {
  "BiZoneApp.main" should "do job" in {
    val tempFile = File.createTempFile("BiZoneAppTest-", ".csv")

    BiZoneApp.main("logins.csv", tempFile, 3600)

    readTextFile(tempFile) shouldBe readTextSource("/processed.csv")

    tempFile.delete
  }
}
