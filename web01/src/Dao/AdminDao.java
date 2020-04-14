package Dao;

import Util.DBUtil;

import java.sql.Connection;
import java.sql.Statement;

public class AdminDao {
    public int addAdmin(AdminDao admin){
        int result=0;
        Connection conn=null;
        Statement stm=null;
        try{
            conn=DBUtil.getConn();
            stm=conn.createStatement();
            String sql="insert into ";
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(null,stm,conn);
        }
        
        return result;
    }
}
