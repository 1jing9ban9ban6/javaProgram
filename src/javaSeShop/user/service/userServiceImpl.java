package javaSeShop.user.service;


import javaSeShop.bean.User;
import javaSeShop.user.dao.userDao;
import javaSeShop.user.dao.userDaoIMpl;

public class userServiceImpl implements userService {
     userDao userDao = new userDaoIMpl();
    @Override
    public boolean checkIfAccountExist(String account) throws Exception{
        User userByAccount = userDao.getUserByAccount(account);
        if (userByAccount==null){
            return true;
        }
        return false;
    }

    @Override
    public String addUser(User user) throws Exception{
        boolean b = checkIfAccountExist(user.getAccount());
        if (b){
            userDao.addUser(user);
            return "1";
        }
        return "2";
    }

    @Override
    public String userLogin(String account, String password) throws Exception{
        boolean b = checkIfAccountExist(account);
        if (b){
            User userByAccount = userDao.getUserByAccount(account);
            if(userByAccount.getPassword().equals(password)){
                return "1";// 登录成功
            } else {
                return "2";// 用户名
            }
        }
        return "2";
    }

    @Override
    public String updateUserName(String account, String newName) throws Exception{
        boolean b = checkIfAccountExist(account);
        if (b){
            User userByAccount = userDao.getUserByAccount(account);
            userByAccount.setName(newName);
            userDao.updateUser(userByAccount);
            return "1";
        }
        return "2";
    }

    @Override
    public String updateUserAge(String account, int age) throws Exception{
        boolean b = checkIfAccountExist(account);
        if (b){
            User userByAccount = userDao.getUserByAccount(account);
            userByAccount.setAge(age);
            userDao.updateUser(userByAccount);
            return "1";
        }
        return "2";
    }

    @Override
    public String removeUser(String account) throws Exception{
        boolean b = checkIfAccountExist(account);
        if (b){
            userDao.removeUser(account);
            return "1";
        }
        return "2";
    }
}
