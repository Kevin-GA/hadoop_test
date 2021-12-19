package com.ydjt.stream.sink;


import com.alibaba.fastjson.JSON;
import com.ydjt.entity.*;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.Hash;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/*
DWD_YDJT_SCALEANDINC_DATE
*/

public class OdsScaleDwdSink extends RichSinkFunction<KafkaOggJsonTableObject> {

    Configuration conf;
    Connection conn;
    Table dwdYdjtScaleandincDateTable;
    Table ydjtYdcaBusinessDataTable;
    Long ydjtYdcaBusinessDataCount = 0L;
    Table ydjtZgdcBusinessDataentTable;
    Long ydjtZgdcBusinessDataentCount = 0L;
    Table ydjtYdxtBusinessDataTable;
    Long ydjtYdxtBusinessDataCount = 0L;
    Table ydjtGwzlBusinessDataTable;
    Long ydjtGwzlBusinessDataCount = 0L;
    Table ydjtYdblBusinessDataTable;
    Long ydjtYdblBusinessDataCount = 0L;
    Table ydjtYdzqBusinessDatabpTable;
    Long ydjtYdzqBusinessDatabpCount = 0L;
    Table ydjtYdtzBusinessDataTable;
    Long ydjtYdtzBusinessDataCount = 0L;
    Table ydjtYdzcBusinessDataTable;
    Long ydjtYdzcBusinessDataCount = 0L;
    Table ydjtYdcyjjBusinessDataTable;
    Long ydjtYdcyjjBusinessDataCount = 0L;
    ConcurrentHashMap<String, Object> resInfo = new ConcurrentHashMap<>();

    @Override
    public void open(org.apache.flink.configuration.Configuration parameters) throws Exception {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "linux121,linux122,linux123");
//        conf.set("hbase.zookeeper.quorum", "test-hdp-storage-01,test-hdp-storage-02,test-hdp-storage-03");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        conn = ConnectionFactory.createConnection(conf);
        dwdYdjtScaleandincDateTable = conn.getTable(TableName.valueOf("DWD_YDJT_SCALEANDINC_DATE"));

    }

    @Override
    public void invoke(KafkaOggJsonTableObject value, Context context) throws Exception {

        if (value.getOpType().equalsIgnoreCase("I")) {
            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDBL_BUSINESS_DATA")) {
                YdjtYdblBusinessData ydjtYdblBusinessData = JSON.parseObject(value.getAfter(), YdjtYdblBusinessData.class);
                insertYdjtYdblBusinessDataTable(dwdYdjtScaleandincDateTable, ydjtYdblBusinessData);
                resInfo.put("YDJT_YDJT_YDBL_BUSINESS_DATA",ydjtYdblBusinessDataCount++);
            }

            if ( value.getTable().equals("TEST_OGG.YDJT_YDJT_YDCA_BUSINESS_DATA")) {
                YdjtYdcaBusinessData ydjtYdcaBusinessData = JSON.parseObject(value.getAfter(), YdjtYdcaBusinessData.class);
                insertYdjtYdcaBusinessData(dwdYdjtScaleandincDateTable, ydjtYdcaBusinessData);
                resInfo.put("YDJT_YDCA_BUSINESS_DATA",ydjtYdcaBusinessDataCount++);
            }
            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_ZGDC_BUSINESS_DATAENT")) {
                YdjtZgdcBusinessDataent ydjtZgdcBusinessDataent = JSON.parseObject(value.getAfter(), YdjtZgdcBusinessDataent.class);
                insertYdjtZgdcBusinessDataent(dwdYdjtScaleandincDateTable, ydjtZgdcBusinessDataent);
                resInfo.put("YDJT_YDJT_ZGDC_BUSINESS_DATAENT",ydjtZgdcBusinessDataentCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDXT_BUSINESS_DATA")) {
                YdjtYdxtBusinessData ydjtYdxtBusinessData = JSON.parseObject(value.getAfter(), YdjtYdxtBusinessData.class);
                insertYdjtYdxtBusinessData(dwdYdjtScaleandincDateTable, ydjtYdxtBusinessData);
                resInfo.put("YDJT_YDJT_YDXT_BUSINESS_DATA",ydjtYdxtBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_GWZL_BUSINESS_DATA")) {
                YdjtGwzlBusinessData ydjtGwzlBusinessData = JSON.parseObject(value.getAfter(), YdjtGwzlBusinessData.class);
                insertYdjtGwzlBusinessDataTable(dwdYdjtScaleandincDateTable, ydjtGwzlBusinessData);
                resInfo.put("YDJT_YDJT_GWZL_BUSINESS_DATA",ydjtGwzlBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDZQ_BUSINESS_DATABP")) {
                YdjtYdzqBusinessDatabp ydjtYdzqBusinessDatabp = JSON.parseObject(value.getAfter(), YdjtYdzqBusinessDatabp.class);
                insertYdjtYdzqBusinessDatabpTable(dwdYdjtScaleandincDateTable, ydjtYdzqBusinessDatabp);
                resInfo.put("YDJT_YDJT_YDZQ_BUSINESS_DATABP",ydjtYdzqBusinessDatabpCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDTZ_BUSINESS_DATA")||value.getTable().equals("YDJT.YDJT_YDTZ_BUSINESS_DATA")) {
                YdjtYdtzBusinessData ydjtYdtzBusinessData = JSON.parseObject(value.getAfter(), YdjtYdtzBusinessData.class);
                insertYdjtYdtzBusinessDataTable(dwdYdjtScaleandincDateTable, ydjtYdtzBusinessData);
                resInfo.put("YDJT_YDJT_YDTZ_BUSINESS_DATA",ydjtYdtzBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDZC_BUSINESS_DATA")) {
                YdjtYdzcBusinessData ydjtYdzcBusinessData = JSON.parseObject(value.getAfter(), YdjtYdzcBusinessData.class);
                insertYdjtYdzcBusinessDataTable(dwdYdjtScaleandincDateTable, ydjtYdzcBusinessData);
                resInfo.put("YDJT_YDJT_YDZC_BUSINESS_DATA",ydjtYdzcBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDCYJJ_BUSINESS_DATA")) {
                YdjtYdcyjjBusinessData ydjtYdcyjjBusinessData = JSON.parseObject(value.getAfter(), YdjtYdcyjjBusinessData.class);
                insertYdjtYdcyjjBusinessDataTable(dwdYdjtScaleandincDateTable, ydjtYdcyjjBusinessData);
                resInfo.put("YDJT_YDJT_YDCYJJ_BUSINESS_DATA",ydjtYdcyjjBusinessDataCount++);
            }

            System.out.println(resInfo.toString());
        }

    }


    @Override
    public void close() throws Exception {

        if (ydjtYdcaBusinessDataTable != null) {
            ydjtYdcaBusinessDataTable.close();
        }
        if (ydjtZgdcBusinessDataentTable != null) {
            ydjtZgdcBusinessDataentTable.close();
        }
        if (ydjtYdxtBusinessDataTable != null) {
            ydjtYdxtBusinessDataTable.close();
        }
        if (ydjtGwzlBusinessDataTable != null) {
            ydjtGwzlBusinessDataTable.close();
        }
        if (ydjtYdblBusinessDataTable != null) {
            ydjtYdblBusinessDataTable.close();
        }
        if (ydjtYdtzBusinessDataTable != null) {
            ydjtYdtzBusinessDataTable.close();
        }
        if (ydjtYdtzBusinessDataTable != null) {
            ydjtYdtzBusinessDataTable.close();
        }
        if (ydjtYdzcBusinessDataTable != null) {
            ydjtYdzcBusinessDataTable.close();
        }
        if (ydjtYdcyjjBusinessDataTable != null) {
            ydjtYdcyjjBusinessDataTable.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    void insertYdjtYdcaBusinessData(Table ydjtYdcaBusinessDataTable, YdjtYdcaBusinessData ydjtYdcaBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdcaBusinessData.getBusinessDataId()));
        if (ydjtYdcaBusinessData.getBusinessDataId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes( ydjtYdcaBusinessData.getBusinessDataId()));
        if (ydjtYdcaBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdcaBusinessData.getChannelSource()));
        if (ydjtYdcaBusinessData.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessDate()));
        if (ydjtYdcaBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessScale()));
        if (ydjtYdcaBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessIncome()));
        if (ydjtYdcaBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdcaBusinessData.getCreateTime()));
        if (ydjtYdcaBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdcaBusinessData.getUpdateTime()));
        ydjtYdcaBusinessDataTable.put(put);
    }

    void insertYdjtZgdcBusinessDataent(Table ydjtZgdcBusinessDataentTable, YdjtZgdcBusinessDataent ydjtZgdcBusinessDataent) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessId()));
        if (ydjtZgdcBusinessDataent.getBusinessId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessId()));
        if (ydjtZgdcBusinessDataent.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtZgdcBusinessDataent.getChannelSource()));
        if (ydjtZgdcBusinessDataent.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessDate()));
        if (ydjtZgdcBusinessDataent.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessScale()));
        if (ydjtZgdcBusinessDataent.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessIncome()));
        if (ydjtZgdcBusinessDataent.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCreateTime()));
        if (ydjtZgdcBusinessDataent.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtZgdcBusinessDataent.getUpdateTime()));
        ydjtZgdcBusinessDataentTable.put(put);
    }

    void insertYdjtYdxtBusinessData(Table ydjtYdxtBusinessDataTable, YdjtYdxtBusinessData ydjtYdxtBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdxtBusinessData.getBusinessDataId()));
        if (ydjtYdxtBusinessData.getBusinessDataId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessDataId()));
        if (ydjtYdxtBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdxtBusinessData.getChannelSource()));
        if (ydjtYdxtBusinessData.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessDate().replaceAll("/","-")));
        if (ydjtYdxtBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessScale()));
        if (ydjtYdxtBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessIncome()));
        if (ydjtYdxtBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdxtBusinessData.getCreateTime()));
        if (ydjtYdxtBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdxtBusinessData.getUpdateTime()));

        ydjtYdxtBusinessDataTable.put(put);

    }

    void insertYdjtGwzlBusinessDataTable(Table ydjtGwzlBusinessDataTable, YdjtGwzlBusinessData ydjtGwzlBusinessData) throws IOException {
//        Put put = new Put(Bytes.toBytes(ydjtGwzlBusinessData.getBusinessNo() + "@T@" + ydjtGwzlBusinessData.getBusinessDate()));
        Put put = new Put(Bytes.toBytes(ydjtGwzlBusinessData.getBusinessDataId()));
        if (ydjtGwzlBusinessData.getBusinessDataId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessDataId()));
        if (ydjtGwzlBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtGwzlBusinessData.getChannelSource()));
        if (ydjtGwzlBusinessData.getBusinessDate() != null)
        //        2020-07-28 00:00:00
        //        2021-06-2500:00:00
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessDate().substring(0,10)));
        if (ydjtGwzlBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessScale()));
        if (ydjtGwzlBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessIncome()));
        if (ydjtGwzlBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtGwzlBusinessData.getCreateTime()));
        if (ydjtGwzlBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtGwzlBusinessData.getUpdateTime()));
        ydjtGwzlBusinessDataTable.put(put);
    }

    void insertYdjtYdblBusinessDataTable(Table ydjtYdblBusinessDataTable, YdjtYdblBusinessData ydjtYdblBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdblBusinessData.getBusinessId()));
        if (ydjtYdblBusinessData.getBusinessId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessId()));
        if (ydjtYdblBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdblBusinessData.getChannelSource()));
        if (ydjtYdblBusinessData.getBusinessDate() != null)
        //        2020-04-28
        //        2021-01-28 00:00:00
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessDate().substring(0,10)));
        if (ydjtYdblBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessScale().toString()));
        if (ydjtYdblBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessIncome().toString()));
        if (ydjtYdblBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdblBusinessData.getCreateTime()));
        if (ydjtYdblBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdblBusinessData.getUpdateTime()));
        ydjtYdblBusinessDataTable.put(put);
    }

    void insertYdjtYdzqBusinessDatabpTable(Table ydjtYdzqBusinessDatabpTable, YdjtYdzqBusinessDatabp ydjtYdzqBusinessDatabp) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessId()));
        if (ydjtYdzqBusinessDatabp.getBusinessId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessId()));
        if (ydjtYdzqBusinessDatabp.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getChannelSource()));
        if (ydjtYdzqBusinessDatabp.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessDate()));
        if (ydjtYdzqBusinessDatabp.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessScale()));
        if (ydjtYdzqBusinessDatabp.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessIncome()));
        if (ydjtYdzqBusinessDatabp.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCreateTime()));
        if (ydjtYdzqBusinessDatabp.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getUpdateTime()));

        ydjtYdzqBusinessDatabpTable.put(put);
    }

    void insertYdjtYdtzBusinessDataTable(Table ydjtYdtzBusinessDataTable, YdjtYdtzBusinessData ydjtYdtzBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdtzBusinessData.getBusinessDataId()));
        if (ydjtYdtzBusinessData.getBusinessDataId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessDataId()));
        if (ydjtYdtzBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdtzBusinessData.getChannelSource()));
        if (ydjtYdtzBusinessData.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessDate()));
        if (ydjtYdtzBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessScale()));
        if (ydjtYdtzBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessIncome()));
        if (ydjtYdtzBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdtzBusinessData.getCreateTime()));
        if (ydjtYdtzBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdtzBusinessData.getUpdateTime()));


        ydjtYdtzBusinessDataTable.put(put);
    }

    void insertYdjtYdzcBusinessDataTable(Table ydjtYdzcBusinessDataTable, YdjtYdzcBusinessData ydjtYdzcBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdzcBusinessData.getId()));
        if (ydjtYdzcBusinessData.getId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtYdzcBusinessData.getId()));
        if (ydjtYdzcBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdzcBusinessData.getChannelSource()));
        if (ydjtYdzcBusinessData.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessDate()));
        if (ydjtYdzcBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessScale()));
        if (ydjtYdzcBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessIncome()));
        //补全
        put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(""));
        put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(""));

        ydjtYdzcBusinessDataTable.put(put);
    }

    void insertYdjtYdcyjjBusinessDataTable(Table ydjtYdcyjjBusinessDataTable, YdjtYdcyjjBusinessData ydjtYdcyjjBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdcyjjBusinessData.getId()));
        if (ydjtYdcyjjBusinessData.getId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("id"), Bytes.toBytes(ydjtYdcyjjBusinessData.getId()));
        if (ydjtYdcyjjBusinessData.getFundName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("fundName"), Bytes.toBytes(ydjtYdcyjjBusinessData.getFundName()));
        if (ydjtYdcyjjBusinessData.getFundCreateDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("fundCreateDate"), Bytes.toBytes(ydjtYdcyjjBusinessData.getFundCreateDate()));
        if (ydjtYdcyjjBusinessData.getFundCurmngEndDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdcyjjBusinessData.getFundCurmngEndDate()));
        if (ydjtYdcyjjBusinessData.getFundScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("fundScale"), Bytes.toBytes(ydjtYdcyjjBusinessData.getFundScale()));
        if (ydjtYdcyjjBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdcyjjBusinessData.getCreateTime()));
        if (ydjtYdcyjjBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdcyjjBusinessData.getUpdateTime()));
        ydjtYdcyjjBusinessDataTable.put(put);
    }

}

