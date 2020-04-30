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

@WebServlet(name = "registerController" ,urlPatterns="/RegisterServlet")
public class registerController extends HttpServlet {
    userService userService = new userServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        user user = new user();
        user.setUsername(username);
        user.setAge(Integer.parseInt(age));
        user.setPassword(password);
        String s = userService.addUser(user);
        if (s.equals("1")){
            request.setAttribute("name",user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/success.jsp");
            requestDispatcher.forward(request,response);
        }
        else {
            response.sendRedirect("/tomcat/pages/fail.jsp");
        }
    }
}
