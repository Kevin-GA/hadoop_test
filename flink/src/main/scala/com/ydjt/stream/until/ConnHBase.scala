package com.ydjt.stream.until
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.{HBaseConfiguration, HConstants}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory}


class ConnHBase {
  def connToHbase:Connection ={
    val conf : Configuration = HBaseConfiguration.create()
    conf.set("hbase.zookeeper.quorum","test-hdp-storage-01,test-hdp-storage-02,test-hdp-storage-03")
//    conf.set("hbase.zookeeper.quorum","linux121,linux122")
    conf.set("hbase.zookeeper.property.clientPort","2181")
    conf.setInt(HConstants.HBASE_CLIENT_OPERATION_TIMEOUT,30000)
    conf.setInt(HConstants.HBASE_CLIENT_SCANNER_TIMEOUT_PERIOD,30000)
    val connection = ConnectionFactory.createConnection(conf)
    connection
  }

}