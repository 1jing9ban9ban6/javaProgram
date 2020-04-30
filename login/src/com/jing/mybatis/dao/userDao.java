package com.jing.mybatis.dao;

import com.jing.mybatis.model.user;

public interface userDao {
    public user findUserByNameAndPassword(user u);
}
