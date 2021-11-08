package scratch

import scratch.users._
import scratch.twitter._
import com.github.tototoshi.csv._

import scala.io.StdIn._
import java.io._

object Main extends App {

  UserInfo.uifStartup

  println(InterfaceL0.welcomeMessage)
  
  // twitter test
  //TwitterDataUtils.getTwitterData(readLine("fromDate (YYYYMMddHHmm: "), readLine("toDate (YYYYMMddHHmm): "))

  // test loginMenu
  InterfaceL0.loginMenu
  
  

}