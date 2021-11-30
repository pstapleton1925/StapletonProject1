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

object TwitterUtils {

  val testEndpoint = "https://api.twitter.com/2/tweets?ids=1465421999983976456";
  val volumeEndpoint = "https://api.twitter.com/2/tweets/sample/stream";
  val searchAcnhEndpoint = """
    https://api.twitter.com/2/tweets/search/recent?max_results=100&query="animal crossing" OR "animal crossing:" OR "acnh" OR %23acnh OR %23animalcrossing
    """
    .stripMargin;
    
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

  def saveTDasCSV: Unit = {
    
  }

}