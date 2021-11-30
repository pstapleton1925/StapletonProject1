package scratch.utils

import com.github.tototoshi.csv._
import scala.io.StdIn._
import java.io._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object CsvUtils {

  val placeholder = ""
  var testDataFP = "testData.csv"
  var testDataFile = new File(testDataFP)

  def newCSV(nf: String): Unit = {
    val file = new File(nf)
    file.createNewFile()
  }

  def tryNewCSV(nf: String): Unit = {
    try {            
      newCSV(nf)
    }  catch {
        case e: IOException => println("IOException")
      }
  }

  def writeAll(fn: String, data: List[List[String]]): Unit = {
    val writer = CSVWriter.open(fn)
    writer.writeAll(data)
    writer.close()
  }

  val timestamp = LocalDateTime.now.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"))
  def genFileName(endpoint: String): String = timestamp + "_" + endpoint + ".csv"

  def twitCSV(endpoint: String, data: List[List[String]]): Unit = {
    val newFn = genFileName(endpoint)
    tryNewCSV(newFn)
    writeAll(newFn, data)
  }
}
