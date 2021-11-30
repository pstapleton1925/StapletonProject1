package scratch

import scratch.users._
import scratch.utils._
import scratch.hiveQueries._

import com.github.tototoshi.csv._

import scala.io.StdIn._
import java.io._

object Main extends App {

  val twit = utils.TwitterUtils
  val twitParse = utils.ParseTwitterData

  //UserInfo.uifStartup

  //println(InterfaceL0.welcomeMessage)
  
  // twitter test
  println("")
  println(twit.twitterApi(twit.testEndpoint))
  println("")
  println(twitParse.getTweets(twit.twitterApi(twit.testEndpoint)).toString())
  println("")

  // test HiveConnect
  //HiveConnect.connectHive

  // test loginMenu
  //InterfaceL0.loginMenu

  //test deleteUsers
  //DeleteUser
  


}