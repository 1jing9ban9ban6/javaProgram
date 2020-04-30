package com.jing.ioc.userModel.controller;

import com.jing.ioc.userModel.service.userService;
import com.jing.ioc.userModel.service.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.nio.file.attribute.UserPrincipalLookupService;

/**
 * @author jing
 * @create 2020-03-06-12:59
 */
// 为自动生成的bean指定id
@Controller("userController")
public class userController {
    @Autowired
    userService userService;

    public userController (){
        System.out.println("userController");
    }
    public void addUser(){
        userService.addUer();
    }
}
