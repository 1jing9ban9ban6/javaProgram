package com.jing.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet" ,urlPatterns="/SecondServlet")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1获取请求的参数
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2获取项目的虚拟路径
        String contextPath = request.getContextPath();
        // 3进行请求的转发 就是个跳转到别的页面
            // 获取转发器
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/success.jsp");
        requestDispatcher.forward(request,response);

//        PrintWriter writer = response.getWriter();
//        writer.write("response POST success");
        System.out.println("POST second"+" "+username+" "+password);
//   POST 請求
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //        String username = request.getParameter("username");
    //        String password = request.getParameter("password");
    // response的租用
        // 向页面响应东西
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("相应成功");
        System.out.println("get second");
        //    GET 請求

//        转发和重定向区别：转发发送一次请求 重定向是两次
//        转发地址栏不变化，重定向地址栏要变化 转发可以访问web-inf的资源 重定向不可以
//        转发可以共享request中的数据，重定向不可以
    }
}
