//package com.ydjt.stream.table;
//
//
//import com.ydjt.entity.DwdYdjtScaleAndIncDate;
//import org.apache.flink.api.java.ExecutionEnvironment;
//import org.apache.flink.table.api.EnvironmentSettings;
//import org.apache.flink.table.api.Table;
//import org.apache.flink.table.api.TableEnvironment;
//import org.apache.flink.table.api.TableResult;
//import org.apache.flink.types.Row;
//import org.apache.flink.util.CloseableIterator;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Consumer;
//
//public class HBaseTest {
//    public static void main(String[] args) throws Exception {
//        // 批执行环境
//        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
//
//        // 表环境
//        EnvironmentSettings settings = EnvironmentSettings.newInstance()
//                .useBlinkPlanner()
//                .inBatchMode()
//                .build();
//        TableEnvironment tableEnv = TableEnvironment.create(settings);
//
//        // 创建用户-电影表 u_m
//        TableResult tableResult = tableEnv.executeSql(
//                "CREATE TABLE DWD_YDJT_SCALEANDINC_DATE (" +
//                        " rowkey STRING," +
//                        " info ROW<businessDataId STRING, businessDate STRING, businessIncome DOUBLE, businessScale DOUBLE, channelSource STRING>," +
//                        " PRIMARY KEY (rowkey) NOT ENFORCED" +
//                        " ) WITH (" +
//                        " 'connector' = 'hbase-2.2' ," +
//                        " 'table-name' = 'DWD_YDJT_SCALEANDINC_DATE' ," +
//                        " 'zookeeper.quorum' = 'linux121:2181'" +
//                        " )");
//
//        // 查询是否能获取到HBase里的数据
////        Table table = tableEnv.sqlQuery("SELECT rowkey, info FROM DWD_YDJT_SCALEANDINC_DATE");
//
//        // 相当于 scan
////        Table table = tableEnv.sqlQuery("SELECT channelSource,businessDate,sum(Str2Double(businessIncome)) as businessIncome ,sum(Str2Double(businessScale)) as businessScale FROM DWD_YDJT_SCALEANDINC_DATE group by channelSource,businessDate");
//        Table table = tableEnv.sqlQuery("SELECT channelSource,businessDate,sum(businessIncome) as counts FROM DWD_YDJT_SCALEANDINC_DATE group by channelSource,businessDate");
//
//        // 查询的结果
//        TableResult executeResult = table.execute();
//
//        // 获取查询结果
//        CloseableIterator<Row> collect = executeResult.collect();
//
//        // 输出 (执行print或者下面的 Consumer之后，数据就被消费了。两个只能留下一个)
////        executeResult.print();
//
//        List<DwdYdjtScaleAndIncDate> dwdList = new ArrayList<>();
//
//        collect.forEachRemaining(new Consumer<Row>() {
//            @Override
//            public void accept(Row row) {
//                String field0 = String.valueOf(row.getField(0));
//                String[] user_movie = String.valueOf(row.getField(1)).split(",");
////                Double ratting = Double.valueOf(String.valueOf(row.getField(1)));
//                dwdList.add(new DwdYdjtScaleAndIncDate(user_movie[0],user_movie[1],user_movie[1],user_movie[1],user_movie[1]));
//            }
//        });
//
//
//        System.out.println("................");
//
//        for(DwdYdjtScaleAndIncDate um : dwdList){
//            System.out.println(um);
//        }
//
//
//    }
//}
