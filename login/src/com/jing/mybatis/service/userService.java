package com.jing.mybatis.service;

import com.jing.mybatis.model.user;

public interface userService {
    public user findUserByNameAndPassword(user u);
}
