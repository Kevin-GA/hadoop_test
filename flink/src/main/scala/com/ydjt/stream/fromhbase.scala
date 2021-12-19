package com.ydjt.stream

import org.apache.flink.addons.hbase.TableInputFormat
import org.apache.flink.api.java.tuple
import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.configuration.Configuration
import org.apache.hadoop.hbase.{Cell, HBaseConfiguration, HConstants, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, HTable, Result, Scan}
import org.apache.hadoop.hbase.util.Bytes

object fromhbase {
  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    import org.apache.flink.api.scala._
    //通过inputformat添加数据

    val hbaseDataSet = env.createInput(new TableInputFormat[tuple.Tuple2[String,String]] {
      override def configure(parameters: Configuration): Unit = {
        val conf = HBaseConfiguration.create()
        conf.set(HConstants.ZOOKEEPER_QUORUM,"linux121,linux122")
        conf.set(HConstants.ZOOKEEPER_CLIENT_PORT,"2181")
        val connection: Connection = ConnectionFactory.createConnection(conf)
        table = classOf[HTable].cast(connection.getTable(TableName.valueOf("teacher")))
        scan = new Scan(){
          addFamily(Bytes.toBytes("info"))
        }

      }

      override def getTableName: String = {
        "teacher"
      }

      override def getScanner: Scan = {
        scan
      }
      //封装HBASE表数据
      override def mapResultToTuple(result: Result): tuple.Tuple2[String, String] = {

        val rowKey: String = Bytes.toString(result.getRow)
        val rawCells: Array[Cell] = result.rawCells()
        val buffer = new StringBuffer()
        for (cell <- rawCells){
          val value: String = Bytes.toString(cell.getValueArray,cell.getValueOffset,cell.getValueLength)
          buffer.append(value).append(",")
        }
        val valueString: String = buffer.replace(buffer.length() - 1, buffer.length(), "").toString
        val tuple2 = new org.apache.flink.api.java.tuple.Tuple2[String, String]
        //给元素的下标赋值
        tuple2.setField(rowKey, 0)
        tuple2.setField(valueString, 1)
        tuple2

      }
    })

    hbaseDataSet.print()
  }

}
