package scratch.utils

import scratch.users._
import scratch.utils._
import scratch.hiveQueries._
import scratch.twitter._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import scala.io.StdIn._
import java.io._

import com.github.tototoshi.csv._

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.config.CookieSpecs

import net.liftweb.json.DefaultFormats
import net.liftweb.json._

object TwitterUtils {

  case class TweetData(id: String, text: String)

  case class TwitterData(data: Array[TweetData])

  case class MetaData(newest_id: String, oldest_id: String, result_count: Int, next_token: String)

  case class TwitterMeta(meta: List[MetaData])

  var next_token = ""

  implicit val formats = DefaultFormats

  val testEndpoint = "https://api.twitter.com/2/tweets?ids=1465421999983976456"
  val volumeEndpoint = "https://api.twitter.com/2/tweets/sample/stream"
  val searchAcnhEndpoint = "https://api.twitter.com/2/tweets/search/recent?max_results=100&query=%22animal%20crossing%22%20OR%20%22animal%20crossing:%22%20OR%20%22acnh%22%20OR%20%23acnh%20OR%20%23animalcrossing"
  val searchAcnhEndpointWithNext = s"https://api.twitter.com/2/tweets/search/recent?max_results=100&next_token=${next_token}&query=%22animal%20crossing%22%20OR%20%22animal%20crossing:%22%20OR%20%22acnh%22%20OR%20%23acnh%20OR%20%23animalcrossing"

  def twitterApi(url: String): String = {

    val httpClient = HttpClientBuilder.create()
      .setDefaultRequestConfig(RequestConfig.custom()
        .setCookieSpec(CookieSpecs.STANDARD).build())
      .build();

    val get = new HttpGet(url)
    get.setHeader("Content-Type", "application/json")
    get.setHeader("Authorization", s"Bearer ${keys.BEARER_TOKEN}");

    val httpResponse = httpClient.execute(get)
    val entity = httpResponse.getEntity()
    var content = ""

    if (entity != null) {
      val inputStream = entity.getContent()
      content = scala.io.Source.fromInputStream(inputStream).getLines().mkString
      inputStream.close
    }

    httpClient.close()
    return content
  }

  def getTweets(dataString: String): List[List[String]] = {
    val json = parse(dataString)
    val tweetsRaw = (json \\ "data").children
    val tweetsExtracted = tweetsRaw.map(_.extract[TweetData]) 
    val tweetsListList = tweetsExtracted.map(twitObjToList(_))
    return tweetsListList
  }

  def twitObjToList(tweet: TweetData): List[String] = {
    val id = tweet.id
    val text = tweet.text
    val tList = List(id, text)
    return tList
  }

  def getNextToken(metaString: String): String = {
    val json = parse(metaString)
    val metaRaw = (json \\ "meta").children
    val metaExtrList = metaRaw.map(_.extract[MetaData])
    val metaExtracted = metaExtrList(0)
    return metaExtracted.next_token
  }

}