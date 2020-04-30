package com.jing.stroe.dao;

import com.jing.stroe.domain.User;

public interface UserDao {
    public void userRegist(User user) throws Exception;

    public User findUserByCode(String code) throws Exception;

    public void userUpdate(User user) throws Exception;

    public User findUserByNameAndPassword(User user) throws Exception;
}
