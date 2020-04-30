package javaSeShop.user.dao;

import javaSeShop.bean.User;

import java.util.ArrayList;

public interface userDao {
    // 增 往数据库增加一个用户
    public boolean addUser(User user) throws Exception;
    // 删 删除用户
    public boolean removeUser(String account) throws Exception;
    // 改 修改用户
    public boolean updateUser(User user) throws Exception;
    // 查 查找用户
    public User getUserByAccount(String account) throws Exception;// 根据账户查询
    public ArrayList<User> getUserByAgeRange(int min, int max) throws Exception; // 根据年龄范围查询
    public ArrayList<User> getUserByLevelRange(int min, int max) throws Exception; // 根据用户VIP等级查询
    public ArrayList<User> getUserByName(String name) throws Exception; //根据用户姓名查询



}
