package scratch.utils

import scratch.users._
import scratch.utils._
import scratch.hiveQueries._
import scratch.twitter._

import com.github.tototoshi.csv._

import sttp.client3._
import sttp.client3.akkahttp._
import sttp.client3.json4s._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import scala.io.StdIn._
import java.io._

object TwitterUtils extends sttp.client3.SttpApi {

  val BEARER_TOKEN = keys.BEARER_TOKEN

  
  val volumeRequest = basicRequest
    .get(uri"https://api.twitter.com/2/tweets/sample/stream")
    .header(s"Authorization: Bearer $BEARER_TOKEN")

  val backend = HttpURLConnectionBackend()
  val response: Identity[Response[Either[String, String]]] = volumeRequest.send(backend)

}
