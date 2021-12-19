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

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class OdsHbaseSink extends RichSinkFunction<KafkaOggJsonTableObject> {

    Configuration conf;
    Connection conn;
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
        ydjtYdcaBusinessDataTable = conn.getTable(TableName.valueOf("YDJT_YDCA_BUSINESS_DATA"));
        ydjtZgdcBusinessDataentTable = conn.getTable(TableName.valueOf("YDJT_ZGDC_BUSINESS_DATAENT"));
        ydjtYdxtBusinessDataTable = conn.getTable(TableName.valueOf("YDJT_YDXT_BUSINESS_DATA"));
        ydjtGwzlBusinessDataTable = conn.getTable(TableName.valueOf("YDJT_GWZL_BUSINESS_DATA"));
        ydjtYdblBusinessDataTable = conn.getTable(TableName.valueOf("YDJT_YDBL_BUSINESS_DATA"));
        ydjtYdzqBusinessDatabpTable = conn.getTable(TableName.valueOf("YDJT_YDZQ_BUSINESS_DATABP"));
        ydjtYdtzBusinessDataTable = conn.getTable(TableName.valueOf("YDJT_YDTZ_BUSINESS_DATA"));
        ydjtYdzcBusinessDataTable = conn.getTable(TableName.valueOf("YDJT_YDZC_BUSINESS_DATA"));
        ydjtYdcyjjBusinessDataTable = conn.getTable(TableName.valueOf("YDJT_YDCYJJ_BUSINESS_DATA"));
        conn.getTable(TableName.valueOf("TR_DF_TA_DYINFOLITEM"));
    }

    @Override
    public void invoke(KafkaOggJsonTableObject value, Context context) throws Exception {

        if (value.getOpType().equalsIgnoreCase("I")) {
            if ( value.getTable().equals("TEST_OGG.YDJT_YDJT_YDCA_BUSINESS_DATA")) {
                YdjtYdcaBusinessData ydjtYdcaBusinessData = JSON.parseObject(value.getAfter(), YdjtYdcaBusinessData.class);
                insertYdjtYdcaBusinessData(ydjtYdcaBusinessDataTable, ydjtYdcaBusinessData);
                resInfo.put("YDJT_YDCA_BUSINESS_DATA",ydjtYdcaBusinessDataCount++);
            }
            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_ZGDC_BUSINESS_DATAENT")) {
                YdjtZgdcBusinessDataent ydjtZgdcBusinessDataent = JSON.parseObject(value.getAfter(), YdjtZgdcBusinessDataent.class);
                insertYdjtZgdcBusinessDataent(ydjtZgdcBusinessDataentTable, ydjtZgdcBusinessDataent);
                resInfo.put("YDJT_YDJT_ZGDC_BUSINESS_DATAENT",ydjtZgdcBusinessDataentCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDXT_BUSINESS_DATA")) {
                YdjtYdxtBusinessData ydjtYdxtBusinessData = JSON.parseObject(value.getAfter(), YdjtYdxtBusinessData.class);
                insertYdjtYdxtBusinessData(ydjtYdxtBusinessDataTable, ydjtYdxtBusinessData);
                resInfo.put("YDJT_YDJT_YDXT_BUSINESS_DATA",ydjtYdxtBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_GWZL_BUSINESS_DATA")) {
                YdjtGwzlBusinessData ydjtGwzlBusinessData = JSON.parseObject(value.getAfter(), YdjtGwzlBusinessData.class);
                insertYdjtGwzlBusinessDataTable(ydjtGwzlBusinessDataTable, ydjtGwzlBusinessData);
                resInfo.put("YDJT_YDJT_GWZL_BUSINESS_DATA",ydjtGwzlBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDBL_BUSINESS_DATA")) {
                YdjtYdblBusinessData ydjtYdblBusinessData = JSON.parseObject(value.getAfter(), YdjtYdblBusinessData.class);
                insertYdjtYdblBusinessDataTable(ydjtYdblBusinessDataTable, ydjtYdblBusinessData);
                resInfo.put("YDJT_YDJT_YDBL_BUSINESS_DATA",ydjtYdblBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDZQ_BUSINESS_DATABP")) {
                YdjtYdzqBusinessDatabp ydjtYdzqBusinessDatabp = JSON.parseObject(value.getAfter(), YdjtYdzqBusinessDatabp.class);
                insertYdjtYdzqBusinessDatabpTable(ydjtYdzqBusinessDatabpTable, ydjtYdzqBusinessDatabp);
                resInfo.put("YDJT_YDJT_YDZQ_BUSINESS_DATABP",ydjtYdzqBusinessDatabpCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDTZ_BUSINESS_DATA")||value.getTable().equals("YDJT.YDJT_YDTZ_BUSINESS_DATA")) {
                YdjtYdtzBusinessData ydjtYdtzBusinessData = JSON.parseObject(value.getAfter(), YdjtYdtzBusinessData.class);
                insertYdjtYdtzBusinessDataTable(ydjtYdtzBusinessDataTable, ydjtYdtzBusinessData);
                resInfo.put("YDJT_YDJT_YDTZ_BUSINESS_DATA",ydjtYdtzBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDZC_BUSINESS_DATA")) {
                YdjtYdzcBusinessData ydjtYdzcBusinessData = JSON.parseObject(value.getAfter(), YdjtYdzcBusinessData.class);
                insertYdjtYdzcBusinessDataTable(ydjtYdzcBusinessDataTable, ydjtYdzcBusinessData);
                resInfo.put("YDJT_YDJT_YDZC_BUSINESS_DATA",ydjtYdzcBusinessDataCount++);
            }

            if (value.getTable().equals("TEST_OGG.YDJT_YDJT_YDCYJJ_BUSINESS_DATA")) {
                YdjtYdcyjjBusinessData ydjtYdcyjjBusinessData = JSON.parseObject(value.getAfter(), YdjtYdcyjjBusinessData.class);
                insertYdjtYdcyjjBusinessDataTable(ydjtYdcyjjBusinessDataTable, ydjtYdcyjjBusinessData);
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
        if (ydjtYdcaBusinessData.getBusinessRecordType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessRecordType"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessRecordType()));
        if (ydjtYdcaBusinessData.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productType"), Bytes.toBytes(ydjtYdcaBusinessData.getProductType()));
        if (ydjtYdcaBusinessData.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessNo"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessNo()));
        if (ydjtYdcaBusinessData.getBusinessVersion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessVersion"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessVersion()));
        if (ydjtYdcaBusinessData.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessDate()));
        if (ydjtYdcaBusinessData.getProductOperationNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationNo"), Bytes.toBytes(ydjtYdcaBusinessData.getProductOperationNo()));
        if (ydjtYdcaBusinessData.getProductOperationName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationName"), Bytes.toBytes(ydjtYdcaBusinessData.getProductOperationName()));
        if (ydjtYdcaBusinessData.getFinanceOrgCodes() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("financeOrgCodes"), Bytes.toBytes(ydjtYdcaBusinessData.getFinanceOrgCodes()));
        if (ydjtYdcaBusinessData.getInnerOuterMapiType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("innerOuterMapiType"), Bytes.toBytes(ydjtYdcaBusinessData.getInnerOuterMapiType()));
        if (ydjtYdcaBusinessData.getCustomerId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerId"), Bytes.toBytes(ydjtYdcaBusinessData.getCustomerId()));
        if (ydjtYdcaBusinessData.getCustomerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerName"), Bytes.toBytes(ydjtYdcaBusinessData.getCustomerName()));
        if (ydjtYdcaBusinessData.getCreditNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditNo"), Bytes.toBytes(ydjtYdcaBusinessData.getCreditNo()));
        if (ydjtYdcaBusinessData.getCompanyCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyCode"), Bytes.toBytes(ydjtYdcaBusinessData.getCompanyCode()));
        if (ydjtYdcaBusinessData.getCompanyName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyName"), Bytes.toBytes(ydjtYdcaBusinessData.getCompanyName()));
        if (ydjtYdcaBusinessData.getCustomerType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerType"), Bytes.toBytes(ydjtYdcaBusinessData.getCustomerType()));
        if (ydjtYdcaBusinessData.getCustomerScope() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerScope"), Bytes.toBytes(ydjtYdcaBusinessData.getCustomerScope()));
        if (ydjtYdcaBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessScale()));
        if (ydjtYdcaBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessIncome()));
        if (ydjtYdcaBusinessData.getRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(ydjtYdcaBusinessData.getRate()));
        if (ydjtYdcaBusinessData.getAddressCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressCode"), Bytes.toBytes(ydjtYdcaBusinessData.getAddressCode()));
        if (ydjtYdcaBusinessData.getAddressName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressName"), Bytes.toBytes(ydjtYdcaBusinessData.getAddressName()));
        if (ydjtYdcaBusinessData.getCreditLevel() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditLevel"), Bytes.toBytes(ydjtYdcaBusinessData.getCreditLevel()));
        if (ydjtYdcaBusinessData.getInsuredAmount() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insuredAmount"), Bytes.toBytes(ydjtYdcaBusinessData.getInsuredAmount()));
        if (ydjtYdcaBusinessData.getInsurancePerson() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insurantPerson"), Bytes.toBytes(ydjtYdcaBusinessData.getInsurancePerson()));
        if (ydjtYdcaBusinessData.getGuaranteeAmount() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("guaranteeAmount"), Bytes.toBytes(ydjtYdcaBusinessData.getGuaranteeAmount()));
        if (ydjtYdcaBusinessData.getInsuredPeriod() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insuredPeriod"), Bytes.toBytes(ydjtYdcaBusinessData.getInsuredPeriod()));
        if (ydjtYdcaBusinessData.getInsuredRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insuredRate"), Bytes.toBytes(ydjtYdcaBusinessData.getInsuredRate()));
        if (ydjtYdcaBusinessData.getInsuredIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insuredIncome"), Bytes.toBytes(ydjtYdcaBusinessData.getInsuredIncome()));
        if (ydjtYdcaBusinessData.getCommission() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("commission"), Bytes.toBytes(ydjtYdcaBusinessData.getCommission()));
        if (ydjtYdcaBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdcaBusinessData.getUpdateTime()));
        if (ydjtYdcaBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("enterpriseType"), Bytes.toBytes(ydjtYdcaBusinessData.getEnterpriseType()));
        if (ydjtYdcaBusinessData.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdcaBusinessData.getCreateTime()));
        if (ydjtYdcaBusinessData.getSignStr() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("signStr"), Bytes.toBytes(ydjtYdcaBusinessData.getSignStr()));
        if (ydjtYdcaBusinessData.getRegionName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("regionName"), Bytes.toBytes(ydjtYdcaBusinessData.getRegionName()));
        if (ydjtYdcaBusinessData.getInsuredPeriodStart() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insuredPeriodStart"), Bytes.toBytes(ydjtYdcaBusinessData.getInsuredPeriodStart()));
        if (ydjtYdcaBusinessData.getInsuredPeriodEnd() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insuredPeriodEnd"), Bytes.toBytes(ydjtYdcaBusinessData.getInsuredPeriodEnd()));
        if (ydjtYdcaBusinessData.getInsuranceCorrectingDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insuranceCorrectingDate"), Bytes.toBytes(ydjtYdcaBusinessData.getInsuranceCorrectingDate()));
        if (ydjtYdcaBusinessData.getInsuranceType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insuranceType"), Bytes.toBytes(ydjtYdcaBusinessData.getInsuranceType()));
        if (ydjtYdcaBusinessData.getCaliberType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("caliberType"), Bytes.toBytes(ydjtYdcaBusinessData.getCaliberType()));
        if (ydjtYdcaBusinessData.getInsurancePerson() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("insurancePerson"), Bytes.toBytes(ydjtYdcaBusinessData.getInsurancePerson()));
        if (ydjtYdcaBusinessData.getBidOpenFlag() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("bidOpenFlag"), Bytes.toBytes(ydjtYdcaBusinessData.getBidOpenFlag()));
        if (ydjtYdcaBusinessData.getBusinessCompany() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessCompany"), Bytes.toBytes(ydjtYdcaBusinessData.getBusinessCompany()));
        if (ydjtYdcaBusinessData.getProductNameTop() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productNameTop"), Bytes.toBytes(ydjtYdcaBusinessData.getProductNameTop()));
        if (ydjtYdcaBusinessData.getProductNameSec() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productNameSec"), Bytes.toBytes(ydjtYdcaBusinessData.getProductNameSec()));
        ydjtYdcaBusinessDataTable.put(put);
    }

    void insertYdjtZgdcBusinessDataent(Table ydjtZgdcBusinessDataentTable, YdjtZgdcBusinessDataent ydjtZgdcBusinessDataent) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessId()));
        if (ydjtZgdcBusinessDataent.getBusinessId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessId"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessId()));
        if (ydjtZgdcBusinessDataent.getInterfaceCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("interfaceCode"), Bytes.toBytes(ydjtZgdcBusinessDataent.getInterfaceCode()));
        if (ydjtZgdcBusinessDataent.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtZgdcBusinessDataent.getChannelSource()));
        if (ydjtZgdcBusinessDataent.getBusinessRecordType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessRecordType"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessRecordType()));
        if (ydjtZgdcBusinessDataent.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productType"), Bytes.toBytes(ydjtZgdcBusinessDataent.getProductType()));
        if (ydjtZgdcBusinessDataent.getBusinessNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessNo"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessNo()));
        if (ydjtZgdcBusinessDataent.getBusinessVersion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessVersion"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessVersion()));
        if (ydjtZgdcBusinessDataent.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessDate()));
        if (ydjtZgdcBusinessDataent.getProductOperationNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationNo"), Bytes.toBytes(ydjtZgdcBusinessDataent.getProductOperationNo()));
        if (ydjtZgdcBusinessDataent.getProductOperationName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationName"), Bytes.toBytes(ydjtZgdcBusinessDataent.getProductOperationName()));
        if (ydjtZgdcBusinessDataent.getFinanceOrgCodes() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("financeOrgCodes"), Bytes.toBytes(ydjtZgdcBusinessDataent.getFinanceOrgCodes()));
        if (ydjtZgdcBusinessDataent.getInnerOuterMapiType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("innerOuterMapiType"), Bytes.toBytes(ydjtZgdcBusinessDataent.getInnerOuterMapiType()));
        if (ydjtZgdcBusinessDataent.getCustomerCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerCode"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCustomerCode()));
        if (ydjtZgdcBusinessDataent.getCustomerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerName"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCustomerName()));
        if (ydjtZgdcBusinessDataent.getCreditNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditNo"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCreditNo()));
        if (ydjtZgdcBusinessDataent.getCompanyCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyCode"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCompanyCode()));
        if (ydjtZgdcBusinessDataent.getCompanyName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyName"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCompanyName()));
        if (ydjtZgdcBusinessDataent.getCustomerType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerType"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCustomerType()));
        if (ydjtZgdcBusinessDataent.getCustomerScope() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerScope"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCustomerScope()));
        if (ydjtZgdcBusinessDataent.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessScale()));
        if (ydjtZgdcBusinessDataent.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessIncome()));
        if (ydjtZgdcBusinessDataent.getRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(ydjtZgdcBusinessDataent.getRate()));
        if (ydjtZgdcBusinessDataent.getBusinessState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessState"), Bytes.toBytes(ydjtZgdcBusinessDataent.getBusinessState()));
        if (ydjtZgdcBusinessDataent.getRepaymentTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentTime"), Bytes.toBytes(ydjtZgdcBusinessDataent.getRepaymentTime()));
        if (ydjtZgdcBusinessDataent.getRepaymentState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentState"), Bytes.toBytes(ydjtZgdcBusinessDataent.getRepaymentState()));
        if (ydjtZgdcBusinessDataent.getAddressCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressCode"), Bytes.toBytes(ydjtZgdcBusinessDataent.getAddressCode()));
        if (ydjtZgdcBusinessDataent.getAddressName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressName"), Bytes.toBytes(ydjtZgdcBusinessDataent.getAddressName()));
        if (ydjtZgdcBusinessDataent.getCreditLever() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditLever"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCreditLever()));
        if (ydjtZgdcBusinessDataent.getOrdName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("ordName"), Bytes.toBytes(ydjtZgdcBusinessDataent.getOrdName()));
        if (ydjtZgdcBusinessDataent.getDrawerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("drawerName"), Bytes.toBytes(ydjtZgdcBusinessDataent.getDrawerName()));
        if (ydjtZgdcBusinessDataent.getPayeeName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("payeeName"), Bytes.toBytes(ydjtZgdcBusinessDataent.getPayeeName()));
        if (ydjtZgdcBusinessDataent.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCreateTime()));
        if (ydjtZgdcBusinessDataent.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtZgdcBusinessDataent.getUpdateTime()));
        if (ydjtZgdcBusinessDataent.getEnterpriseType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("enterpriseType"), Bytes.toBytes(ydjtZgdcBusinessDataent.getEnterpriseType()));
        if (ydjtZgdcBusinessDataent.getValidateComplete() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("validateComplete"), Bytes.toBytes(ydjtZgdcBusinessDataent.getValidateComplete()));
        if (ydjtZgdcBusinessDataent.getOrgNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("orgNo"), Bytes.toBytes(ydjtZgdcBusinessDataent.getOrgNo()));
        if (ydjtZgdcBusinessDataent.getOrdName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("orgName"), Bytes.toBytes(ydjtZgdcBusinessDataent.getOrdName()));
        if (ydjtZgdcBusinessDataent.getOrgAddress() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("orgAddress"), Bytes.toBytes(ydjtZgdcBusinessDataent.getOrgAddress()));
        if (ydjtZgdcBusinessDataent.getCondition() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("condition"), Bytes.toBytes(ydjtZgdcBusinessDataent.getCondition()));

        ydjtZgdcBusinessDataentTable.put(put);
    }

    void insertYdjtYdxtBusinessData(Table ydjtYdxtBusinessDataTable, YdjtYdxtBusinessData ydjtYdxtBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdxtBusinessData.getBusinessDataId()));
        if (ydjtYdxtBusinessData.getBusinessDataId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessDataId()));
        if (ydjtYdxtBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdxtBusinessData.getChannelSource()));
        if (ydjtYdxtBusinessData.getBusinessRecordType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessRecordType"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessRecordType()));
        if (ydjtYdxtBusinessData.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productType"), Bytes.toBytes(ydjtYdxtBusinessData.getProductType()));
        if (ydjtYdxtBusinessData.getBusinessNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessNo"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessNo()));
        if (ydjtYdxtBusinessData.getBusinessVersion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessVersion"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessVersion()));
        if (ydjtYdxtBusinessData.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessDate().replaceAll("/","-")));
        if (ydjtYdxtBusinessData.getProductOperationNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationNo"), Bytes.toBytes(ydjtYdxtBusinessData.getProductOperationNo()));
        if (ydjtYdxtBusinessData.getProductOperationName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationName"), Bytes.toBytes(ydjtYdxtBusinessData.getProductOperationName()));
        if (ydjtYdxtBusinessData.getFinanceOrgCodes() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("financeOrgCodes"), Bytes.toBytes(ydjtYdxtBusinessData.getFinanceOrgCodes()));
        if (ydjtYdxtBusinessData.getInnerOuterMapiType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("innerOuterMapiType"), Bytes.toBytes(ydjtYdxtBusinessData.getInnerOuterMapiType()));
        if (ydjtYdxtBusinessData.getCustomerId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerId"), Bytes.toBytes(ydjtYdxtBusinessData.getCustomerId()));
        if (ydjtYdxtBusinessData.getCustomerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerName"), Bytes.toBytes(ydjtYdxtBusinessData.getCustomerName()));
        if (ydjtYdxtBusinessData.getCreditNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditNo"), Bytes.toBytes(ydjtYdxtBusinessData.getCreditNo()));
        if (ydjtYdxtBusinessData.getCompanyCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyCode"), Bytes.toBytes(ydjtYdxtBusinessData.getCompanyCode()));
        if (ydjtYdxtBusinessData.getCompanyName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyName"), Bytes.toBytes(ydjtYdxtBusinessData.getCompanyName()));
        if (ydjtYdxtBusinessData.getCustomerType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerType"), Bytes.toBytes(ydjtYdxtBusinessData.getCustomerType()));
        if (ydjtYdxtBusinessData.getCustomerScope() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerScope"), Bytes.toBytes(ydjtYdxtBusinessData.getCustomerScope()));
        if (ydjtYdxtBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessScale()));
        if (ydjtYdxtBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessIncome()));
        if (ydjtYdxtBusinessData.getRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(ydjtYdxtBusinessData.getRate()));
        if (ydjtYdxtBusinessData.getBusinessState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessState"), Bytes.toBytes(ydjtYdxtBusinessData.getBusinessState()));
        if (ydjtYdxtBusinessData.getRepaymentTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentTime"), Bytes.toBytes(ydjtYdxtBusinessData.getRepaymentTime()));
        if (ydjtYdxtBusinessData.getRepaymentState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentState"), Bytes.toBytes(ydjtYdxtBusinessData.getRepaymentState()));
        if (ydjtYdxtBusinessData.getEnterpriseType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("enterpriseType"), Bytes.toBytes(ydjtYdxtBusinessData.getEnterpriseType()));
        if (ydjtYdxtBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdxtBusinessData.getCreateTime()));
        if (ydjtYdxtBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdxtBusinessData.getUpdateTime()));
        if (ydjtYdxtBusinessData.getSignStr() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("signStr"), Bytes.toBytes(ydjtYdxtBusinessData.getSignStr()));
        if (ydjtYdxtBusinessData.getAddressName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressName"), Bytes.toBytes(ydjtYdxtBusinessData.getAddressName()));
        if (ydjtYdxtBusinessData.getAddressCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressCode"), Bytes.toBytes(ydjtYdxtBusinessData.getAddressCode()));
        if (ydjtYdxtBusinessData.getProjectNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("projectNo"), Bytes.toBytes(ydjtYdxtBusinessData.getProjectNo()));
        if (ydjtYdxtBusinessData.getProjectName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("projectName"), Bytes.toBytes(ydjtYdxtBusinessData.getProjectName()));
        if (ydjtYdxtBusinessData.getUserContractNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("userContractNo"), Bytes.toBytes(ydjtYdxtBusinessData.getUserContractNo()));
        if (ydjtYdxtBusinessData.getCommissionContractNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("commissionContractNo"), Bytes.toBytes(ydjtYdxtBusinessData.getCommissionContractNo()));
        if (ydjtYdxtBusinessData.getCaliberType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("caliberType"), Bytes.toBytes(ydjtYdxtBusinessData.getCaliberType()));
        if (ydjtYdxtBusinessData.getEncryptFlag() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("encryptFlag"), Bytes.toBytes(ydjtYdxtBusinessData.getEncryptFlag()));

        ydjtYdxtBusinessDataTable.put(put);

    }

    void insertYdjtGwzlBusinessDataTable(Table ydjtGwzlBusinessDataTable, YdjtGwzlBusinessData ydjtGwzlBusinessData) throws IOException {
//        Put put = new Put(Bytes.toBytes(ydjtGwzlBusinessData.getBusinessNo() + "@T@" + ydjtGwzlBusinessData.getBusinessDate()));
        Put put = new Put(Bytes.toBytes(ydjtGwzlBusinessData.getBusinessDataId()));
        if (ydjtGwzlBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtGwzlBusinessData.getChannelSource()));
        if (ydjtGwzlBusinessData.getBusinessRecordType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessRecordType"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessRecordType()));
        if (ydjtGwzlBusinessData.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productType"), Bytes.toBytes(ydjtGwzlBusinessData.getProductType()));
        if (ydjtGwzlBusinessData.getBusinessNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessNo"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessNo()));
        if (ydjtGwzlBusinessData.getBusinessVersion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessVersion"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessVersion()));
        if (ydjtGwzlBusinessData.getBusinessDate() != null)
        //        2020-07-28 00:00:00
        //        2021-06-2500:00:00
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessDate().substring(0,10)));
        if (ydjtGwzlBusinessData.getProductOperationNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationNo"), Bytes.toBytes(ydjtGwzlBusinessData.getProductOperationNo()));
        if (ydjtGwzlBusinessData.getProductOperationName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationName"), Bytes.toBytes(ydjtGwzlBusinessData.getProductOperationName()));
        if (ydjtGwzlBusinessData.getFinanceOrgCodes() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("financeOrgCodes"), Bytes.toBytes(ydjtGwzlBusinessData.getFinanceOrgCodes()));
        if (ydjtGwzlBusinessData.getInnerOuterMapiType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("innerOuterMapiType"), Bytes.toBytes(ydjtGwzlBusinessData.getInnerOuterMapiType()));
        if (ydjtGwzlBusinessData.getCustomerId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerId"), Bytes.toBytes(ydjtGwzlBusinessData.getCustomerId()));
        if (ydjtGwzlBusinessData.getCustomerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerName"), Bytes.toBytes(ydjtGwzlBusinessData.getCustomerName()));
        if (ydjtGwzlBusinessData.getCreditNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditNo"), Bytes.toBytes(ydjtGwzlBusinessData.getCreditNo()));
        if (ydjtGwzlBusinessData.getCompanyCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyCode"), Bytes.toBytes(ydjtGwzlBusinessData.getCompanyCode()));
        if (ydjtGwzlBusinessData.getCompanyName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyName"), Bytes.toBytes(ydjtGwzlBusinessData.getCompanyName()));
        if (ydjtGwzlBusinessData.getCustomerType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerType"), Bytes.toBytes(ydjtGwzlBusinessData.getCustomerType()));
        if (ydjtGwzlBusinessData.getCustomerScope() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerScope"), Bytes.toBytes(ydjtGwzlBusinessData.getCustomerScope()));
        if (ydjtGwzlBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessScale()));
        if (ydjtGwzlBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessIncome()));
        if (ydjtGwzlBusinessData.getRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(ydjtGwzlBusinessData.getRate()));
        if (ydjtGwzlBusinessData.getBusinessState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessState"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessState()));
        if (ydjtGwzlBusinessData.getRepaymentTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentTime"), Bytes.toBytes(ydjtGwzlBusinessData.getRepaymentTime()));
        if (ydjtGwzlBusinessData.getRepaymentState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentState"), Bytes.toBytes(ydjtGwzlBusinessData.getRepaymentState()));
        if (ydjtGwzlBusinessData.getAddressCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressCode"), Bytes.toBytes(ydjtGwzlBusinessData.getAddressCode()));
        if (ydjtGwzlBusinessData.getAddressName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressName"), Bytes.toBytes(ydjtGwzlBusinessData.getAddressName()));
        if (ydjtGwzlBusinessData.getCreditLevel() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditLevel"), Bytes.toBytes(ydjtGwzlBusinessData.getCreditLevel()));
        if (ydjtGwzlBusinessData.getLeaseThing() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("leaseThing"), Bytes.toBytes(ydjtGwzlBusinessData.getLeaseThing()));
        if (ydjtGwzlBusinessData.getEnterpriseType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("enterpriseType"), Bytes.toBytes(ydjtGwzlBusinessData.getEnterpriseType()));
        if (ydjtGwzlBusinessData.getLeaseTerm() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("leaseTerm"), Bytes.toBytes(ydjtGwzlBusinessData.getLeaseTerm()));
        if (ydjtGwzlBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtGwzlBusinessData.getCreateTime()));
        if (ydjtGwzlBusinessData.getSignStr() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("signStr"), Bytes.toBytes(ydjtGwzlBusinessData.getSignStr()));
        if (ydjtGwzlBusinessData.getBusinessDataId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtGwzlBusinessData.getBusinessDataId()));
        if (ydjtGwzlBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtGwzlBusinessData.getUpdateTime()));
        if (ydjtGwzlBusinessData.getBpRegion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("bpRegion"), Bytes.toBytes(ydjtGwzlBusinessData.getBpRegion()));
        if (ydjtGwzlBusinessData.getRegionName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("regionName"), Bytes.toBytes(ydjtGwzlBusinessData.getRegionName()));
        if (ydjtGwzlBusinessData.getCondition() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("condition"), Bytes.toBytes(ydjtGwzlBusinessData.getCondition()));
        if (ydjtGwzlBusinessData.getAdscriptiondept() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("adscriptiondept"), Bytes.toBytes(ydjtGwzlBusinessData.getAdscriptiondept()));

        ydjtGwzlBusinessDataTable.put(put);
    }

    void insertYdjtYdblBusinessDataTable(Table ydjtYdblBusinessDataTable, YdjtYdblBusinessData ydjtYdblBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdblBusinessData.getBusinessId()));
        if (ydjtYdblBusinessData.getBusinessId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessId"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessId()));
        if (ydjtYdblBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdblBusinessData.getChannelSource()));
        if (ydjtYdblBusinessData.getBusinessRecordType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessRecordType"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessRecordType()));
        if (ydjtYdblBusinessData.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productType"), Bytes.toBytes(ydjtYdblBusinessData.getProductType()));
        if (ydjtYdblBusinessData.getBusinessNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessNo"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessNo()));
        if (ydjtYdblBusinessData.getBusinessVersion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessVersion"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessVersion()));
        if (ydjtYdblBusinessData.getBusinessDate() != null)
        //        2020-04-28
        //        2021-01-28 00:00:00
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessDate().substring(0,10)));
        if (ydjtYdblBusinessData.getProductOperationNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationNo"), Bytes.toBytes(ydjtYdblBusinessData.getProductOperationNo()));
        if (ydjtYdblBusinessData.getProductOperationName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationName"), Bytes.toBytes(ydjtYdblBusinessData.getProductOperationName()));
        if (ydjtYdblBusinessData.getFinanceOrgCodes() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("financeOrgCodes"), Bytes.toBytes(ydjtYdblBusinessData.getFinanceOrgCodes()));
        if (ydjtYdblBusinessData.getInnerOuterMapiType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("innerOuterMapiType"), Bytes.toBytes(ydjtYdblBusinessData.getInnerOuterMapiType()));
        if (ydjtYdblBusinessData.getCustomerId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerId"), Bytes.toBytes(ydjtYdblBusinessData.getCustomerId()));
        if (ydjtYdblBusinessData.getCustomerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerName"), Bytes.toBytes(ydjtYdblBusinessData.getCustomerName()));
        if (ydjtYdblBusinessData.getCreditNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditNo"), Bytes.toBytes(ydjtYdblBusinessData.getCreditNo()));
        if (ydjtYdblBusinessData.getCompanyCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyCode"), Bytes.toBytes(ydjtYdblBusinessData.getCompanyCode()));
        if (ydjtYdblBusinessData.getCompanyName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyName"), Bytes.toBytes(ydjtYdblBusinessData.getCompanyName()));
        if (ydjtYdblBusinessData.getCustomerType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerType"), Bytes.toBytes(ydjtYdblBusinessData.getCustomerType()));
        if (ydjtYdblBusinessData.getCustomerScope() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerScope"), Bytes.toBytes(ydjtYdblBusinessData.getCustomerScope()));
        if (ydjtYdblBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessScale()));
        if (ydjtYdblBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessIncome()));
        if (ydjtYdblBusinessData.getRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(ydjtYdblBusinessData.getRate()));
        if (ydjtYdblBusinessData.getBusinessState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessState"), Bytes.toBytes(ydjtYdblBusinessData.getBusinessState()));
        if (ydjtYdblBusinessData.getRepaymentTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentTime"), Bytes.toBytes(ydjtYdblBusinessData.getRepaymentTime()));
        if (ydjtYdblBusinessData.getRepaymentState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentState"), Bytes.toBytes(ydjtYdblBusinessData.getRepaymentState()));
        if (ydjtYdblBusinessData.getAddressCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressCode"), Bytes.toBytes(ydjtYdblBusinessData.getAddressCode()));
        if (ydjtYdblBusinessData.getAddressName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressName"), Bytes.toBytes(ydjtYdblBusinessData.getAddressName()));
        if (ydjtYdblBusinessData.getCreditLevel() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditLevel"), Bytes.toBytes(ydjtYdblBusinessData.getCreditLevel()));
        if (ydjtYdblBusinessData.getEnterpriseType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("enterpriseType"), Bytes.toBytes(ydjtYdblBusinessData.getEnterpriseType()));
        if (ydjtYdblBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdblBusinessData.getCreateTime()));
        if (ydjtYdblBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdblBusinessData.getUpdateTime()));
        if (ydjtYdblBusinessData.getSignStr() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("signStr"), Bytes.toBytes(ydjtYdblBusinessData.getSignStr()));
        if (ydjtYdblBusinessData.getCondition() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("condition"), Bytes.toBytes(ydjtYdblBusinessData.getCondition()));
        ydjtYdblBusinessDataTable.put(put);
    }

    void insertYdjtYdzqBusinessDatabpTable(Table ydjtYdzqBusinessDatabpTable, YdjtYdzqBusinessDatabp ydjtYdzqBusinessDatabp) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessId()));
        if (ydjtYdzqBusinessDatabp.getBusinessId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessId"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessId()));
        if (ydjtYdzqBusinessDatabp.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getChannelSource()));
        if (ydjtYdzqBusinessDatabp.getBusinessRecordType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessRecordType"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessRecordType()));
        if (ydjtYdzqBusinessDatabp.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productType"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getProductType()));
        if (ydjtYdzqBusinessDatabp.getBusinessNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessNo"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessNo()));
        if (ydjtYdzqBusinessDatabp.getBusinessVersion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessVersion"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessVersion()));
        if (ydjtYdzqBusinessDatabp.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessDate()));
        if (ydjtYdzqBusinessDatabp.getProductOperationNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationNo"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getProductOperationNo()));
        if (ydjtYdzqBusinessDatabp.getProductOperationName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationName"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getProductOperationName()));
        if (ydjtYdzqBusinessDatabp.getFinanceOrgCodes() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("financeOrgCodes"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getFinanceOrgCodes()));
        if (ydjtYdzqBusinessDatabp.getInnerOuterMapiType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("innerOuterMapiType"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getInnerOuterMapiType()));
        if (ydjtYdzqBusinessDatabp.getCustomerId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerId"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCustomerId()));
        if (ydjtYdzqBusinessDatabp.getCustomerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerName"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCustomerName()));
        if (ydjtYdzqBusinessDatabp.getCreditNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditNo"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCreditNo()));
        if (ydjtYdzqBusinessDatabp.getCompanyCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyCode"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCompanyCode()));
        if (ydjtYdzqBusinessDatabp.getCompanyName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyName"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCompanyName()));
        if (ydjtYdzqBusinessDatabp.getCustomerType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerType"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCustomerType()));
        if (ydjtYdzqBusinessDatabp.getCustomerScope() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerScope"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCustomerScope()));
        if (ydjtYdzqBusinessDatabp.getEnterpriseType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("enterpriseType"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getEnterpriseType()));
        if (ydjtYdzqBusinessDatabp.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessScale()));
        if (ydjtYdzqBusinessDatabp.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessIncome()));
        if (ydjtYdzqBusinessDatabp.getRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getRate()));
        if (ydjtYdzqBusinessDatabp.getBusinessState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessState"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessState()));
        if (ydjtYdzqBusinessDatabp.getBusinessStage() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessStage"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getBusinessStage()));
        if (ydjtYdzqBusinessDatabp.getRepaymentTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentTime"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getRepaymentTime()));
        if (ydjtYdzqBusinessDatabp.getRepaymentState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentState"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getRepaymentState()));
        if (ydjtYdzqBusinessDatabp.getAddressCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressCode"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getAddressCode()));
        if (ydjtYdzqBusinessDatabp.getAddressName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressName"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getAddressName()));
        if (ydjtYdzqBusinessDatabp.getCreditLevel() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditLevel"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCreditLevel()));
        if (ydjtYdzqBusinessDatabp.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCreateTime()));
        if (ydjtYdzqBusinessDatabp.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getUpdateTime()));
        if (ydjtYdzqBusinessDatabp.getCondition() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("condition"), Bytes.toBytes(ydjtYdzqBusinessDatabp.getCondition()));

        ydjtYdzqBusinessDatabpTable.put(put);
    }

    void insertYdjtYdtzBusinessDataTable(Table ydjtYdtzBusinessDataTable, YdjtYdtzBusinessData ydjtYdtzBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdtzBusinessData.getBusinessDataId()));
        if (ydjtYdtzBusinessData.getBusinessDataId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDataId"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessDataId()));
        if (ydjtYdtzBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdtzBusinessData.getChannelSource()));
        if (ydjtYdtzBusinessData.getBusinessRecordType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessRecordType"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessRecordType()));
        if (ydjtYdtzBusinessData.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productType"), Bytes.toBytes(ydjtYdtzBusinessData.getProductType()));
        if (ydjtYdtzBusinessData.getBusinessNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessNo"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessNo()));
        if (ydjtYdtzBusinessData.getBusinessVersion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessVersion"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessVersion()));
        if (ydjtYdtzBusinessData.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessDate()));
        if (ydjtYdtzBusinessData.getProductOperationNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationNo"), Bytes.toBytes(ydjtYdtzBusinessData.getProductOperationNo()));
        if (ydjtYdtzBusinessData.getProductOperationName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationName"), Bytes.toBytes(ydjtYdtzBusinessData.getProductOperationName()));
        if (ydjtYdtzBusinessData.getFinanceOrgCodes() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("financeOrgCodes"), Bytes.toBytes(ydjtYdtzBusinessData.getFinanceOrgCodes()));
        if (ydjtYdtzBusinessData.getInnerOuterMapiType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("innerOuterMapiType"), Bytes.toBytes(ydjtYdtzBusinessData.getInnerOuterMapiType()));
        if (ydjtYdtzBusinessData.getCustomerId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerId"), Bytes.toBytes(ydjtYdtzBusinessData.getCustomerId()));
        if (ydjtYdtzBusinessData.getCustomerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerName"), Bytes.toBytes(ydjtYdtzBusinessData.getCustomerName()));
        if (ydjtYdtzBusinessData.getCreditNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditNo"), Bytes.toBytes(ydjtYdtzBusinessData.getCreditNo()));
        if (ydjtYdtzBusinessData.getCompanyCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyCode"), Bytes.toBytes(ydjtYdtzBusinessData.getCompanyCode()));
        if (ydjtYdtzBusinessData.getCompanyName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyName"), Bytes.toBytes(ydjtYdtzBusinessData.getCompanyName()));
        if (ydjtYdtzBusinessData.getCustomerType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerType"), Bytes.toBytes(ydjtYdtzBusinessData.getCustomerType()));
        if (ydjtYdtzBusinessData.getCustomerScope() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerScope"), Bytes.toBytes(ydjtYdtzBusinessData.getCustomerScope()));
        if (ydjtYdtzBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessScale()));
        if (ydjtYdtzBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessIncome()));
        if (ydjtYdtzBusinessData.getRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(ydjtYdtzBusinessData.getRate()));
        if (ydjtYdtzBusinessData.getBusinessState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessState"), Bytes.toBytes(ydjtYdtzBusinessData.getBusinessState()));
        if (ydjtYdtzBusinessData.getRepaymentTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentTime"), Bytes.toBytes(ydjtYdtzBusinessData.getRepaymentTime()));
        if (ydjtYdtzBusinessData.getRepaymentState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("repaymentState"), Bytes.toBytes(ydjtYdtzBusinessData.getRepaymentState()));
        if (ydjtYdtzBusinessData.getAddressCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressCode"), Bytes.toBytes(ydjtYdtzBusinessData.getAddressCode()));
        if (ydjtYdtzBusinessData.getAddressName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressName"), Bytes.toBytes(ydjtYdtzBusinessData.getAddressName()));
        if (ydjtYdtzBusinessData.getCreditLevel() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditLevel"), Bytes.toBytes(ydjtYdtzBusinessData.getCreditLevel()));
        if (ydjtYdtzBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdtzBusinessData.getCreateTime()));
        if (ydjtYdtzBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdtzBusinessData.getUpdateTime()));
        if (ydjtYdtzBusinessData.getBussType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("bussType"), Bytes.toBytes(ydjtYdtzBusinessData.getBussType()));
        if (ydjtYdtzBusinessData.getEnterpriseType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("enterpriseType"), Bytes.toBytes(ydjtYdtzBusinessData.getEnterpriseType()));
        if (ydjtYdtzBusinessData.getSignData() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("signData"), Bytes.toBytes(ydjtYdtzBusinessData.getSignData()));

        ydjtYdtzBusinessDataTable.put(put);
    }

    void insertYdjtYdzcBusinessDataTable(Table ydjtYdzcBusinessDataTable, YdjtYdzcBusinessData ydjtYdzcBusinessData) throws IOException {
        Put put = new Put(Bytes.toBytes(ydjtYdzcBusinessData.getId()));
        if (ydjtYdzcBusinessData.getId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("id"), Bytes.toBytes(ydjtYdzcBusinessData.getId()));
        if (ydjtYdzcBusinessData.getChannelSource() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("channelSource"), Bytes.toBytes(ydjtYdzcBusinessData.getChannelSource()));
        if (ydjtYdzcBusinessData.getBusinessRecordType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessRecordType"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessRecordType()));
        if (ydjtYdzcBusinessData.getProductType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productType"), Bytes.toBytes(ydjtYdzcBusinessData.getProductType()));
        if (ydjtYdzcBusinessData.getBusinessNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessNo"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessNo()));
        if (ydjtYdzcBusinessData.getBusinessVersion() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessVersion"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessVersion()));
        if (ydjtYdzcBusinessData.getBusinessDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessDate()));
        if (ydjtYdzcBusinessData.getBusinessCurmngEndDate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessCurmngEndDate"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessCurmngEndDate()));
        if (ydjtYdzcBusinessData.getProductOperationNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationNo"), Bytes.toBytes(ydjtYdzcBusinessData.getProductOperationNo()));
        if (ydjtYdzcBusinessData.getProductOperationName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("productOperationName"), Bytes.toBytes(ydjtYdzcBusinessData.getProductOperationName()));
        if (ydjtYdzcBusinessData.getFinanceOrgCodes() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("financeOrgCodes"), Bytes.toBytes(ydjtYdzcBusinessData.getFinanceOrgCodes()));
        if (ydjtYdzcBusinessData.getInnerOuterMapiType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("innerOuterMapiType"), Bytes.toBytes(ydjtYdzcBusinessData.getInnerOuterMapiType()));
        if (ydjtYdzcBusinessData.getCustomerId() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerId"), Bytes.toBytes(ydjtYdzcBusinessData.getCustomerId()));
        if (ydjtYdzcBusinessData.getCustomerName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerName"), Bytes.toBytes(ydjtYdzcBusinessData.getCustomerName()));
        if (ydjtYdzcBusinessData.getCreditNo() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditNo"), Bytes.toBytes(ydjtYdzcBusinessData.getCreditNo()));
        if (ydjtYdzcBusinessData.getCompanyCode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyCode"), Bytes.toBytes(ydjtYdzcBusinessData.getCompanyCode()));
        if (ydjtYdzcBusinessData.getCompanyName() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("companyName"), Bytes.toBytes(ydjtYdzcBusinessData.getCompanyName()));
        if (ydjtYdzcBusinessData.getCustomerType() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerType"), Bytes.toBytes(ydjtYdzcBusinessData.getCustomerType()));
        if (ydjtYdzcBusinessData.getCustomerScope() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("customerScope"), Bytes.toBytes(ydjtYdzcBusinessData.getCustomerScope()));
        if (ydjtYdzcBusinessData.getEnterprisetype() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("enterprisetype"), Bytes.toBytes(ydjtYdzcBusinessData.getEnterprisetype()));
        if (ydjtYdzcBusinessData.getBusinessScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessScale"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessScale()));
        if (ydjtYdzcBusinessData.getBusinessIncome() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessIncome"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessIncome()));
        if (ydjtYdzcBusinessData.getRate() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(ydjtYdzcBusinessData.getRate()));
        if (ydjtYdzcBusinessData.getBusinessState() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessState"), Bytes.toBytes(ydjtYdzcBusinessData.getBusinessState()));
        if (ydjtYdzcBusinessData.getAddresscode() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addresscode"), Bytes.toBytes(ydjtYdzcBusinessData.getAddresscode()));
        if (ydjtYdzcBusinessData.getAddressname() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("addressname"), Bytes.toBytes(ydjtYdzcBusinessData.getAddressname()));
        if (ydjtYdzcBusinessData.getCreditlevel() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("creditlevel"), Bytes.toBytes(ydjtYdzcBusinessData.getCreditlevel()));

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
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("fundCurmngEndDate"), Bytes.toBytes(ydjtYdcyjjBusinessData.getFundCurmngEndDate()));
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("businessDate"), Bytes.toBytes(ydjtYdcyjjBusinessData.getFundCurmngEndDate()));
        if (ydjtYdcyjjBusinessData.getFundScale() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("fundScale"), Bytes.toBytes(ydjtYdcyjjBusinessData.getFundScale()));
        if (ydjtYdcyjjBusinessData.getCreateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("createTime"), Bytes.toBytes(ydjtYdcyjjBusinessData.getCreateTime()));
        if (ydjtYdcyjjBusinessData.getUpdateTime() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("updateTime"), Bytes.toBytes(ydjtYdcyjjBusinessData.getUpdateTime()));
        if (ydjtYdcyjjBusinessData.getSignData() != null)
            put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("signData"), Bytes.toBytes(ydjtYdcyjjBusinessData.getSignData()));
        ydjtYdcyjjBusinessDataTable.put(put);
    }
}

