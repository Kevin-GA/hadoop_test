package com.ydjt.stream.until

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

import java.util.Properties

class SourceKafka{
  def getKafkaSource(bootstarpServers: String,topicName: String) : FlinkKafkaConsumer[String] = {
    val props = new Properties()
    props.setProperty("bootstrap.servers",bootstarpServers);//3,4
    props.setProperty("group.id","consumer-group")
    props.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    props.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    props.setProperty("auto.offset.reset","latest")

    new FlinkKafkaConsumer[String](topicName, new SimpleStringSchema(),props);
  }
}
