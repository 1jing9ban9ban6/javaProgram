package com.jing.test;

import com.jing.bean.user;
import com.jing.bean.userDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author jing
 * @create 2020-03-11-16:35
 */
public class test1 {
    @Test
    public void test1() throws Exception{
        InputStream ras = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(ras);
        SqlSession session = build.openSession();
        userDao mapper = session.getMapper(userDao.class);
        user user = mapper.selectUserById("10");
        System.out.println(user);
    }
}
