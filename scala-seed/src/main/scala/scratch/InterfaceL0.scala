package scratch

import scratch.users._
import scala.io.StdIn._

object InterfaceL0 {

  val welcomeMessage = """
  
  Hello! Welcome to the interface.

      () ()
      (^.^)    
      (   )O  
    """

  val whatDo = "What would you like to do?"

  val loginOptions = """
    [1] Create User
    [2] Log In
    [3] Quit
  """
  /** pushButton presents a user with menu options
    * and reads and returns an Int from the command line
    * a further method is required to make use of the user's chosen option
    * @param optionsMenu
    * @return Int
    */ 
  def pushButton(optionsMenu: String): Int = {
    
    // set var to 0 for use with While loop
    var userChoice = 0
    
    // reads userInput and catches an exception if input is not an Int
    // need to have exception/error handling for wrong numbers
    // use match?
    while (userChoice == 0) {
      try {
        println(" ")
        println(InterfaceL0.whatDo)
        println(optionsMenu)
        userChoice = readInt()
      } catch {
          case e: java.lang.NumberFormatException => {
            println(" ")
            println("Please input a number (Int)")          
          }
      }
    }
    // return userChoice so we can move on
    return userChoice
  }
 
  // define loginMenu
  def loginMenu: Unit = {
    var loginOption = InterfaceL0.pushButton(InterfaceL0.loginOptions)
    loginOption match {
      case 1 => println(""); println("[1] Create User"); println(""); CreateUser.createUser
      case 2 => {
        println("")
        println("[2] Log In")
        println("")
        UserLogin.userLoginMain // run loginUser here        
      }
      case 3 => println(""); println("[3] Quit"); println("") // quit the application (add a quit message)
      case _ => println(" "); println("Invalid option; try again."); loginMenu
    }
  }
  
}
