package scratch.utils

import scala.io.Source
import scala.io.StdIn._
import java.io._

import net.liftweb.json.DefaultFormats
import net.liftweb.json._

case class TwitterObject(
  id: String,
  text: String
)
case class TwitterData(
  data: Array[TwitterObject]
)

object ParseTwitterData {

  implicit val formats = DefaultFormats

  def getTweets(dataString: String): List[List[String]] = {
    val json = parse(dataString)
    val tweetsRaw = (json \\ "data").children
    val tweetsExtracted = tweetsRaw.map(_.extract[TwitterObject]) 
    val tweetsListList = tweetsExtracted.map(twitterObjToList(_))
    return tweetsListList
  }

  def twitterObjToList(tweet: TwitterObject): List[String] = {
    val id = tweet.id
    val text = tweet.text
    val tList = List(id, text)
    return tList
  }

  
}