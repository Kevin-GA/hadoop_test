//package com.test.hadoop;
//
//import com.test.hadoop.model.TableObject;
//import com.test.hadoop.sink.MyHbaseSink;
//import org.apache.flink.api.common.functions.MapFunction;
//import org.apache.flink.api.common.serialization.SimpleStringSchema;
//import org.apache.flink.configuration.Configuration;
//import org.apache.flink.streaming.api.datastream.DataStreamSource;
//import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
//import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//import com.alibaba.fastjson.JSON;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.util.Bytes;
//
//
//public class GKafkaDemo {
//    static int count;
//
//    public static void main(String[] args) throws Exception {
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.setParallelism(1);
//        env.enableCheckpointing(10);
//
//        String topic = "test_ogg";
//        SimpleStringSchema simpleStringSchema = new SimpleStringSchema();
//        Properties props = new Properties();
//        props.setProperty("bootstrap.servers","linux121:9092,linux122:9092,linux123:9092");
//        props.setProperty("group.id","mygp");
////        props.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
////        props.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
//
//        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>(topic, simpleStringSchema, props);
//        consumer.setStartFromEarliest();
////        consumer.setStartFromLatest();
//        consumer.setCommitOffsetsOnCheckpoints(true);
//        DataStreamSource<String> data = env.addSource(consumer);
//
//        //source from kafka
//        SingleOutputStreamOperator<TableObject> mapped = data.rebalance().map(new MapFunction<String, TableObject>() {
//            @Override
//            public TableObject map(String value) throws Exception {
//                TableObject tableObject = JSON.parseObject(value, TableObject.class);
//                List<TableObject> tableObjects = new ArrayList<>();
//                if(tableObject.getBefore()!=null){
//                    String name = tableObject.getBefore().getName();
//                    tableObject.getBefore().setName(name+1111);
//                }
//                tableObjects.add(tableObject);
//                count++;
//                if (count == 7000) {
//                    count = 0;
//                    throw new Exception("error.");
//                }
//                return tableObject;
//            }
//        });
//
//        mapped.addSink(new MyHbaseSink());
////        mapped.print();
//        env.execute();
//    }
//}
