package scratch.utils

import com.github.tototoshi.csv._
import scala.io.StdIn._
import java.io._

object CsvUtils {

    val inputFileAsk = """
    Please name the file you would like to create
    """
    val wrongInput = """
    incorrect input. please try again
    """
    val placeholder = ""
    val yn = """
    [1] Yes [2] No
    """
    var testDataFP = "testData.csv"
    var testDataFile = new File(testDataFP)

    def chooseYN: Unit = {
      def num: Int = {
        try{
            println(yn)
            readInt()
        } catch {
            case _: Throwable => println(wrongInput); num
          }
      }
      num match {
        case 1 => println(placeholder)
        case 2 => println(placeholder)
      }
    }

    def newCSV(nf: String): Unit = {
      val file = new File(nf)
      println("""
      creating new file...
      """)
      file.createNewFile()
      println("""
      new file created.
      """)
    }

    def tryNewCSV(nf: String): Unit = {
      try {            
        newCSV(nf)
      }  catch {
          case e: IOException => println("IOException")
        }
    }

    def nameThatFile: String = readLine(inputFileAsk)

    def findFile(testData: List[List[String]]): Unit = {
    try {
        val reader = CSVReader.open(testDataFile)
        reader.close()
    } catch {
        case e: java.io.FileNotFoundException => {
          println(""" 
          file not found.

          would you like to create one?
          """)          
        }
      }
    }
}
