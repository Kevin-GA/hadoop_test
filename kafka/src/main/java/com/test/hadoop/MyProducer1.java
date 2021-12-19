package com.test.hadoop;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.util.Objects.hash;

public class MyProducer1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Map<String, Object> configs = new HashMap<>();
// 设置连接Kafka的初始连接用到的服务器地址
// 如果是集群，则可以通过此初始连接发现集群中的其他broker
        configs.put("bootstrap.servers", "linux121:9092");
//        configs.put("bootstrap.servers", "test-hdp-message-01:9092,test-hdp-message-02:9092,test-hdp-message-03:9092");
// 设置key的序列化器
        configs.put("key.serializer",
                "org.apache.kafka.common.serialization.IntegerSerializer");
// 设置value的序列化器
        configs.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        configs.put("acks", "1");
        KafkaProducer<Integer, String> producer = new KafkaProducer<Integer, String>(configs);

        String[] dataRandom = {"2020-07-01","2020-10-12","2020-11-01","2020-12-12","2021-10-17","2021-12-05"};
        Random random = new Random(dataRandom.length);
        for(int i =0;i<Integer.parseInt(args[0]);i++){
            // 用于封装Producer的消息
            ProducerRecord<Integer, String> record = new
                    ProducerRecord<Integer, String>(
                    args[1], // 主题名称
//                0, // 分区编号，现在只有一个分区，所以是0
                0, // 数字作为key
                    "{\"table\":\"TEST_OGG.YDJT_YDJT_YDBL_BUSINESS_DATA\",\"op_type\":\"I\",\"op_ts\":\"2021-09-27 20:56:55.002704\",\"current_ts\":\"2021-09-27T20:57:05.541000\",\"pos\":\"00000000000000011045\",\"after\":" +
                            "{\"BUSINESS_ID\":\"" + "CYLJR-DYJF-YYSJ-"+random.nextInt(Integer.parseInt(args[0]))+i  + "\",\"CHANNEL_SOURCE\":\"QDYDBL\",\"BUSINESS_RECORD_TYPE\":\"1.0\",\"PRODUCT_TYPE\":\"4.0\",\"BUSINESS_NO\":\"666812.0\",\"BUSINESS_VERSION\":\"20201263.0\"," +
                            "\"BUSINESS_DATE\":\"" + dataRandom[random.nextInt(dataRandom.length)] +"\",\"PRODUCT_OPERATION_NO\":\"JRJG15839116719510100189\",\"PRODUCT_OPERATION_NAME\":\"应收账款保理（英大保理）\",\"FINANCE_ORG_CODES\":\"JRJG1602744691099\",\"INNER_OUTER_MAPI_TYPE\":\"2.0\",\"CUSTOMER_ID\":null,\"CUSTOMER_NAME\":\"宁波爱伊美电气股份有限公司\",\"CREDIT_NO\":\"91330200688017029W\",\"COMPANY_CODE\":\"CYDW1583829179\",\"COMPANY_NAME\":\"国网浙江电力\",\"CUSTOMER_TYPE\":\"2.0\",\"CUSTOMER_SCOPE\":\"2.0\"," +
                            "\"BUSINESS_SCALE\":\"" + getRandomRedPacketBetweenMinAndMax(new BigDecimal(0),new BigDecimal(99999)).toString() +"\"," +
                            "\"BUSINESS_INCOME\":\"" + getRandomRedPacketBetweenMinAndMax(new BigDecimal(0),new BigDecimal(99999)).toString() +"\",\"RATE\":\"3.85\",\"BUSINESS_STATE\":\"2.0\",\"REPAYMENT_TIME\":\"2020-12-16\",\"REPAYMENT_STATE\":\"0.0\",\"ADDRESS_CODE\":null,\"ADDRESS_NAME\":null,\"CREDIT_LEVEL\":null,\"ENTERPRISE_TYPE\":\"3.0\",\"CREATE_TIME\":null,\"UPDATE_TIME\":null,\"SIGN_STR\":null,\"CONDITION\":null}}"
                          // 字符串作为value
            );
// 发送消息，同步等待消息的确认
            producer.send(record).get(3_000, TimeUnit.MILLISECONDS);

        }

// 关闭生产者
        producer.close();
    }

    /**
     * 获取金额
     * @param min
     * @param max
     * @return
     */
    public static BigDecimal getRandomRedPacketBetweenMinAndMax(BigDecimal min, BigDecimal max){
        float minF = min.floatValue();
        float maxF = max.floatValue();
        //生成随机数
        BigDecimal db = new BigDecimal(Math.random() * (maxF - minF) + minF);

        //返回保留两位小数的随机数。不进行四舍五入
        return db.setScale(2,BigDecimal.ROUND_DOWN);
    }
}
