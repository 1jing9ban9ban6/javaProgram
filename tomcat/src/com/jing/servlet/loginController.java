package com.jing.servlet;

import com.jing.pojo.user;
import com.jing.service.userService;
import com.jing.service.userServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginController" ,urlPatterns="/LoginServlet")
public class loginController extends HttpServlet {
    userService userService = new userServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user user = new user();
        user.setUsername(username);
        user.setPassword(password);
        String s = userService.findUserByNameAndPassword(user);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
//        writer.write("登录成功欢迎你");
        if(s.equals("1")){
            request.setAttribute("name",user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/success.jsp");
            requestDispatcher.forward(request,response);
        }
        else {
            request.setAttribute("msg","用户名或密码不正确");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/login.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
