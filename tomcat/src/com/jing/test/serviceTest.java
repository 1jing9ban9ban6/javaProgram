package com.jing.test;

import com.jing.pojo.user;
import com.jing.service.userService;
import com.jing.service.userServiceImpl;
import org.junit.Test;

public class serviceTest {
    userService userService = new userServiceImpl();
    @Test
    public void addUser(){
        user user = new user();
        user.setUsername("景122");
        user.setAge(18);
        user.setPassword("asasas");
        String s = userService.addUser(user);
        System.out.println(s);
    }

    @Test
    public void findUserByNameAndPassword(){
        user user = new user();
        user.setUsername("景122");
        user.setAge(18);
        user.setPassword("asasas");
        String s = userService.findUserByNameAndPassword(user);
        System.out.println(s);
    }
}
