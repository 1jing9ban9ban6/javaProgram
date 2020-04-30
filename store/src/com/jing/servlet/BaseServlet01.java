package com.jing.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

public class BaseServlet01 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 获取功能函数参数 通用servlet
        String method = request.getParameter("method");

        String path = null;

        // 判断功能，根据功能不同选择不同处理方式
        if("addStu".equals(method)){
            path = addStu(request, response);
        }else if ("delStu".equals(method)){
            path = delStu(request, response);
        }else if("checkUser".equals(method)){
            path = checkUser(request, response);
        }
        // 转发路径
        if (path != null){
            request.getRequestDispatcher(path).forward(request, response);
        }
    }
    protected String addStu(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("添加学生");
        return "/request.jsp";
    }
    protected String delStu(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("删除学生");
        return "/request.jsp";
    }
    protected String checkUser(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("检查学生");
        response.getWriter().println("ddd");
        return null;
    }
}
