package com.jing.service;

import com.jing.dao.userDao;
import com.jing.dao.userDaoImpl;
import com.jing.pojo.user;

public class userServiceImpl implements userService {
    userDao userDao = new userDaoImpl();

    /**
     * 注册添加用户
     * @param user
     * @return 1 成功 2 失败 已经有该用户
     */
    @Override
    public String addUser(user user) {
        user userByName = userDao.findUserByName(user.getUsername());
        if (userByName==null){
            userDao.addUser(user);
            return "1";
        }
        else {
            return "2";
        }
    }

    /**
     * 用户登录
     * @param user
     * @return 1登录成功 2 失败
     */
    @Override
    public String findUserByNameAndPassword(user user) {
        user userByName = userDao.findUserByName(user.getUsername());
        if (userByName!=null && user.getPassword().equals(userByName.getPassword())){
            return "1";
        }
        return "2";
    }
}
