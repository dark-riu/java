package Util;

import java.sql.*;

public class Utiljdbc {
    public static void main(String[] args) throws Exception {
       boolean result= login("admin","123");
        System.out.println(result==true?"登陆成功":"登陆失败");
    }
    static boolean login(String adminName , String password){
        Connection conn=null;
        Statement stm=null;
        ResultSet rs=null;
        try {
             conn=DBUtil.getConn();
             stm=conn.createStatement();
             rs=stm.executeQuery("select * from 员工表 where adminName='"+adminName+"'and password='"+password+"'");
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
           DBUtil.close(rs,stm,conn);
        }
        return false;
    }
    static void test() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&&useSSL=false&&serverTimezone=Asia/Shanghai";
        Connection conn= DriverManager.getConnection(url,"root","root");

        Statement stm=conn.createStatement();
        ResultSet rs=stm.executeQuery("select * from 员工表");
        while (rs.next()){
            System.out.println(rs.getInt("员工编号")+"\t");
            System.out.println( rs.getString("员工姓名"));
        }
        rs.close();
        stm.close();
        conn.close();
    }
}
