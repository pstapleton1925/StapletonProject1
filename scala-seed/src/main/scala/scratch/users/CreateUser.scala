package scratch.users

import scala.io.StdIn._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.github.tototoshi.csv._
import scratch.InterfaceL0

object CreateUser {

  def createUser: Unit = {

    val reader = CSVReader.open("userInfo.csv")
    val users = reader.all()
    reader.close()
    //println(users.toString()) // comment this out once done testing

    val newUserid = s"${LocalDateTime.now.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"))}_${users.length}"
    val inputUsername = readLine("Please input new userName: ") // test for uniqueness

    inputUsername match {
      case "admin" => {
        println("""
        admin user already exists
        """)
        createUser
      }
      case _ => {
        val checkMatch = usernameMatching
        checkMatch match {
          case true => createUser
          case false => {
            println(s"""
            your new username is $inputUsername
            """)
            passwordCheck
          }
        }
      }
    }

    def usernameMatching: Boolean = {

      val usersChecklist = users.flatten

      if (usersChecklist.contains(inputUsername) == true ) {
        println(s"""
        username: $inputUsername is already in use
        """)
        return true
      } else return false
    }
      
    def passwordCheck: Unit = {
      val inputPassword = readLine("""
      Please input new password: 
        """)
      inputPassword match {
        case "0" => InterfaceL0.loginMenu
        case _ => {
          val confirmPassword = readLine("""
          Please confirm new password:
          """)
          confirmPassword match {
            case "0" => InterfaceL0.loginMenu
            case _ => {
              if (inputPassword == confirmPassword) {
              println("""
              Password confirmed
              """)
              val newUser = List(newUserid, inputUsername, inputPassword)
              addUser(newUser)
              } else {
                println("""
                Passwords don't match
                """)
                passwordCheck
              }
            }
          }           
        }
      }      
    }

    def addUser(userinfolist: List[String]): Unit = {
      val writer = CSVWriter.open("userInfo.csv", append = true)
      writer.writeRow(userinfolist)
      writer.close()
      println("""
      user added
      """)
      InterfaceL0.loginMenu
    }

  }

}
