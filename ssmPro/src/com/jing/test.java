package com.jing;

import com.jing.bean.Emp;
import com.jing.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author jing
 * @create 2020-03-14-16:33
 */
public class test {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession session = factory.openSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        System.out.println(allEmp);
    }
}
