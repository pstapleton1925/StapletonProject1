package scratch.hiveQueries

import java.io.IOException

import scala.util.Try

import java.sql.SQLException
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.sql.DriverManager

object HiveConnect {
  def connectHive: Unit = {

      println("""
      Connecting to Hive...
      """)

      var hiveCon: java.sql.Connection = null
      try {
          var driverName = "org.apache.hive.jdbc.HiveDriver"
          val hiveConStr = "jdbc:hive2://"

          Class.forName(driverName)

          hiveCon = DriverManager.getConnection(hiveConStr, "", "")
          val stmt = hiveCon.createStatement()
          stmt.executeQuery("Show databases")
          System.out.println("show database successfully")

      } catch {
          case ex: Throwable => {
              ex.printStackTrace();
              throw new Exception(s"${ex.getMessage}")
            }
          } finally {
            try {
            if (hiveCon != null)
                hiveCon.close();
            } catch {
                case ex: Throwable => {
                  ex.printStackTrace();
                  throw new Exception(s"${ex.getMessage}")
                }
            }
        }
    }
}
