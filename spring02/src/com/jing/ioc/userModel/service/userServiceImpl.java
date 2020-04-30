package com.jing.ioc.userModel.service;

import com.jing.ioc.userModel.dao.userDao;
import com.jing.ioc.userModel.dao.userDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author jing
 * @create 2020-03-06-13:00
 */
@Service
public class userServiceImpl implements userService {
    /**
     * 本质还是之前的bytype赋值
     * 因为注解扫描生成的全是实现类 impl 但是 你的变量名是接口的名字 所以是类型
     */
    @Autowired
    @Qualifier("userMybatisDaoImpl")
    private userDao userDao;

    public userServiceImpl() {
        System.out.println("userServiceImpl");
    }

    @Override
    public void addUer() {
        userDao.addUser();
    }
}
