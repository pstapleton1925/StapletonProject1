package scratch.users

import scala.io.StdIn._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.github.tototoshi.csv._

object CreateUser {

  def createUser: Unit = {

    val reader = CSVReader.open("userinfo.csv")
    val users = reader.all()
    reader.close()
    println(users.toString()) // comment this out once done testing

    val newUserid = s"${LocalDateTime.now.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"))}_${users.length}"
    val inputUsername = readLine("Please input new userName: ") // test for uniqueness
    val inputPassword = readLine("Please input new password: ")
    val newUser = User(newUserid, inputUsername, inputPassword) // may need to just use List instaed of User

  }

}
