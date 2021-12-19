//package com.ydjt.stream.udf
//
//import org.apache.flink.table.api._
//import org.apache.flink.table.functions.ScalarFunction
//
//class Str2Double (val endInclusive:String) extends ScalarFunction{
//
//  def eval(s: String): Double = {
//    s.toDouble
//  }
//}
