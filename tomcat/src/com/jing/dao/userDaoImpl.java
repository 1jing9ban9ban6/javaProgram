package com.jing.dao;

import com.jing.pojo.user;
import com.jing.utils.BasicDao;

public class userDaoImpl implements userDao {
    BasicDao basicDao = new BasicDao();
    @Override
    public user findUserByName(String username) {
        String sql = "select * from user where username=?";
        user user = basicDao.getBean(user.class, sql, username);
        return user;
    }

    @Override
    public void addUser(user user) {
        String sql = "insert into user(username,age,password) values(?,?,?) ";
        basicDao.update(sql, user.getUsername(), user.getAge(), user.getPassword());

    }
}
