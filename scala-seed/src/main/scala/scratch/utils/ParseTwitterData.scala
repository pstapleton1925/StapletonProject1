package scratch.utils

import scala.io.Source
import scala.io.StdIn._
import java.io._

case class TwitterData(
    id: Long,
    text: String
)

object ParseTwitterData {
  val placeholder = "placeholder"
}