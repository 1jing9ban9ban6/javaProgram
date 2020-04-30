package com.jing.stroe.service;

import com.jing.stroe.domain.User;

public interface UserService {
    // 用户注册
    public boolean userRegist(User user) throws Exception;
    // 用户激活
    public User userActive(String code) throws Exception;
    // 用户更新
    public void userUpdate(User user) throws Exception;
    // 用户登录
    public User userLogin(User user) throws Exception;
}
