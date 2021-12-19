//package com.test.hadoop.sink;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.client.Connection;
//import org.apache.hadoop.hbase.client.ConnectionFactory;
//
//public class HbaseSinkDemo {
//    /**
//     * 声明静态配置
//     */
//    static Configuration conf = null;
//    static Connection conn = null;
//    static {
//        conf = HBaseConfiguration.create();
//        conf.set("hbase.zookeeper.quorum", "linux121,linux122");
//        conf.set("hbase.zookeeper.property.client", "2181");
//        try{
//            conn = ConnectionFactory.createConnection(conf);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//}
