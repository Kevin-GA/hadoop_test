package com.test.hadoop.sink;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

public class EsSink {
//    private static void saveToEs(DataStream<SensorReading> dataStream) {
//        // 将数据输出到 ElasticSearch
//        ArrayList<HttpHost> httpHosts = new ArrayList<>();
//        httpHosts.add(new HttpHost("localhost", 9200));
//        //真正的 SinkFunction 是 ElasticsearchSink(使用构建者构建), ElasticsearchSinkFunction 只是负责处理以哪种方式存入
//        dataStream.addSink(new ElasticsearchSink.Builder<>(httpHosts, (ElasticsearchSinkFunction<SensorReading>) (sensorReading, runtimeContext, requestIndexer) -> {
//            HashMap<String, String> source = new HashMap<>();
//            source.put("id", sensorReading.getId());
//            source.put("temp", sensorReading.getTemperature().toString());
//            source.put("time", sensorReading.getTimestamp().toString());
//
//            IndexRequest indexRequest = Requests.indexRequest()
//                    .index("sensor")
//                    .type("readingData")
//                    .source(source);
//
//            requestIndexer.add(indexRequest);
//
//        }).build());
//    }

}
