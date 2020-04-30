package com.jing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author jing
 * @create 2020-03-08-14:59
 */
@Controller
//@RequestMapping("/first")
public class testController {
    @RequestMapping(value = "/hello", method = RequestMethod.POST, params = {"username", "age=13"})
    public String hello(){
        System.out.println("hellooo");
        return "success";
    }
// 后面的参数其实是对这个方法进行修正 符合条件的才能被执行
// 这个params就是请求过来的参数只有
// header是请求头信息 是一个非常鸡肋的功能 *一级目录？一个字符 ** 多级目录
//    @RequestMapping(value = "/*/and??/**/hello")
////    public String helloGet(){
////        System.out.println("hellooo");
////        return "success";
////    }
    @RequestMapping(value = "/hello/{id}/{username}")
    public String helloGet(@PathVariable("id")Integer id, @PathVariable("username")String username){
        System.out.println(id+""+username);
        return "success";
    }
    @RequestMapping(value = "/testUser/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id")Integer id){
        System.out.println("id"+"="+id);
        return "success";
    }
    @RequestMapping(value = "/testUser/{id}", method = RequestMethod.POST)
    public String postUser(@PathVariable("id")Integer id){
        System.out.println("id"+"="+id);
        return "success";
    }
    @RequestMapping(value = "/testUser", method = RequestMethod.PUT)
    public String putUser(){
        System.out.println("我执行了");
        return "success";
    }
    @RequestMapping(value = "/testUser", method = RequestMethod.DELETE)
    public String deleteUser(){
        System.out.println("我执行了");
        return "success";
    }
//当不满足赋值条件时候用@requestParam的value 属性设置形
    @RequestMapping(value = "/param", method = RequestMethod.POST)
    public String param(@RequestParam(value = "name",required = false, defaultValue = "admin") String username, String password, String age){
        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        return "success";
    }
//    @RequestHeader 就是获取请求 头的参数 用法就和requestParam用法一样
//    放置参数的三种方式 约等于setAttribute
    @RequestMapping(value = "/modelAndView", method = RequestMethod.GET)
    public ModelAndView param(){
        ModelAndView view = new ModelAndView();
        view.addObject("name", "root");
        view.setViewName("success");
        return view;
    }
    @RequestMapping(value = "/modelAndView1", method = RequestMethod.GET)
    public String param1(Map<String, Object> map){
        map.put("name", "root");
        return "success";
    }
    @RequestMapping(value = "/modelAndView2", method = RequestMethod.GET)
    public String param2(Model model){
        model.addAttribute("name", "root");
        return "success";
    }
}
