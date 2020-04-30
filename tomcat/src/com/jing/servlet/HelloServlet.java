package com.jing.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 初始化
    }

    @Override
    public ServletConfig getServletConfig() {
        // 获取配置信息
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    //  处理请求
        System.out.println("hello");
        PrintWriter writer = servletResponse.getWriter();
        writer.write("response success");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        // 销毁
    }
}
