package scratch.utils

import scratch._
import scratch.InterfaceL0

object InterfaceUtils {
  
    def returnToLogin: Unit = {
        println("""
        returning to login menu...
        """)
        InterfaceL0.loginMenu 
    }
        
}
