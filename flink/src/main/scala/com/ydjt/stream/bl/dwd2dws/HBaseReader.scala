package com.ydjt.stream.bl.dwd2dws

import com.ydjt.stream.until.ConnHBase
import org.apache.flink.configuration
import org.apache.flink.streaming.api.functions.source.{RichSourceFunction, SourceFunction}
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{Cell, TableName}

import java.util
import scala.collection.JavaConverters._

/**
 * 从HBase中读取lagou_area
 * 对数据进行转化，转成 地区id,地区的名字，城市的id，城市的名字， 省份的id，省份的名字
 * 在存到HBase中
 */
class HBaseReader extends RichSourceFunction[(String,String)]{
  private var conn : Connection = null
  private var table : Table = null;
  private var scan : Scan = null;


  override def open(parameters: configuration.Configuration): Unit = {
    conn = new ConnHBase().connToHbase

    //    val tableName: TableName = TableName.valueOf("lagou_trade_orders")
    val tableName: TableName = TableName.valueOf("DWD_YDJT_SCALEANDINC_DATE")
    val cf1: String = "info"
    table = conn.getTable(tableName)
    scan = new Scan()

    scan.addFamily(Bytes.toBytes(cf1))
  }


  override def run(ctx: SourceFunction.SourceContext[(String, String)]): Unit = {
    val rs: ResultScanner = table.getScanner(scan)
    val iterator: util.Iterator[Result] = rs.iterator()
    while(iterator.hasNext) {
      val result: Result = iterator.next()
      val rowKey: String = Bytes.toString(result.getRow)
      val buffer: StringBuffer = new StringBuffer()
      for(cell: Cell <- result.listCells().asScala) {
        val value: String = Bytes.toString(cell.getValueArray, cell.getValueOffset, cell.getValueLength)
        buffer.append(value).append(",")
      }

      val valueString: String = buffer.replace(buffer.length() - 1, buffer.length(), "").toString
      ctx.collect((rowKey,valueString))

    }

  }

  override def cancel(): Unit = {

  }

  override def close(): Unit = {
    try {
      if(table != null) {
        table.close()
      }
      if(conn != null) {
        conn.close()
      }
    } catch {
      case e:Exception => println(e.getMessage)
    }
  }
}
