package com.jing.dao;

import com.jing.pojo.user;

public interface userDao {
    /**
     * 根据用户名从数据库中查询对应记录
     * @param username 用户名
     * @return user 有次记录 null 无此记录
     */
    public user findUserByName(String username);

    /**
     * 增加用户
     * @param user
     * @return
     */
    public void addUser(user user);
}
