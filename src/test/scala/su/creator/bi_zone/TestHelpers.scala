package su.creator.bi_zone

import java.io.{File, PrintWriter}

import scala.io.Source

trait TestHelpers {

  implicit def resourceAsFile(path: String): File = {
    val tempFile = File.createTempFile("BiZoneApp-", ".csv")
    tempFile.deleteOnExit()

    val pw = new PrintWriter(tempFile)
    Source.fromInputStream(getClass.getResourceAsStream(path)).getLines.map(_ + "\n").foreach(pw.write(_))
    pw.close()

    tempFile
  }

  def readTextFile(file: File): String = Source.fromFile(file).getLines.filter(_.nonEmpty).mkString("\n")

  def readTextSource(path: String): String = Source.fromInputStream(getClass.getResourceAsStream(path)).getLines.filter(_.nonEmpty).mkString("\n")

}
