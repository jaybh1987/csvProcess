import scala.collection.mutable.ArrayBuffer

object Main extends App {

  val bufferedSource = io.Source.fromFile("/home/laitmatus/Downloads/my_data.csv")
  val l: ArrayBuffer[MyFile] = ArrayBuffer.empty

  def checkEmpty : String => Int = x => {
    try( Option[Int](x.toInt) ) catch {
      case _ => None
    }
  }.getOrElse(0)


  def mergeRows(x: MyFile, y: MyFile): MyFile = {
    //lets consider we will take all values on x
    MyFile(
      x.dept,
      x.vendor,
      x.model,
      x.category,
      x.style,
      x.colfin,
      x.desc1,
      x.desc2,
      x.cost,
      x.whs + y.whs,
      x.rgis_whs_qty + y.rgis_whs_qty,
      x.whs_qty_diff + y.whs_qty_diff,
      x.shw + y.shw,
      x.rgis_shw_qty + y.rgis_shw_qty,
      x.shw_qty_diff + y.shw_qty_diff,
      x.resd + y.resd,
      x.other + y.other,
      x.total_on_hand_qty + y.total_on_hand_qty,
      x.total_rgis_qty + y.total_rgis_qty,
      x.totalQtyDif + y.totalQtyDif,
      x.barcode
    )
  }

  for(line <- bufferedSource.getLines) {
    val word = line.split(",")
    l.addOne(
      MyFile(
        word(0),
        word(1),
        word(2),
        word(3),
        word(4),
        word(5),
        word(6),
        word(7),
        word(8),
        checkEmpty(word(9)),
        checkEmpty(word(10)),
        checkEmpty(word(11)),
        checkEmpty(word(12)),
        checkEmpty(word(13)),
        checkEmpty(word(14)),
        checkEmpty(word(15)),
        checkEmpty(word(16)),
        checkEmpty(word(17)),
        checkEmpty(word(18)),
        checkEmpty(word(19)),
        word(20).drop(1))
    )
  }

  val k = l.toSeq.groupBy{
    case x => x.barcode
  }.map {
    case (bar, ls) =>
      ls.reduce(mergeRows)
  }.toSeq



}


