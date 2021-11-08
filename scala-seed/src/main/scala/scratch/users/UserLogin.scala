package scratch.users

import scratch._
import scala.io.StdIn._
import com.github.tototoshi.csv._

object UserLogin {

  def userLoginMain: Unit = {

    val reader = CSVReader.open("userInfo.csv")
    val users = reader.all()
    reader.close()
    println(users.toString()) // comment this out once done testing

    val usernameInput = readLine("""
    Please input username or input 0 to return to the login menu

    """)    

    usernameInput match {
      case "0" => {
        println("""
        returning to login menu...
        """)
        InterfaceL0.loginMenu         
      }
      case "admin" => userLoginPassword
      case _ => {
        println("""
          finding username...
          """)
        var userFound = usernameMatching
        userFound match {
          case true => userLoginPassword
          case false => {
            println("""
            user not found
            """)
            userLoginMain
          }
        } 
      }
    }

    def userLoginPassword: Unit = {

      val passwordInput = readLine("""
      Please input password or input 0 to return to the login menu

      """)
      
      passwordInput match {
        // case password = User(password) => move on to application        
        case "0" => {
        println("""
        returning to login menu...
        """)
        InterfaceL0.loginMenu        
        }
        case _ => println("""
        finding password...
        """)
        passwordMatching(passwordInput)
      }

    }

    def usernameMatching: Boolean = {

      val usersChecklist = users.flatten

      if (usersChecklist.contains(usernameInput) == true ) {
        println(s"""
        username: $usernameInput found
        """)
        return true
      } else return false
    }

    def passwordMatching(passwordInput: String): Unit = {

      val passwordChecklist = users.flatten
      val userIndex = passwordChecklist.indexOf(usernameInput)
      val passwordIndex = userIndex + 1

      if (passwordChecklist(passwordIndex) == passwordInput) {
        println("""
        password is correct
        """)
      }
    }    
  }
}
