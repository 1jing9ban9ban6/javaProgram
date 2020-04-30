package com.jing.test;

import com.jing.dao.accountDao;
import com.jing.pojo.account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.InputStream;
import java.util.List;

public class testMyBatis {
    @Test
    public void run() throws Exception{
        InputStream is = Resources.getResourceAsStream("mapping.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        accountDao mapper = session.getMapper(accountDao.class);
        List<account> allAccount = mapper.findAll();
        for (account account:allAccount){
            System.out.println(account);
        }
        session.close();
        is.close();
    }
}
