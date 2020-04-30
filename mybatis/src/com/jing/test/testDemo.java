package com.jing.test;

import com.jing.mapper.StudentMapper;
import com.jing.pojo.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class testDemo {
    // 获取全局配置输入流
    InputStream ras = Resources.
            getResourceAsStream("Sql.Map.Config.xml");
    // 根据输入流 创建一个对象 包含了所有信息 ，数据库 接口和 配置的xml 类似清单
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ras);
    // 开启回话 开始制作
    SqlSession session = factory.openSession();

    public testDemo() throws IOException {
    }


    @Test
    public void addStudentTest() {
        student student = new student("12245",
                "Jack", "Physics", 92);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.addStudent(student);
        session.commit();
    }

    @Test
    public void updateStudent(){
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        student student = mapper.getStudentById("12245");
        student.setName("jackKey");
        student.setTot_cred(99);
        mapper.updateStudent(student);
        session.commit();
    }

    @Test
    public void deleteStudent(){
        session.delete("com.jing.mapper.StudentMapper.deleteStudent","12245");
        session.commit();
        session.close();
    }
}
