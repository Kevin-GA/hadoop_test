package com.until;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ydjt.stream.bl.dwd2dws.DwsScaleAndIncModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBOperaRule implements Serializable {
    private Connection conn = null;
    //  private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private boolean hadErrors = false;

    //创建数据库连接
    public void createConnection(){
        conn = UtilDbForOracle.getConnection();
        if(conn == null)
            System.out.println("数据库连接异常");
    }

    //发起事务
    public void beginTransaction(){
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //执行事务
    public void commitTransaction() throws SQLException{
        if(!hadErrors){
            conn.commit();
        }else{
            conn.rollback();
            hadErrors = false ;
        }
        hadErrors = false ;
        conn.setAutoCommit(true);
    }

    //标记出错
    public void errorOccur(){
        hadErrors = true ;
    }

    //执行插入、删除和更新操作
    synchronized public void execute(String sql) throws SQLException {
        this.pstmt = conn.prepareStatement(sql);
        if(pstmt != null){
            pstmt.executeUpdate(sql);
        }else{
//            Log log = LogFactory.getLog("mylog");
//            log.error("数据库插入数据出错");
            System.out.println("数据库插入数据出错");
        }
    }

    // statement.executeUpdate
    synchronized public boolean changeBathValue(List<DwsScaleAndIncModel> list)  {
        int result=0;
        try{
            //防止插入注入,使用占位符?
//            String sql = "Update  reader  set rname='吴尼玛' where reader.rname=?";
            String sql = "insert into DWS_YDJT_SCALEANDINC_DATE(channel_source,business_date,business_income,business_scale) " +
                    "values (?,?,?,?)";
            pstmt =conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                DwsScaleAndIncModel dm = list.get(i);
                pstmt.setString(1,dm.channelSource());
                pstmt.setString(2,dm.businessDate());
                pstmt.setDouble(3,dm.businessIncome());
                pstmt.setDouble(4,dm.businessScale());
                pstmt.addBatch();
                if(i%1000==0){
                    pstmt.executeBatch();
                }
            }
            int[] ints = pstmt.executeBatch();
            for (int res: ints) {
                result += res;
            }

//            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                if (pstmt!=null)
                    pstmt.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return result>0 ? true:false;
    }

    //执行查询操作
    synchronized public ResultSet read(String sql) throws SQLException {
        this.pstmt = conn.prepareStatement(sql);
//      Statement stmt = conn.createStatement();
        if(pstmt != null){
//      if(stmt != null){
            ResultSet tmp = null ;
            tmp = pstmt.executeQuery(sql);
//          tmp = stmt.executeQuery(sql);

            //下面为打印数据表中的字段名称
//          ResultSetMetaData md = tmp.getMetaData();
//          for(int i=1; i<=md.getColumnCount(); i++){
//                System.out.println(md.getColumnName(i));
//            }

            //循环打印数据库中的值
//          while(tmp.next()){
//              System.out.println("tmp是否在最后一行：" + tmp.isLast());
//              System.out.println("row: " + tmp.getRow());
//              System.out.println(tmp.getString(1) + " --> " + tmp.getString(2));
//          }

            return tmp;
        }else{
            return null;
        }
    }

    //执行查询个数操作
    synchronized public int readCount(String sql) throws SQLException {
        this.pstmt = conn.prepareStatement(sql);
        int nCount = 0;
        try{
            if(pstmt != null){
                ResultSet tmp = null;
                tmp = pstmt.executeQuery(sql);
                if(tmp != null && tmp.next()){
                    nCount = tmp.getInt(1);
                }else{
                    nCount = 0;
                }
            }
        }catch(SQLException e){
            nCount = 0;
        }
        return nCount;
    }

    public void closeDBConnection(){
        if(conn != null){
            try{
//                stmt.close();
                pstmt.close();
                conn.close();
            }catch(SQLException e){
                System.out.println("closeDBConnectionError!");
                e.printStackTrace();
            }finally{
                try{
//                    stmt.close();
                    pstmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
