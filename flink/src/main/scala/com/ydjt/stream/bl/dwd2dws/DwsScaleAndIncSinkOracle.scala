package com.ydjt.stream.bl.dwd2dws

import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction

import java.sql.{Connection, DriverManager, PreparedStatement}
import java.text.SimpleDateFormat

object DwsScaleAndIncSinkOracle extends RichSinkFunction[DwsScaleAndIncModel]{
  var conn : Connection = null
  var ps: PreparedStatement = null

  val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")


  override def open(parameters: Configuration): Unit = {

//    channelSource: String,
//    businessDate: String,
//    businessIncome: Double,
//    businessScale :Double
    Class.forName ("oracle.jdbc.OracleDriver")
    conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:orcl", "test_ogg", "test_ogg")
    val sql = "insert into DWS_YDJT_SCALEANDINC_DATE(channel_source,business_date,business_income,business_scale) values (?,?,?,?)"
    ps = conn.prepareStatement(sql)
  }


  override def invoke(in: DwsScaleAndIncModel): Unit = {

    try {

      ps.setString(1,in.channelSource)
      ps.setString(2,in.businessDate)
      ps.setDouble(3,in.businessIncome)
      ps.setDouble(4,in.businessScale)
//      ps.setDouble(19,in.vwap_1Min.setScale(4,BigDecimal.RoundingMode.HALF_UP).toDouble)//分钟VWAP
//      ps.setDouble(20,in.vwap_sum.setScale(4,BigDecimal.RoundingMode.HALF_UP).toDouble)//累计VWAP
//      ps.setDouble(21,in.vwap_sd.setScale(4,BigDecimal.RoundingMode.HALF_UP).toDouble)//VWAP标准差

      ps.executeUpdate()

    }catch{
      case e : Exception => println(e.getMessage)
    }
  }

  override def close(): Unit = {
    if (ps != null) {
      ps.close()
    }
    if(conn != null){
      conn.close()
    }
  }

}
