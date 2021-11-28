package scratch

import scratch.users._
import scratch.utils._
import scratch.hiveQueries._

import sttp.client3._
import com.github.tototoshi.csv._

import scala.io.StdIn._
import java.io._

object Main extends App {

  UserInfo.uifStartup

  println(InterfaceL0.welcomeMessage)
  
  // twitter test
  //utils.ParseTwitterData

  // test HiveConnect
  //HiveConnect.connectHive

  // test loginMenu
  InterfaceL0.loginMenu

  //test deleteUsers
  //DeleteUser
  


}