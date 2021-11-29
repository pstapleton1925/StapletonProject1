package scratch.utils

import scratch.users._
import scratch.utils._
import scratch.hiveQueries._
import scratch.twitter._

import com.github.tototoshi.csv._

import sttp.client3._
import sttp.model._
import sttp.client3.akkahttp._
import sttp.client3.json4s._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import scala.io.StdIn._
import java.io._

object TwitterUtils extends sttp.client3.SttpApi {

  val BEARER_TOKEN = keys.BEARER_TOKEN
  val auth = s"Authorization: Bearer $BEARER_TOKEN"

  val volumeEndpoint: Uri = uri"https://api.twitter.com/2/tweets/sample/stream"

  implicit val serialization = org.json4s.native.Serialization
  implicit val formats = org.json4s.DefaultFormats

  case class HttpBinResponse(origin: String, headers: Map[String, String])
  
  val volumeRequest = basicRequest
    .header
    .get(volumeEndpoint)
    .response(asJson[HttpBinResponse])

  val backend: SttpBackend[Future, Any] = AkkaHttpBackend()
  val response: Future[Response[Either[ResponseException[String, Exception], HttpBinResponse]]] =
    volumeRequest.send(backend)

  for {
    r <- response
  } {
    println(s"Got response code: ${r.code}")
    println(r.body)
    backend.close()
  }

}
