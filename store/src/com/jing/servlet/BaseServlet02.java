package com.jing.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet02 extends javax.servlet.http.HttpServlet{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 获取功能函数参数 通用servlet
        String method = request.getParameter("method");

        String path = null;

        // 判断功能，根据功能不同选择不同处理方式 用反射
        Class aClass = this.getClass();
        Method md = null;
        try {
            md = aClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            if (md != null){
                path = (String)md.invoke(this, request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 转发路径
        if (path != null){
            request.getRequestDispatcher(path).forward(request, response);
        }
    }
    public String addStu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("添加学生");
        return "/request.jsp";
    }
    public String delStu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("删除学生");
        return "/request.jsp";
    }
    public String checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("检查学生");
        response.getWriter().println("ddd");
        return null;
    }
}

