package com.ydjt.stream

import com.until.DBOperaRule
import com.ydjt.stream.bl.dwd2dws.{DwsScaleAndIncModel, HBaseReader}
import com.ydjt.stream.until.{ConnHBase, GlobalConfigUtils, SourceKafka}
import org.apache.flink.addons.hbase.TableInputFormat
import org.apache.flink.api.java.aggregation.Aggregations
import org.apache.flink.api.java.tuple
import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment, _}
import org.apache.flink.client.program.PackagedProgram
import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.table.api.Expressions.$
import org.apache.flink.table.api.Table
import org.apache.flink.table.api.bridge.scala.{BatchTableEnvironment, table2RowDataSet}
import org.apache.flink.types.Row
import org.apache.hadoop.hbase.client.{Connection, HTable, Result, Scan}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{Cell, TableName}

import java.util

object Dwd2DwsBL {

  def main(args: Array[String]): Unit = {
    // 检验参数
    if (args.length == 0) {
      println(
        """
          |Usage: testMain
          |Param:
          | test    第一个参数开发环境
          | two     第二个参数topic
                                        """.stripMargin)
      sys.exit(-1) // -1 非正常退出
    }
    val envSet: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val envStream: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val fbTableEnv = BatchTableEnvironment.create(envSet)

    val data: DataStream[(String, String)] = envStream.addSource(new HBaseReader)
//    data.print()
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
//          sb.append(columnKey).append(":")
//          if (columnKey.equals("businessIncome") || columnKey.equals("businessScale")){
//            val value: java.math.BigDecimal = Bytes.toBigDecimal(cell.getValueArray, cell.getValueOffset, cell.getValueLength)
//            sb.append(value).append(",")
//          }else{
//            val value: String = Bytes.toString(cell.getValueArray, cell.getValueOffset, cell.getValueLength)
//            sb.append(value).append(",")
//          }

          val value: String = Bytes.toString(cell.getValueArray, cell.getValueOffset, cell.getValueLength)
          sb.append(value).append(",")

        }
        val valueString: String = sb.replace(sb.length() - 1, sb.length(), "").toString
        val tuple2 = new tuple.Tuple2[String, String]()
        tuple2.setField(rowKey, 0)
//        tuple2.setField("{"+valueString+"}", 1)
        tuple2.setField(valueString, 1)
        tuple2
      }
    })
//    var map = Map[String,Object]("name" -> "jason","age" -> "500","test_100" -> "test_100","test_101" -> "test_101") //引用可变,支持读写操作;
//    val maybeString = map.get("name")
    //    val input: DataSet[(Int, String, Double)] = // [...]
//    val output = input.groupBy(1).aggregate(Aggregations.SUM, 0).and(Aggregations.MIN, 2)
//    val sumRes = hbaseData.groupBy(1).aggregate(Aggregations.SUM, 0).and(Aggregations.SUM, 2)

    val tuple4Res: DataSet[DwsScaleAndIncModel] = hbaseData.map {
      row =>
        val sps = row.toString.split(",")
        val tuple4 = new tuple.Tuple4[String, String,Double,Double]()
//        (-837716571,businessDataId,-837716571,businessDate,2021-12-05,businessIncome,92474.02,businessScale,29460.15,channelSource,QDYDBL)
//        tuple4.setFields(sps(5).substring(0,sps(5).length-1),sps(2), BigDecimal(sps(3)).asInstanceOf[Number].doubleValue(),BigDecimal(sps(4)).asInstanceOf[Number].doubleValue())
        tuple4.setFields(sps(5).substring(0,sps(5).length-1),sps(2), sps(3).toDouble,sps(4).toDouble)
        tuple4
        DwsScaleAndIncModel(sps(5).substring(0,sps(5).length-1),sps(2), sps(3).toDouble,sps(4).toDouble)
    }
//    " info ROW< channelSource STRING, businessDate STRING, businessIncome DOUBLE, businessScale DOUBLE>," +

//    hbaseData.print()
//    tuple4Res.print()
    val dwdTable = fbTableEnv.fromDataSet(tuple4Res, $("channelSource"), $("businessDate"), $("businessIncome"), $("businessScale"))
    val restable: Table = dwdTable.groupBy($("channelSource"),$("businessDate")).select($("channelSource"), $("businessDate"),$("businessIncome").sum().as("businessIncome"),$("businessScale").sum().as("businessScale"))
//    val restable = dwdTable.select($("channelSource"), $("businessDate"),$("businessIncome"),$("businessScale"))
//    val result = restable.execute()
    val sinkTableRes: DataSet[DwsScaleAndIncModel] = fbTableEnv.toDataSet(restable)

    val dbOperaRule = new DBOperaRule
    val models = new util.ArrayList[DwsScaleAndIncModel]()

//    val value:DataSet[util.ArrayList[DwsScaleAndIncModel]]= sinkTableRes.map {
//      row =>
//        models.add(row)
//        models
//    }
    val list = sinkTableRes.collect().toList
    list.foreach( x =>{
      models.add(x)
      }
    )
    dbOperaRule.createConnection()
    dbOperaRule.changeBathValue(models)
    dbOperaRule.closeDBConnection()
//    sinkTableRes.print()
//    result.print()
//    envSet.execute()
  }

}
