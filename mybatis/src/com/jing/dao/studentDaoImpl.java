package com.jing.dao;

import com.jing.pojo.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class studentDaoImpl implements studentDao {
    // 使用mapper来开发dao层
    InputStream ras = Resources.
            getResourceAsStream("Sql.Map.Config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ras);
    SqlSession session = factory.openSession();

    public studentDaoImpl() throws IOException {
    }

    @Override
    public student getStudentById(String id) {
        // mybatis 也重写了studentDao接口并从xml中获取配置文件 真的去找了
        // 我们在创建类了之后好像是我们有这个方法，其实走的是代理方法，看起来好像是
        // 我们自己写的一样 cglib.jar 就是动态代理的

        studentDao mapper = session.getMapper(studentDao.class);
        student student = mapper.getStudentById(id);
        return student;
    }

    @Override
    public List<student> getStudentByName(String name) {
        return null;
    }

    @Override
    public boolean addStudent(student student) {
        return false;
    }

    @Override
    public boolean updateStudent(student student) {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        return false;
    }
}
