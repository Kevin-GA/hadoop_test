package com.ydjt.stream;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class SourceKafka1 {

    FlinkKafkaConsumer<String>  getKafkaSource(String bootstarpServers,String topic){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers",bootstarpServers);
        props.setProperty("group.id","mygp");

        return  new FlinkKafkaConsumer<String>(topic, new SimpleStringSchema(), props);
    }
}
