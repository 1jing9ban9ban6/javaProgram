package com.jing.service;

import com.jing.dao.userDao;
import com.jing.dao.userDaoImpl;
import com.jing.pojo.user;

public interface userService {
    /**
     *  增加用户
     * @param user
     * @return
     */
    public String addUser(user user);
    public String findUserByNameAndPassword(user user);

}
