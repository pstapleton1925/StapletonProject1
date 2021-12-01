package scratch

import scratch.users._
import scratch.utils._
import scratch.hiveQueries._

import com.github.tototoshi.csv._

import scala.io.StdIn._
import java.io._

object Main extends App {

  val twit = utils.TwitterUtils
  val csvu = utils.CsvUtils

  //UserInfo.uifStartup

  //println(InterfaceL0.welcomeMessage)
  
  // twitter test
  println("")
  println(twit.twitterApi(twit.testEndpoint))
  println("")
  println(twit.getTweets(twit.twitterApi(twit.testEndpoint)).mkString("/n"))
  println("")
  //csvu.twitCSV("test", twit.getTweets(twit.twitterApi(twit.testEndpoint)))

  

  // test HiveConnect
  //HiveConnect.connectHive

  // test loginMenu
  //InterfaceL0.loginMenu

  //test deleteUsers
  //DeleteUser
  


}