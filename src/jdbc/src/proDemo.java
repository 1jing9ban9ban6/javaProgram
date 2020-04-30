package jdbc.src;

import java.sql.*;
import java.util.Properties;

public class proDemo {
    static String className = null;
    static String url = null;
    static String userName =null;
    static String password = null;
    static {
        try {
            Properties p = new Properties();
            p.load(proDemo.class.getClassLoader().
                    getResourceAsStream("db.properties"));
            className = p.getProperty("className");
            url = p.getProperty("url");
            userName = p.getProperty("userName");
            password = p.getProperty("password");
            Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  public static void main(String[] args) throws SQLException {
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
          conn = DriverManager.getConnection(url, userName, password);
//          st = conn.createStatement();
          String sql = "select * from course where credits = ? and dept_name = ?";
          // ps对象可以预编译后期给sql赋值实现动态赋值
          ps = conn.prepareStatement(sql);
//          executeUpdate 增删改都执行这条
//          rs = st.executeQuery(sql);
          //给占位符赋值，参数1是位置，参数二是值
          ps.setObject(1,4);
          ps.setObject(2,"Biology");
          rs = ps.executeQuery();
          while (rs.next()){
              String title = rs.getString("title");
              System.out.println(title);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } finally{
        // 释放资源
          if (rs!=null){
              rs.close();
          }
          if (ps!=null){
              ps.close();
          }
          if (conn!=null){
              conn.close();
          }
      }
  }
}
