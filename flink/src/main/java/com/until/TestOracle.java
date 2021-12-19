//package com.until;
//
//import com.ydjt.stream.bl.dwd2dws.DwsScaleAndIncModel;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestOracle {
//    public static void main(String[] args) {
//        DBOperaRule dbOperaRule = new DBOperaRule();
//        dbOperaRule.createConnection();
//        String sql = "insert into DWS_YDJT_SCALEANDINC_DATE(channel_source,business_date,business_income,business_scale) " +
//                "values (?,?,?,?)";
//        String sqlCount = "select count(0) from DWS_YDJT_SCALEANDINC_DATE";
//        List<DwsScaleAndIncModel> dwsScaleAndIncModels = new ArrayList<>();
//        DwsScaleAndIncModel ydjt = new DwsScaleAndIncModel("YDJT", "2222-10-20", 20.3, 55.2);
//        DwsScaleAndIncModel ydjt0 = new DwsScaleAndIncModel("YDJT", "2020-10-20", 20.3, 55.2);
//        DwsScaleAndIncModel ydjt1 = new DwsScaleAndIncModel("YDJTBQ", "2021-10-20", 20.3, 55.2);
//        dwsScaleAndIncModels.add(ydjt);
//        dwsScaleAndIncModels.add(ydjt0);
//        dwsScaleAndIncModels.add(ydjt1);
//        try {
//            dbOperaRule.changeBathValue(dwsScaleAndIncModels);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        dbOperaRule.closeDBConnection();
//    }
//}
