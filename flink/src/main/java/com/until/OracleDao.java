package com.until;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleDao {
    private Statement stmt = null;

    private ResultSet rs = null;

    private Connection conn = null;

    public OracleDao() {
        this.getConnection();
    }

    public void getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            String url = "jdbc:oracle:thin:@10.11.0.31:1521:orcl";  //orcl为数据库的SID
            String user = "meeting";
            String password = "meeting";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Object> getRes() {
        List<Object> list = new ArrayList<Object>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select  *  from  tbmeetroomequipment");
            while (rs.next()) {
//                Tbmeet t = new Tbmeet();
//                t.setId(rs.getLong(1));
//                t.setName(rs.getString(2));
//                t.setEcid(rs.getLong(3));
//                list.add(t);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        } finally {
            this.close(conn, stmt, rs);
        }
        return list;
    }

    public int delete(String sql) throws SQLException {
        int number = 0;
        try {
            stmt = conn.createStatement();

            number = stmt.executeUpdate(sql);

            conn.commit();
        } catch (Exception e) {
            System.out.println(e);
            conn.rollback();
            number = 0;
        } finally {
            this.close(conn, stmt, rs);
        }
        return number;
    }

    public void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
