import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.api.TableResult;
import org.apache.flink.types.Row;
import org.apache.flink.util.CloseableIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HBaseTest {
    public static void main(String[] args) throws Exception {
        // 批执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
//        StreamExecutionEnvironment streamEnv = StreamExecutionEnvironment.getExecutionEnvironment();

        // 表环境
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .useBlinkPlanner()
                .inBatchMode()
                .build();
        TableEnvironment tableEnv = TableEnvironment.create(settings);

        // 明细表
        TableResult tableResult = tableEnv.executeSql(
                "CREATE TABLE DWD_YDJT_SCALEANDINC_DATE (" +
                        " rowkey STRING," +
                        " info ROW<businessDataId STRING, businessDate STRING, businessIncome DOUBLE, businessScale DOUBLE, channelSource STRING>," +
                        " PRIMARY KEY (rowkey) NOT ENFORCED" +
                        " ) WITH (" +
                        " 'connector' = 'hbase-2.2' ," +
                        " 'table-name' = 'DWD_YDJT_SCALEANDINC_DATE' ," +
                        " 'zookeeper.quorum' = 'linux121:2181,linux122:2181,linux123:2181'" +
//                        " 'zookeeper.quorum' = 'test-hdp-storage-01,test-hdp-storage-02,test-hdp-storage-03'" +
                        " )");
        //聚合表
        TableResult dwsTableResult = tableEnv.executeSql(
                "CREATE TABLE DWS_YDJT_SCALEANDINC_DATE (" +
                        " rowkey STRING," +
                        " info ROW< channelSource STRING, businessDate STRING, businessIncome DOUBLE, businessScale DOUBLE>," +
                        " PRIMARY KEY (rowkey) NOT ENFORCED" +
                        " ) WITH (" +
                        " 'connector' = 'hbase-2.2' ," +
                        " 'table-name' = 'DWS_YDJT_SCALEANDINC_DATE' ," +
                        " 'zookeeper.quorum' = 'linux121:2181'" +
//                        " 'zookeeper.quorum' = 'test-hdp-storage-01,test-hdp-storage-02,test-hdp-storage-03'" +
                        " )");

        // 查询是否能获取到HBase里的数据
//        Table table = tableEnv.sqlQuery("SELECT rowkey, info FROM DWD_YDJT_SCALEANDINC_DATE");

        Table table = tableEnv.sqlQuery("select TO_BASE64(channelSource||SUBSTRING(businessDate FROM 0 FOR 7)) as businessDataId ,channelSource,SUBSTRING(businessDate FROM 0 FOR 7) as businessDate,sum(businessIncome) as businessIncome, sum(businessScale) as businessScale FROM DWD_YDJT_SCALEANDINC_DATE group by channelSource,businessDate ");
//        Table table = tableEnv.sqlQuery("select SUBSTRING(businessDate FROM 0 FOR 7) as businessDate FROM DWD_YDJT_SCALEANDINC_DATE ");
        tableEnv.createTemporaryView("dwsTable", table);
        Table tablemid = tableEnv.sqlQuery("select businessDataId ,channelSource,businessDate,sum(businessIncome) as businessIncome, sum(businessScale) as businessScale FROM dwsTable group by businessDataId,channelSource,businessDate");
//        Table tablemid = tableEnv.sqlQuery("select * FROM dwsTable");
        tableEnv.createTemporaryView("dwsTableMid", tablemid);

        //        INSERT INTO hTable
//        SELECT rowkey, ROW(f1q1), ROW(f2q2, f2q3), ROW(f3q4, f3q5, f3q6) FROM T;
        TableResult executeResult = tableEnv.executeSql("insert into DWS_YDJT_SCALEANDINC_DATE " +
        "select TO_BASE64(channelSource||SUBSTRING(businessDate FROM 0 FOR 7)) ,ROW(channelSource,businessDate,businessIncome, businessScale) FROM dwsTableMid ");

        // 查询的结果
//        TableResult executeResult = tablemid.execute();


        // 获取查询结果
        CloseableIterator<Row> collect = executeResult.collect();

        // 输出 (执行print或者下面的 Consumer之后，数据就被消费了。两个只能留下一个)
        executeResult.print();

        List<DwdYdjtScaleAndIncDate> dwdList = new ArrayList<>();

        //结构遍历解析
        collect.forEachRemaining(new Consumer<Row>() {
            @Override
            public void accept(Row row) {
                System.out.println(".......Consumer.........");
                String field0 = String.valueOf(row.getField(0));
                String[] user_movie = String.valueOf(row.getField(1)).split(",");
//                Double ratting = Double.valueOf(String.valueOf(row.getField(1)));
                dwdList.add(new DwdYdjtScaleAndIncDate(user_movie[0],user_movie[1],user_movie[1],user_movie[1],user_movie[1]));
            }
        });


        System.out.println("................");

        for(DwdYdjtScaleAndIncDate um : dwdList){
            System.out.println(um);
        }

        env.execute("OutputTableDemo");
    }
}



