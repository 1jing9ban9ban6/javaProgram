package com.jing.controller;

import com.jing.pojo.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class userController {
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了");
        user user = new user();
        user.setUsername("美美");
        user.setAge(30);
        user.setPassword("123456");
        model.addAttribute("user",user);
        return "success";
    }
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testString执行了");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("testModelAndView执行了...");
        user user = new user();
        user.setUsername("美美");
        user.setAge(30);
        user.setPassword("123456");
        modelAndView.addObject(user);
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("testForwardOrRedirect执行了...");

//        return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }
}
