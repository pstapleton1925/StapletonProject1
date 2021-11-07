package scratch.twitter

import scala.io.StdIn._
import scala.sys.process._

import java.io._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.github.tototoshi.csv._

object TwitterDataUtils {

    def getTwitterData(inputFromDate: String, inputToDate: String) {
      
      val outputFile = new File(
        s"${LocalDateTime.now.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"))}_TwitterData.txt")
      
      outputFile.createNewFile()

      val twitterInputBase: String = """curl --request POST \
  --url https://api.twitter.com/1.1/tweets/search/30day/sp1.json \
  --header 'authorization: Bearer AAAAAAAAAAAAAAAAAAAAAANqVQEAAAAAdfYY03Ms3lCFMESXRcqjEd5pFBw%3DUIx69v5lx73tgjEgzMoJNnAugKbmVFemr2QhXFwuOoivxehf48
' \
  --header 'content-type: application/json' \
  --data '{
                "query":"(“animal crossing” OR “animal crossing:” OR “acnh” OR #animalcrossing OR #acnh)",
                "maxResults": "100",
                "fromDate":"iFromDate", 
                "toDate":"iToDate"
                }'"""

      val twitterInput: String = {
        twitterInputBase.replaceAll("iFromDate", s"$inputFromDate")
        twitterInputBase.replaceAll("iToDate", s"$inputToDate")
      }
    
      val outputFilebw = new BufferedWriter(new FileWriter(outputFile))
      outputFilebw.write(twitterInput.!!)
      outputFilebw.close()

    }

    def getTwitterData(inputFromDate: String, inputToDate: String, nextKey: String) {
      
      val outputFile = new File(
        s"${LocalDateTime.now.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"))}_TwitterData.txt")
      
      outputFile.createNewFile()

      val twitterInputBase: String = """curl --request POST \
  --url https://api.twitter.com/1.1/tweets/search/30day/sp1.json \
  --header 'authorization: Bearer AAAAAAAAAAAAAAAAAAAAAANqVQEAAAAAdfYY03Ms3lCFMESXRcqjEd5pFBw%3DUIx69v5lx73tgjEgzMoJNnAugKbmVFemr2QhXFwuOoivxehf48
' \
  --header 'content-type: application/json' \
  --data '{
                "query":"(“animal crossing” OR “animal crossing:” OR “acnh” OR #animalcrossing OR #acnh)",
                "maxResults": "100",
                "fromDate":"iFromDate", 
                "toDate":"iToDate"
                }'"""

      val twitterInput: String = {
        twitterInputBase.replaceAll("iFromDate", s"$inputFromDate")
        twitterInputBase.replaceAll("iToDate", s"$inputToDate")
      }
    
      val outputFilebw = new BufferedWriter(new FileWriter(outputFile))
      outputFilebw.write(twitterInput.!!)
      outputFilebw.close()
      
    }
  
}
