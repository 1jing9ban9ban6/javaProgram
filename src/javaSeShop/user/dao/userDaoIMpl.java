package javaSeShop.user.dao;

import javaSeShop.bean.User;
import javaSeShop.constants.DataBaseConstants;
import javaSeShop.fileOperateUtils.readWriteUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class userDaoIMpl implements userDao{
    readWriteUtil<User> readWriteUtil = new readWriteUtil();
    @Override
    public boolean addUser(User user) throws Exception {
        // 取出整个user数据库
        HashMap<String, User> userHashMap = null;
        File file = new File(DataBaseConstants.USER_DATA_PATH);
        if (file.exists()){
            userHashMap = readWriteUtil.read(DataBaseConstants.USER_DATA_PATH);
        }else {
            userHashMap = new HashMap<>();
        }
        // 把新用户添加到Map里面
        userHashMap.put(user.getAccount(), user);
        // 把Map对象写数据库中
        readWriteUtil.write(userHashMap, DataBaseConstants.USER_DATA_PATH);
        return true;
    }

    @Override
    public boolean removeUser(String account) throws Exception{
        HashMap<String, User> userHashMap = readWriteUtil.read(DataBaseConstants.USER_DATA_PATH);

        userHashMap.remove(account);

        readWriteUtil.write(userHashMap, DataBaseConstants.USER_DATA_PATH);

        return true;
    }

    @Override
    public boolean updateUser(User user) throws Exception{
        HashMap<String, User> userHashMap = readWriteUtil.read(DataBaseConstants.USER_DATA_PATH);

        userHashMap.replace(user.getAccount(), user);

        readWriteUtil.write(userHashMap, DataBaseConstants.USER_DATA_PATH);

        return true;
    }

    @Override
    public User getUserByAccount(String account) throws Exception{
        HashMap<String, User> userHashMap = readWriteUtil.read(DataBaseConstants.USER_DATA_PATH);

        User user = userHashMap.get(account);

        return user;
    }

    @Override
    public ArrayList<User> getUserByAgeRange(int min, int max) throws Exception {
        HashMap<String, User> userHashMap = readWriteUtil.read(DataBaseConstants.USER_DATA_PATH);

        ArrayList<User> usersList = new ArrayList<>();

        Set<Map.Entry<String, User>> entries = userHashMap.entrySet();
        for (Map.Entry<String, User> entry:entries){
            if (entry.getValue().getAge() >= min && entry.getValue().getAge() <= max){
                usersList.add(entry.getValue());
            }
        }
        return usersList;
    }

    @Override
    public ArrayList<User> getUserByLevelRange(int min, int max) throws Exception{
        HashMap<String, User> userHashMap = readWriteUtil.read(DataBaseConstants.USER_DATA_PATH);

        ArrayList<User> usersList = new ArrayList<>();

        Set<Map.Entry<String, User>> entries = userHashMap.entrySet();
        for (Map.Entry<String, User> entry:entries){
            if (entry.getValue().getVipLevel() >= min && entry.getValue().getVipLevel() <= max){
                usersList.add(entry.getValue());
            }
        }
        return usersList;
    }

    @Override
    public ArrayList<User> getUserByName(String name) throws Exception{
        HashMap<String, User> userHashMap = readWriteUtil.read(DataBaseConstants.USER_DATA_PATH);

        ArrayList<User> usersList = new ArrayList<>();

        Set<Map.Entry<String, User>> entries = userHashMap.entrySet();
        for (Map.Entry<String, User> entry:entries){
            if (entry.getValue().getName().contains(name)){
                usersList.add(entry.getValue());
            }
        }
        return usersList;
    }
}
