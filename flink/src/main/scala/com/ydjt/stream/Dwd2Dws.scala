package com.ydjt.stream

import com.ydjt.stream.until.ConnHBase
import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.hadoop.hbase.client.{Connection, HTable, Result, Scan}
import org.apache.flink.api.scala._
import org.apache.flink.addons.hbase.TableInputFormat
import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.java.tuple
import org.apache.flink.configuration.Configuration
import org.apache.hadoop.hbase.{Cell, TableName}
import org.apache.hadoop.hbase.util.Bytes


object Dwd2Dws {

  def main(args: Array[String]): Unit = {
    val envSet: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
//    val envStream: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    //获取两部分数据源
    //    DWD_YDJT_SCALEANDINC_DATE
    val hbaseData: DataSet[tuple.Tuple2[String, String]] = envSet.createInput(inputFormat = new TableInputFormat[tuple.Tuple2[String, String]] {
      override def configure(parameters: Configuration): Unit = {
        val conn: Connection = new ConnHBase().connToHbase
        table = classOf[HTable].cast(conn.getTable(TableName.valueOf("DWD_YDJT_SCALEANDINC_DATE")))
        scan = new Scan()
        scan.addFamily(Bytes.toBytes("info"))
      }

      override def getScanner: Scan = {
        scan
      }

      override def getTableName: String = {
        "DWD_YDJT_SCALEANDINC_DATE"
      }

      override def mapResultToTuple(r: Result): tuple.Tuple2[String, String] = {
        val rowKey: String = Bytes.toString(r.getRow)
        val sb = new StringBuffer()
//        val sbh = new StringBuffer()
        for (cell: Cell <- r.rawCells()) {
          val columnKey: String = Bytes.toString(cell.getQualifierArray, cell.getQualifierOffset, cell.getQualifierLength)
          sb.append(columnKey).append(",")
//          if (columnKey.equals("businessIncome") || columnKey.equals("businessScale")){
//            val value: String = Bytes.toString(cell.getValueArray, cell.getValueOffset, cell.getValueLength)
//            sb.append(value).append(",")
//          }

          val value: String = Bytes.toString(cell.getValueArray, cell.getValueOffset, cell.getValueLength)
          sb.append(value).append(",")
        }
        val valueString: String = sb.replace(sb.length() - 1, sb.length(), "").toString
        val tuple2 = new tuple.Tuple2[String, String]()
        tuple2.setField(rowKey, 0)
        tuple2.setField(valueString, 1)
        tuple2
      }
    })


    hbaseData.print()
  }

}
