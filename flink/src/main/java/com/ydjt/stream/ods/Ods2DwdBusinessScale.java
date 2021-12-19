package com.ydjt.stream.ods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.test.hadoop.sink.MyHbaseSink;
import com.ydjt.entity.KafkaOggJsonTableObject;
import com.ydjt.entity.YdjtYdcaBusinessData;
import com.ydjt.stream.sink.OdsHbaseSink;
import org.apache.commons.collections.map.HashedMap;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;

import org.apache.flink.streaming.connectors.elasticsearch7.ElasticsearchSink;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.internals.KafkaTopicPartition;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;

import java.util.*;

public class Ods2DwdBusinessScale {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);
//        手动地设定作业或具体算子的最大并发。
//        env.setMaxParallelism(8);
        env.enableCheckpointing(10);

        String topic = "test_ogg";
//        String topic = "topic_1";
        SimpleStringSchema simpleStringSchema = new SimpleStringSchema();
        Properties props = new Properties();
        props.setProperty("bootstrap.servers","linux121:9092,linux122:9092,linux123:9092");
//        props.setProperty("bootstrap.servers","test-hdp-message-01:9092,test-hdp-message-02:9092,test-hdp-message-03:9092");
        props.setProperty("group.id","mygp");

        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>(topic, simpleStringSchema, props);
        consumer.setStartFromEarliest();
//        consumer.setStartFromLatest();
        consumer.setCommitOffsetsOnCheckpoints(true);
//        consumer.setStartFromGroupOffsets();
        /**
         * Flink从topic中指定的offset开始，这个比较复杂，需要手动指定offset
         */
        Map<KafkaTopicPartition, Long> offsets = new HashedMap();
//        offsets.put(new KafkaTopicPartition("test_ogg", 0), 9l);
//        offsets.put(new KafkaTopicPartition("test_ogg", 0), 5l);
//        consumer.setStartFromSpecificOffsets(offsets);
        DataStreamSource<String> data = env.addSource(consumer);

        //source from kafka
        SingleOutputStreamOperator<KafkaOggJsonTableObject> mapped = data.rebalance().map(new MapFunction<String, KafkaOggJsonTableObject>() {
            @Override
            public KafkaOggJsonTableObject map(String value) throws Exception {
                KafkaOggJsonTableObject tableObject = JSON.parseObject(value, KafkaOggJsonTableObject.class);
//                JSONObject tableObject = JSON.parseObject(value);
                return tableObject;
            }
        });
        DataStream<JSONObject> mappedJson = data.rebalance().map(new MapFunction<String, JSONObject>() {
            @Override
            public JSONObject map(String value) throws Exception {
                JSONObject jsonObject = JSONObject.parseObject(value);
                return jsonObject;
            }
        });
        mapped.addSink(new OdsHbaseSink());
//        saveToEs(mapped);
        mapped.print();

        List<HttpHost> httpHosts = new ArrayList<>();
//        httpHosts.add(new HttpHost("linux121", 9200, "http"));
//        httpHosts.add(new HttpHost("linux122", 9200, "http"));
//        httpHosts.add(new HttpHost("linux123", 9200, "http"));
        httpHosts.add(new HttpHost("node01.test.stream", 9200, "http"));
        httpHosts.add(new HttpHost("node02.test.stream", 9200, "http"));
        httpHosts.add(new HttpHost("node03.test.stream", 9200, "http"));

        ElasticsearchSink.Builder<KafkaOggJsonTableObject> esSinkBuilder = new ElasticsearchSink.Builder<KafkaOggJsonTableObject>(
                httpHosts,
                new ElasticsearchSinkFunction<KafkaOggJsonTableObject>() {
                    @Override
                    public void process(KafkaOggJsonTableObject value, RuntimeContext ctx, RequestIndexer indexer) {
//                        JSONObject jsonObject = JSONObject.parseObject(value.getAfter());

//                        Map map = JSON.parseObject(JSON.toJSONString(value, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue), Map.class);
                        System.out.println(value.getAfter().contains("CHANNEL_SOURCE"));
                        if(value.getOpType().equalsIgnoreCase("I")&&value.getAfter().contains("CHANNEL_SOURCE")){
                            JSONObject afterJsonObject = JSONObject.parseObject(value.getAfter());
                            if(afterJsonObject.getString("CHANNEL_SOURCE")!=null)
                                System.out.println(afterJsonObject.getString("CHANNEL_SOURCE").toLowerCase());
                            indexer.add(Requests.indexRequest()
                                    .index("index_scale")
//                                    .type(afterJsonObject.getString("CHANNEL_SOURCE").toLowerCase())
                                    .id(afterJsonObject.getString("CHANNEL_SOURCE").toLowerCase()+"::"+afterJsonObject.getString("BUSINESS_ID"))
                                    .source(afterJsonObject)
                            );
//                            System.out.println("es======="+ JSONObject.parseObject(value.getAfter()));
                        }
                    }
                }
        );
        // 设置批量写数据的缓冲区大小
        esSinkBuilder.setBulkFlushMaxActions(50);

        /**
         * 把转换后的数据写入到ElasticSearch中
         */

        mapped.addSink(esSinkBuilder.build());
        env.execute();
    }

    private static void saveToEs(DataStream<KafkaOggJsonTableObject> dataStream) {
        // 将数据输出到 ElasticSearch
        ArrayList<HttpHost> httpHosts = new ArrayList<>();
        httpHosts.add(new HttpHost("linux121", 9200));
        //真正的 SinkFunction 是 ElasticsearchSink(使用构建者构建), ElasticsearchSinkFunction 只是负责处理以哪种方式存入
        dataStream.addSink(new ElasticsearchSink.Builder<>(httpHosts, (ElasticsearchSinkFunction<KafkaOggJsonTableObject>) (value, runtimeContext, requestIndexer) -> {
            HashMap<String, String> source = new HashMap<>();
            source.put("id", "test_id");
            source.put("channelSource", "test");
            source.put("creat_time", "now()");
            IndexRequest indexRequest = Requests.indexRequest()
                    .index("sensor")
                    .type("readingData")
                    .source(source);
            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDCA_BUSINESS_DATA")) {
                YdjtYdcaBusinessData ydjtYdcaBusinessData = JSON.parseObject(value.getAfter(), YdjtYdcaBusinessData.class);

                source.put("id", ydjtYdcaBusinessData.getBusinessDataId());
                source.put("channelSource", ydjtYdcaBusinessData.getChannelSource());
                source.put("creat_time", ydjtYdcaBusinessData.getCreateTime());
                indexRequest = Requests.indexRequest()
                        .index("YDJT_YDCA_BUSINESS_DATA".toLowerCase())
                        .type("test")
                        .source(source);
            }

            if (value.getTable().equals("TEST_OGG.TEST_OGG")) {
                source.put("id", "test_id");
                source.put("channelSource", "test");
                source.put("creat_time", "now()");
                indexRequest = Requests.indexRequest()
                        .index("TEST_OGG".toLowerCase())
                        .type("test")
                        .source(source);
            }

            requestIndexer.add(indexRequest);

        }).build());
    }

}
