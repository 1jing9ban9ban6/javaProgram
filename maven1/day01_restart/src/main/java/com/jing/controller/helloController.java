package com.jing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class helloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello springMVC");
        return "success";
    }
}
