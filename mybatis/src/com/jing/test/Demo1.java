package com.jing.test;

import com.jing.mapper.CourseMapper;
import com.jing.mapper.StudentMapper;
import com.jing.pojo.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Demo1 {
  public static void main(String[] args) throws Exception{
      // 获取全局配置输入流
      InputStream ras = Resources.
              getResourceAsStream("Sql.Map.Config.xml");
      // 根据输入流 创建一个对象 包含了所有信息 ，数据库 接口和 配置的xml 类似清单
      SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ras);
      // 开启回话 开始制作
      SqlSession session = factory.openSession();
      // 从回话中获取实现类 哪个类
      CourseMapper mapper = session.getMapper(CourseMapper.class);
      StudentMapper mapper1 = session.getMapper(StudentMapper.class);
      // 生成实现类 的哪个方法
//      List<course> allCourse = mapper.getAllCourse();
//      for (course course: allCourse){
//          System.out.println(course);
//      }
//      course c = mapper.getCourseByCourseId("BIO-399");
//      System.out.println(c);
      List<student> b = mapper1.getStudentByName("B");
      for (student s: b){
          System.out.println(s);
          session.close();
      }
  }
}
