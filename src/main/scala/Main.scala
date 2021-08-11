import com.github.tototoshi.csv.CSVWriter

import java.io.File
import scala.collection.mutable.ArrayBuffer

object Main extends App {

  val bufferedSource = io.Source.fromFile("/home/laitmatus/Downloads/my_data.csv")
  val l: ArrayBuffer[MyFile] = ArrayBuffer.empty

  for(line <- bufferedSource.getLines) {
    CSVUtil.add(l, line.split(","))
  }

  val k = CSVUtil.fileToWrite(l)

  val f = new File("/home/laitmatus/Desktop/out.csv")

  val writer = CSVWriter.open(f)
  //now using library so converdata functiona added. need to replace old code with library features.
  writer.writeAll(  k.map( r => CSVUtil.convertData(r) ) )

  writer.close()

}


