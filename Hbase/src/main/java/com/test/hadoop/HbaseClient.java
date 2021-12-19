package com.test.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

public class HbaseClient {

    Configuration conf=null;
    Connection conn=null;
    HBaseAdmin admin =null;

    @Before
    public void init () throws IOException {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","linux121,linux122");
        conf.set("hbase.zookeeper.property.clientPort","2181");
        conn = ConnectionFactory.createConnection(conf);
    }

    public void destroy(){
        try {
            admin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(conn !=null){
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void createTable() throws IOException {
        admin = (HBaseAdmin) conn.getAdmin();
//创建表描述器
//        HTableDescriptor teacher = new HTableDescriptor(TableName.valueOf("teacher"));
//        HTableDescriptor teacher = new HTableDescriptor(TableName.valueOf("YDJT_ZGDC_BUSINESS_DATAENT"));
        HTableDescriptor teacher = new HTableDescriptor(TableName.valueOf("YDJT_YDTZ_BUSINESS_DATA"));
//设置列族描述器
        teacher.addFamily(new HColumnDescriptor("info"));
//执行创建操作
        admin.createTable(teacher);
        System.out.println("teacher表创建成功！！");
    }

    //插入一条数据
    @Test
    public void putData() throws IOException {
//获取一个表对象
//        Table t = conn.getTable(TableName.valueOf("teacher"));
        Table t = conn.getTable(TableName.valueOf("DWD_YDJT_SCALEANDINC_DATE"));
//设定rowkey
        Put put = new Put(Bytes.toBytes("110"));
//列族，列，value
        put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(20.00));
//执行插入
        t.put(put);
// t.put();//可以传入list批量插入数据
//关闭table对象
        t.close();
        System.out.println("插入成功！！");
    }

    ///删除一条数据
    @Test
    public void deleteData() throws IOException {
//需要获取一个table对象
        final Table worker = conn.getTable(TableName.valueOf("worker"));
//准备delete对象
        final Delete delete = new Delete(Bytes.toBytes("110"));
//执行删除
        worker.delete(delete);
//关闭table对象
        worker.close();
        System.out.println("删除成功！！");

    }

    //查询某个列族数据
    @Test
    public void getDataByCF() throws IOException {
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


    /**
     * 通过startRowKey和endRowKey进行扫描查询
     */
    @Test
    public void scanRowKey() throws IOException {
        HTable teacher = (HTable) conn.getTable(TableName.valueOf("DWD_YDJT_SCALEANDINC_DATE"));
        Scan scan = new Scan();
        scan.setStartRow("1".getBytes());
        scan.setStopRow("3220896".getBytes());
        ResultScanner resultScanner = teacher.getScanner(scan);
        for (Result result : resultScanner) {
            Cell[] cells = result.rawCells();//获取改行的所有cell对象
            for (Cell cell : cells) {
//通过cell获取rowkey,cf,column,value
                String cf = Bytes.toString(CellUtil.cloneFamily(cell));
                String column = Bytes.toString(CellUtil.cloneQualifier(cell));
                String value = Bytes.toString(CellUtil.cloneValue(cell));
                String rowkey = Bytes.toString(CellUtil.cloneRow(cell));
                System.out.println(rowkey + "----" + cf + "--" + column + "---" + value);
            }
        }
        teacher.close();
    }

}
