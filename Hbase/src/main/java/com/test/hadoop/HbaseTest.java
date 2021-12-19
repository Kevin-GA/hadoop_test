package com.test.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseTest {
    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","linux121,linux122");
        conf.set("hbase.zookeeper.property.clientPort","2181");
        conf.set(TableInputFormat.INPUT_TABLE, "student");

        System.out.println("===1111===");
        Connection conn = ConnectionFactory.createConnection(conf);
        System.out.println("===2222===");
//        Table teacherTable = conn.getTable(TableName.valueOf("teacher"));

        //获取表对象
        HTable teacher = (HTable) conn.getTable(TableName.valueOf("teacher"));
//创建查询的get对象
        Get get = new Get(Bytes.toBytes("110"));
//指定列族信息
// get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("sex"));
        get.addFamily(Bytes.toBytes("info"));
//执行查询
        Result res = teacher.get(get);
        Cell[] cells = res.rawCells();//获取改行的所有cell对象
        for (Cell cell : cells) {
//通过cell获取rowkey,cf,column,value
            String cf = Bytes.toString(CellUtil.cloneFamily(cell));
            String column = Bytes.toString(CellUtil.cloneQualifier(cell));
            String value = Bytes.toString(CellUtil.cloneValue(cell));
            String rowkey = Bytes.toString(CellUtil.cloneRow(cell));
            System.out.println(rowkey + "----" + cf + "---" + column + "---" + value);
        }
        teacher.close();//关闭表对象资源
    }
}
