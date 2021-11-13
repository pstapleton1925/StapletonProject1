package scratch.utils

import scala.io.Source
import scala.io.StdIn._
import java.io._

import net.liftweb.json.DefaultFormats
import net.liftweb.json._

case class TwitterData(
    id: Long,
    text: String
)

object ParseTwitterData {

  implicit val format = DefaultFormats

  val filePathName = {
  readLine("""
  please input json filepath:
    """)
  }

  val jsonData = scala.io.Source.fromFile(filePathName).mkString
  //val jsonData = jsonFile.mkString()

  val json = parse(jsonData)
  val elements = (json \\ "data").children
  for (tweet <- elements) {
    val m = tweet.extract[TwitterData]
    println(s"Tweet: ${m.id}, ${m.text}")
  }
}