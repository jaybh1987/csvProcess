import scala.collection.mutable.ArrayBuffer

object Main extends App {

  val bufferedSource = io.Source.fromFile("/home/laitmatus/Downloads/my_data.csv")
  val l: ArrayBuffer[MyFile] = ArrayBuffer.empty

  for(line <- bufferedSource.getLines) {
    CSVUtil.add(l, line.split(","))
  }

  val k = CSVUtil.fileToWrite(l).foreach(println)
}


