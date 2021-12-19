package com.ydjt.stream

import com.ydjt.stream.bl.dwd2dws.{DwsScaleAndIncModel, HBaseReader}
import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment, _}
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.table.api.Expressions.$
import org.apache.flink.table.api.Table
import org.apache.flink.table.api.bridge.scala.{BatchTableEnvironment, StreamTableEnvironment}


object Dwd2DwsBLStream {

  def main(args: Array[String]): Unit = {


    val envSet: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val envStream: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val tableEnv: StreamTableEnvironment = StreamTableEnvironment.create(envStream)

    val fbTableEnv = BatchTableEnvironment.create(envSet)

    val data: DataStream[(String, String)] = envStream.addSource(new HBaseReader)

    val dataStream: DataStream[DwsScaleAndIncModel] = data.map(x => {

      val datas: Array[String] = x._2.split(",")
      val channelSource: String = datas(4).trim
      val businessDate: String = datas(1).trim
      val businessIncome: Double = datas(2).trim.toDouble
      val businessScale :Double = datas(3).trim.toDouble
      DwsScaleAndIncModel(channelSource,businessDate,businessIncome,businessScale)
    })
    dataStream.print()

    val dwdTable = tableEnv.fromDataStream(dataStream, $("channelSource"), $("businessDate"), $("businessIncome"), $("businessScale"))
    val restable: Table = dwdTable.groupBy($("channelSource"),$("businessDate")).select($("channelSource"), $("businessDate"),$("businessIncome").sum().as("businessIncome"),$("businessScale").sum().as("businessScale"))
//    val restable = dwdTable.select($("channelSource"), $("businessDate"),$("businessIncome"),$("businessScale"))
    val result = restable.execute()
    result.print()


    envStream.execute()
  }

}
