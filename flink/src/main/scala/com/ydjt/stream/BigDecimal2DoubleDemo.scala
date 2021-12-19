package com.ydjt.stream

object BigDecimal2DoubleDemo {
  def main(args: Array[String]): Unit = {
    val decimal = BigDecimal("-1.717986918E-1090643202")
    println(decimal.asInstanceOf[Number].floatValue())
  }
}
