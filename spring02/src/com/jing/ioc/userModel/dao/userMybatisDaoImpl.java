package com.jing.ioc.userModel.dao;

import org.springframework.stereotype.Repository;

/**
 * @author jing
 * @create 2020-03-06-21:00
 */
@Repository
public class userMybatisDaoImpl implements userDao {
    @Override
    public void addUser() {
        System.out.println("userMybatisDaoImpl 创建成功");
    }
}
