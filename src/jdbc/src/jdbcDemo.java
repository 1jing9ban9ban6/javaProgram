package jdbc.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDemo {
  public static void main(String[] args){
      try{
          // 注册驱动 程序要链接数据库的类型
    //      new Driver();
          Class.forName("com.mysql.jdbc.Driver"); // 防止两次注册 可以动态注册有利于代码扩展维护
          // 获取数据库链接
          // url 请求协议，用户名密码  返回一个链接了的对象
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",
                  "root", "123456");
          // 连接了的对象要执行sql语句要创建 对象
          Statement st = conn.createStatement();
          // 这里的？相当于占位符 数据不确定 在执行sql语句之前要给占位符设置值
          ResultSet rs = st.executeQuery("select * from course where id = ?");
          // 遍历结果数据
          while (rs.next()){
              // 索引值从1开始计数
              String s = rs.getString(1);
              System.out.println(s);
          }
      }catch (Exception e){
          e.printStackTrace();
      } finally{
          // 关闭链接
      }

  }
}
