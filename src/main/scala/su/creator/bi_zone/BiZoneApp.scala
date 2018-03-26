package su.creator.bi_zone

import java.io.File

import su.creator.bi_zone.LoginAnalyzer.groupData

import scala.util.control.NonFatal

object BiZoneApp extends App {

  def main(in: File, out: File, interval: Int): Unit = {
    val data = Csv.getData(in)
    val result = groupData(data, interval)
    Csv.postData(out, result)
  }

  require(args.length >= 2, "USAGE: java -jar bizoneapp.jar <input_file> <output_file> <interval_in_seconds = 3600>")

  val input = new File(args(0))
  val output = new File(args(1))
  val interval = if (args.length > 2) args(2) else "3600"

  try main(input, output, interval.toInt)
  catch {
    case NonFatal(e) =>
      System.err.print(e.getMessage)
      System.exit(1)
  }

}
