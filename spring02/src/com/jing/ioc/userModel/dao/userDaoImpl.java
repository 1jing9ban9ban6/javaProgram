package com.jing.ioc.userModel.dao;

import org.springframework.stereotype.Repository;

/**
 * @author jing
 * @create 2020-03-06-13:01
 */
@Repository
public class userDaoImpl implements userDao {
    public userDaoImpl(){
        System.out.println("userDaoImpl");
    }

    @Override
    public void addUser() {
        System.out.println("userDaoImpl+添加成功");
    }
}
