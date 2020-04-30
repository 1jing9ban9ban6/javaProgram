package com.jing.test;

import com.jing.dao.userDaoImpl;
import com.jing.dao.userDao;
import com.jing.pojo.user;
import com.jing.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class daoTest {
    userDao userDao = new userDaoImpl();
    @Test
    public void jdbcUtilsTest(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void findUserByName(){
        user user1 = userDao.findUserByName("张三丰");
        System.out.println(user1);
    }

    @Test
    public void addUser(){
        user user = new user();
        user.setUsername("景123");
        user.setAge(24);
        user.setPassword("asasas");
        userDao.addUser(user);
    }
}
