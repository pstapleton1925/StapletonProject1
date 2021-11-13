package scratch.users

import scratch._
import scala.io.StdIn._
import com.github.tototoshi.csv._

object DeleteUser {

  def userDeleteMain: Unit = {

    val reader = CSVReader.open("userInfo.csv")
    val users = reader.all()
    reader.close()
    println(users.toString()) // comment this out once done testing

    val usernameInput = readLine("""
    Which user would you like to delete?

    Please input username or input 0 to return to the login menu

    """)    

    usernameInput match {
      case "0" => {
        println("""
        returning to login menu...
        """)
        InterfaceL0.loginMenu         
      }
      case "admin" => {
          println("""
          admin user cannot be deleted
          """)
          userDeleteMain
      }
      case _ => {
        println("""
          finding username...
          """)
        var userFound = usernameMatching
        userFound match {
          case true => userDeletePassword
          case false => {
            println("""
            user not found
            """)
            userDeleteMain
          }
        } 
      }
    }

    def userDeletePassword: Unit = {

      val passwordInput = readLine(s"""
      Please input password to confirm deletion of user $usernameInput
      OR input 0 to return to the login menu

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
        val passCheck = passwordMatching(passwordInput)
        passCheck match {
          case true => {
          println(s"""
          deleting user $usernameInput...
          """)
          // delete functionality          
          }
          case false => {
            println("""
            wrong password...
            """)
            userDeletePassword
          }
        }
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

    def passwordMatching(passwordInput: String): Boolean = {

      val passwordChecklist = users.flatten
      val userIndex = passwordChecklist.indexOf(usernameInput)
      val passwordIndex = userIndex + 1

      if (passwordChecklist(passwordIndex) == passwordInput) {
        println("""
        password is correct
        """)
        return true
      } else return false
    }    
  }
}
