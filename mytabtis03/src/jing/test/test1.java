package jing.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author jing
 * @create 2020-03-13-9:48
 */
public class test1 {
    @Test
    public void test1() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession(true);
        empMapper mapper = session.getMapper(empMapper.class);
        Emp emp = new Emp(1, "张三", 12, "1");
        emp.setAge(null);
        List<Emp> empByMore = mapper.getEmpByMore(emp);
        System.out.println(empByMore);
    }
    @Test
    public void test2() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession(true);
        empMapper mapper = session.getMapper(empMapper.class);
        Emp emp = new Emp(1, "张三", 12, "1");
        emp.setAge(null);
        List<Emp> empByMore = mapper.getEmpByChoose(emp);
        System.out.println(empByMore);
    }
    @Test
    public void test3() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession(true);
        empMapper mapper = session.getMapper(empMapper.class);
        Emp emp = new Emp(null, "宫十二", 12, "1");
        mapper.addEmp(emp);
    }
    @Test
    public void test4() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession(true);
        empMapper mapper = session.getMapper(empMapper.class);
        mapper.deleteMoreEmp("2,3,4");
    }
    @Test
    public void test5() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession(true);
        empMapper mapper = session.getMapper(empMapper.class);
        List<String> strings = Arrays.asList("5", "6");
        mapper.deleteMoreEmp1(strings);
    }
    @Test
    public void test6() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession(true);
        empMapper mapper = session.getMapper(empMapper.class);
        Emp emp1 = new Emp(7, "哈哈", 15, "1");
        Emp emp2 = new Emp(8, "呵呵", 15, "1");
        List<Emp> emps = Arrays.asList(emp1, emp2);
        Emp[] empss = (Emp[]) emps.toArray();
        mapper.updateMore(empss);
    }
}
