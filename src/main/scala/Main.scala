import scala.collection.mutable.ArrayBuffer

object Main extends App {

  val bufferedSource = io.Source.fromFile("/home/laitmatus/Downloads/my_data.csv")
  val l: ArrayBuffer[String] = ArrayBuffer.empty

  bufferedSource.
  for(line <- bufferedSource.getLines) {
      l.addOne(line)
  }

  println("******")

}