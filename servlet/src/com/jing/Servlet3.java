package com.jing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jing
 * @create 2020-03-03-9:06
 * context context 的 config init的
 */

public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRealPath("/");//会得到 工程在磁盘的绝对路径 /代表web
        ServletContext servletContext = getServletContext(); // 获取context对象
        servletContext.setAttribute("s","values");
        System.out.println(request.getRequestURI()+"uri");
        System.out.println(request.getRequestURL()+"url");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRealPath("/");//会得到 工程在磁盘的绝对路径 /代表web
        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = getServletContext(); // 获取context对象
        servletContext.setAttribute("s","values");
        System.out.println(request.getRequestURI()+"uri");
        System.out.println(request.getRequestURL()+"url");

        // 请求转发 的操作 相当于 柜台一到柜台而 /就是http://localhost:8080/servlet/
        // 也映射到了 idea的web目录但是servlet赔了地址所以直接写转发的servlet就行
        //  转发的地址不会变 因为实在服务器内部 处理的 他们共享request的数据
        // web-inf 里面的通过浏览器地址访问不了 但是 可以通过转发。因为这相当于服务器私有的  只有在服务器里面才能操作
        // 他不能出工程 访问不了百度  只能在web里面的 这个工程的资源
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        requestDispatcher.forward(request,response);
        // 设置response的字符集
        response.setCharacterEncoding("utf-8");//服务器的字符集
        response.setHeader("Content-Type", "text/html;charset=UTF-8"); // 设置响应头 让他的字符集也是utf-8
        response.setContentType("text/html;charset=UTF-8");// 这是另一个方法 只需一个函数同时设置服务器和浏览器汉字的编码格式很牛逼
        PrintWriter writer = response.getWriter();
        writer.println("很帅");

        // 重定向
        response.setStatus(302);// 302设置响应码 302表示重定向
        response.setHeader("Location", "http://localhost:8080/servlet/resp2"); // 这样子就重定向了
        // 重定向特点  地址栏会发生变化，而且是两次请求不共享request中数据 因为 两次请求
        // 每一次请求都是一个新的servlet对象 生成新的re rep 对象
        // 但是他重定向 不能 访问webInfo 因为那是服务器内部资源
        // 第二种
        response.sendRedirect("http://localhost:8080/servlet/resp2");
    }
}
