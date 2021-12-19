package com.ydjt.stream

import com.alibaba.fastjson.{JSON, JSONObject}
import com.typesafe.config.ConfigFactory
import com.ydjt.entity.KafkaOggJsonTableObject
import com.ydjt.stream.sink.OdsScaleDwdSink
import com.ydjt.stream.until.{GlobalConfigUtils, SourceKafka}
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.api.scala._


object Ods2Dwd {

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
    val runEnv = args(0)
    val bootstrapServers = GlobalConfigUtils.getProp(runEnv + ".bootstrap.servers")

    val env = StreamExecutionEnvironment.getExecutionEnvironment
//    val kafkaConsumer = new SourceKafka().getKafkaSource(bootstrapServers, "test_ogg")
    val kafkaConsumer = new SourceKafka().getKafkaSource(bootstrapServers, "test_gg1")
//    val kafkaConsumer = new SourceKafka().getKafkaSource(bootstrapServers, args(1))
    println("env:,"+runEnv)
//    println("topic:,"+args(1))
//    kafkaConsumer.setStartFromLatest()
    kafkaConsumer.setStartFromEarliest()
    kafkaConsumer.setCommitOffsetsOnCheckpoints(true)

    val sourceStream = env.addSource(kafkaConsumer)
//            sourceStream.print()
    //type,database, table,data(jsonArray)
    //
    val mapped: DataStream[KafkaOggJsonTableObject] = sourceStream.map(x => {
      val tableObject = JSON.parseObject(x, classOf[KafkaOggJsonTableObject])
      tableObject
    })
    mapped.addSink(new OdsScaleDwdSink)
//    mapped.print()
    env.execute("Ods2Dwd")
  }
}
