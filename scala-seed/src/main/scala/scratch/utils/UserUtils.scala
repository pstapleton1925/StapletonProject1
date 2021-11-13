package scratch.utils

import scala.io.StdIn._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.github.tototoshi.csv._
import scratch.InterfaceL0

object UserUtils {

  def getUserInfo: List[List[String]] = {
    val reader = CSVReader.open("userInfo.csv")
    val users = reader.all()
    reader.close()
    return users
  }

  def userFound(inputUsername: String, usersFlat: List[String]): Boolean = {

    println("""
          finding username...
          """)

    if (usersFlat.contains(inputUsername) == true ) {
        println(s"""
        username: $inputUsername found
        """)
        return true
    } else return false
    
  }

  def passwordCorrect(inputUsername: String, inputPassword: String, usersFlat: List[String]): Boolean = {

    val userIndex = usersFlat.indexOf(inputUsername)
    val passwordIndex = userIndex + 1

    println("""
        finding password...
        """)

    if (usersFlat(passwordIndex) == inputPassword) {
        println("""
        password is correct
        """)
        return true
    } else return false
  }

}
