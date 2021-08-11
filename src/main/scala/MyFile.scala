import Main.{checkEmpty, l}

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
}
