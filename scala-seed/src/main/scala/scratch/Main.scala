package scratch

import scratch.users._
import scratch.utils._
import scratch.hiveQueries._

import com.github.tototoshi.csv._

import scala.io.StdIn._
import java.io._

object Main extends App {

  //UserInfo.uifStartup

  //println(InterfaceL0.welcomeMessage)
  
  // twitter test
  println(utils.TwitterUtils.twitterApi(utils.TwitterUtils.testEndpoint))

  // test HiveConnect
  //HiveConnect.connectHive

  // test loginMenu
  //InterfaceL0.loginMenu

  //test deleteUsers
  //DeleteUser
  


}