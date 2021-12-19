package com.until;
import java.sql.Connection;
import java.sql.DriverManager;

public class UtilDbForOracle {
    public static Connection getConnection(){
        try{
//            ojdbc8
//            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
//            ojdbc6
            Class.forName("oracle.jdbc.OracleDriver");
//            String url = "jdbc:oracle:thin:@192.168.10.101:1521:orcl";
//            String username = "test_ogg";
//            String password = "test_ogg";
//            String url = "jdbc:oracle:thin:@172.16.3.61:1521:orcl";
//            String username = "ydjt";
//            String password = "123456";
//            String url = "jdbc:oracle:thin:@172.16.3.31:11521/ydjtdejf";
            String url = "jdbc:oracle:thin:@172.16.3.31:11521/YDJTDEJF";
            String username = "ydjtdejf";
            String password = "Ydjtde$186";
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
