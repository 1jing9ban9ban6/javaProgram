package javaSeShop.user.service;

import javaSeShop.bean.User;

public interface userService {
    // 检查用户是否已存在
    public boolean checkIfAccountExist(String account) throws Exception;
    // 添加用户
    public String addUser(User user) throws Exception;
    // 登录
    public String userLogin(String account, String password) throws Exception;

    public String updateUserName(String account,String newName) throws Exception;

    public String updateUserAge(String account, int age) throws Exception;

    public String removeUser(String account) throws Exception;

}
