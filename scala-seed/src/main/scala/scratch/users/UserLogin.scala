package scratch.users

import scratch._
import scratch.utils.UserUtils
import scratch.utils.InterfaceUtils

import scala.io.StdIn._
import com.github.tototoshi.csv._

object UserLogin {

  def userLoginMain: Unit = {

    val users = UserUtils.getUserInfo
    val usersFlat = users.flatten
    // println(users.toString()) // comment this out once done testing

    val usernameInput = readLine("""
    Please input username or input 0 to return to the login menu

    """)    

    usernameInput match {
      case "0" => InterfaceUtils.returnToLogin
      case "admin" => userLoginPassword
      case _ => {        
        var userFoundBool = UserUtils.userFound(usernameInput, usersFlat)
        userFoundBool match {
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
        case "0" => InterfaceUtils.returnToLogin
        case _ => {
        
          val passCheck = UserUtils.passwordCorrect(usernameInput,passwordInput, usersFlat)

          passCheck match {
            case true => {
              println(s"""
              logging in user $usernameInput...
              """)
              // login functionality
              usernameInput match {
              case "admin" => println("opening admin menu...") //admin menu
              case _ => println("opening user menu...") //user menu
              }
            }
            case false => {
              println("""
              wrong password...
              """)
              userLoginPassword
            }
          }
        }
      }

    }

  }

}
