//package com.test.hadoop.sink;
//
//import com.test.hadoop.model.TableObject;
//import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.Connection;
//import org.apache.hadoop.hbase.client.ConnectionFactory;
//import org.apache.hadoop.hbase.client.Put;
//import org.apache.hadoop.hbase.client.Table;
//import org.apache.hadoop.hbase.util.Bytes;
//
//
//public class MyHbaseSink  extends RichSinkFunction<TableObject> {
//
//    org.apache.hadoop.conf.Configuration conf;
//    org.apache.hadoop.hbase.client.Connection conn;
//    Table teacherTable ;
//    @Override
//    public void open(org.apache.flink.configuration.Configuration parameters) throws Exception {
//        conf = HBaseConfiguration.create();
//        conf.set("hbase.zookeeper.quorum","linux121,linux122,linux123");
//        conf.set("hbase.zookeeper.property.clientPort","2181");
//        System.out.println("===1111===");
//        conn = ConnectionFactory.createConnection(conf);
//        System.out.println("===2222===");
//        teacherTable = conn.getTable(TableName.valueOf("teacher"));
//        System.out.println("===3333===");
//
//    }
//
//    @Override
//    public void invoke(TableObject value, Context context) throws Exception {
//        String id = value.getAfter().getId();
//        String name = value.getAfter().getName();
//        //获取一个表对象
//        Table t = conn.getTable(TableName.valueOf("teacher"));
////设定rowkey
////        Put put = new Put(Bytes.toBytes("111"));
//        Put put = new Put(Bytes.toBytes(id));
////列族，列，value
//        put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes(name));
////执行插入
//        t.put(put);
//// t.put();//可以传入list批量插入数据
////关闭table对象
//        t.close();
//        System.out.println("插入成功！！");
//    }
//
//    @Override
//    public void close() throws Exception {
//        if(teacherTable != null) {
//            teacherTable.close();
//        }
//        if (conn != null) {
//            conn.close();
//        }
//    }
//
//
//}
