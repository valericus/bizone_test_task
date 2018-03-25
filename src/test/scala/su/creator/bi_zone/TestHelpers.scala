package su.creator.bi_zone

import java.io.File

import scala.io.Source

object TestHelpers {

  implicit def resourceAsFile(path: String): File = new File(ClassLoader.getSystemResource(path).toURI)

  def readTextFile(file: File): String = Source.fromFile(file).getLines.filter(_.nonEmpty).mkString("\n")

  def readTextSource(path: String): String = Source.fromInputStream(getClass.getResourceAsStream(path)).getLines.filter(_.nonEmpty).mkString("\n")

}
