package scratch.users

import scratch._
import scala.io.StdIn._
import com.github.tototoshi.csv._

object UserLogin {

  def userLoginMain: Unit = {

    val reader = CSVReader.open("userinfo.csv")
    val users = reader.all()
    reader.close()
    println(users.toString()) // comment this out once done testing

    val usernameInput = readLine("Please input username or input 0 to return to the login menu")    

    usernameInput match {
      case "0" => println("returning to login menu..."); InterfaceL0.loginMenu //okay this only spirals, need to fix
      case _ => println("finding username...") //put some functionality here
    }

    val passwordInput = readLine("Please input password or input 0 to return to the login menu")

    passwordInput match {
      // case password = User(password) => move on to application
      // case _ => reprompt for password
      case "0" => println("returning to login menu..."); InterfaceL0.loginMenu
    }
  }
}
