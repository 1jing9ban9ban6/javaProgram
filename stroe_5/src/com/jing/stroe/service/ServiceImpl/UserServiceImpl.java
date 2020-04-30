package com.jing.stroe.service.ServiceImpl;

import com.jing.stroe.dao.UserDao;
import com.jing.stroe.dao.daoImpl.UserDaoImpl;
import com.jing.stroe.domain.User;
import com.jing.stroe.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserServiceImpl implements UserService {
    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean userRegist(User user) throws Exception{
        UserDao userDao = new UserDaoImpl();
        userDao.userRegist(user);
        return true;
    }

    /**
     * 用户激活
     * @param code
     * @return
     */
    @Override
    public User userActive(String code) throws Exception{
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserByCode(code);
        return user;
    }

    /**
     * 用户更新
     * @param user
     */
    @Override
    public void userUpdate(User user) throws Exception{
        UserDao userDao = new UserDaoImpl();
        userDao.userUpdate(user);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User userLogin(User user) throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user1 = userDao.findUserByNameAndPassword(user);
        if (user1 == null){
            throw new RuntimeException("用户名或密码不正确");
        } else if (user1.getState()==0){
            throw new RuntimeException("用户未激活");
        } else {
            return user1;
        }
    }
}
