package com.jing.mybatis.test;

import com.jing.mybatis.model.user;
import com.jing.mybatis.service.userService;
import com.jing.mybatis.service.userServiceImpl;
import org.junit.Test;

public class userTest {
    @Test
    public void findUserByNameAndPassword(){
        userService userService = new userServiceImpl();
        user user = new user();
        user.setUserName("");
        user.setPassword("123456");
        user re = userService.findUserByNameAndPassword(user);
        System.out.println(re);
    }
}
