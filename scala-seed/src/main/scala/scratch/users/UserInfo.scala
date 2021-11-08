package scratch.users

import com.github.tototoshi.csv._

import scala.io.StdIn._

import java.io._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object UserInfo {
  
  var userInfoFileVar = new File("userInfo.csv")
  val userInfoHeader = List("userid", "username", "password")
  val adminInfo = List("0000", "admin", "admin")
  val demoUser = List("0001", "demo", "demo")

  /** uifStartup checks for an existing userInfo.csv
    * if none, uifStartup creates it
    * and writes default admin info
    */
  def uifStartup: Unit = {
    try {
        val uifr = CSVReader.open(userInfoFileVar)
        uifr.close()
    } catch {
        case e: java.io.FileNotFoundException => {
          println("""  
  userInfo file not found.
  creating userInfo file
          """)
          try {
            userInfoFileVar.createNewFile()
            val uifWriter = CSVWriter.open(userInfoFileVar)
            uifWriter.writeAll(List(userInfoHeader, adminInfo, demoUser))
            println("""  new userInfo file created with default admin user
            """)
            uifWriter.close()
          }  catch {
              case e: IOException => println("IOException")
          }
        }
    }
  }
}
