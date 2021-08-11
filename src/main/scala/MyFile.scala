import scala.collection.mutable.ArrayBuffer

case class MyFile(
  dept: String,
  vendor: String,
  model: String,
  category: String,
  style: String,
  colfin: String,
  desc1: String,
  desc2: String,
  cost: String,
  whs: Int,
  rgis_whs_qty: Int,
  whs_qty_diff: Int,
  shw: Int,
  rgis_shw_qty: Int,
  shw_qty_diff: Int,
  resd: Int,
  other: Int,
  total_on_hand_qty: Int,
  total_rgis_qty: Int,
  totalQtyDif: Int,
  barcode: String
 )


object CSVUtil {


 def checkEmpty : String => Int = x => {
  try( Option[Int](x.toInt) ) catch {
   case _ => None
  }
 }.getOrElse(0)

 def add(l: ArrayBuffer[MyFile], word: Array[String]): ArrayBuffer[MyFile] = {
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
  l
 }


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

  def fileToWrite(data: ArrayBuffer[MyFile]): Seq[MyFile] = {
   data.toSeq.groupBy{
     case x => x.barcode
    }.map {
     case (bar, ls) =>
      ls.reduce(mergeRows)
    }.toSeq
  }

 def convertData(x: MyFile) = {
  Seq(
   x.dept,
   x.vendor,
   x.model,
   x.category,
   x.style,
   x.colfin,
   x.desc1,
   x.desc2,
   x.cost,
   x.whs,
   x.rgis_whs_qty,
   x.whs_qty_diff,
   x.shw,
   x.rgis_shw_qty,
   x.shw_qty_diff,
   x.resd,
   x.other,
   x.total_on_hand_qty,
   x.total_rgis_qty,
   x.totalQtyDif,
   x.barcode)
 }

}
