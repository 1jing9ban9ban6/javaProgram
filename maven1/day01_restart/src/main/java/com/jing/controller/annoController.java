package com.jing.controller;

import com.jing.pojp.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
public class annoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username){
        System.out.println("执行了                "+username);
        return "success";
    }
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody() String body){
        System.out.println("执行了                "+body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name ="id") String id){
        System.out.println("执行了                "+id);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "accept") String head){
        System.out.println("执行了                "+head);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String jsessionId){
        System.out.println("执行了                "+jsessionId);
        return "success";
    }
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("a") user user){
        System.out.println(user);
        return "success";
    }

  //    @ModelAttribute
  //    public user say(String username){
  //        user user1 = new user();
  //        user1.setUsername(username);
  //        user1.setAge("20");
  //        user1.setDate(new Date());
  //        System.out.println("say执行了");
  //        return user1;
  //    }
      @ModelAttribute
      public void say(String username, Map<String, user> map) {
        user user1 = new user();
        user1.setUsername(username);
        user1.setAge("20");
        user1.setDate(new Date());
        map.put("a", user1);
    }
}
