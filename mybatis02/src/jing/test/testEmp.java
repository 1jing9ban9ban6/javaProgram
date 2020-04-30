package jing.test;

import jing.bean.Dept;
import jing.bean.Emp;
import jing.mapper.deptMapper;
import jing.mapper.empMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-12-10:41
 */
public class testEmp {
    @Test
    public void test1() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession();
        empMapper mapper = session.getMapper(empMapper.class);
        Emp empById = mapper.getEmpById(1);
        System.out.println(empById);
//        List<Emp> allEmp = mapper.getAllEmp();
//        System.out.println(allEmp);
//        Map<String, Emp> allEmpMap = mapper.getAllEmpMap();
//        Collection<Emp> values = allEmpMap.values();
//        Iterator<Emp> iterator = values.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        Emp emp = new Emp();
//        Integer integer = mapper.addEmp(emp);
//        session.commit();
//        System.out.println(emp);
    }
    @Test
    public void test2() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession();
        deptMapper mapper = session.getMapper(deptMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        System.out.println(allEmp);
    }
    @Test
    public void test3() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession();
        deptMapper mapper = session.getMapper(deptMapper.class);
        Emp empById = mapper.getEmpById("1");
        System.out.println(empById);
    }

    @Test
    public void test4() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession();
        deptMapper mapper = session.getMapper(deptMapper.class);
        Dept deptEmpById = mapper.getDeptEmpById(1);
        System.out.println(deptEmpById);
    }

    @Test
    public void test5() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = build.openSession();
        deptMapper mapper = session.getMapper(deptMapper.class);
        Dept deptByIdStep = mapper.getDeptByIdStep("1");
        System.out.println(deptByIdStep);
    }
}
