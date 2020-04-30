<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/21 0021
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
<base href="http://localhost:8080/day03/">
  <body>
  <%
      Date date = new Date();
      for(int i = 0;i<5;i++){
//          out.println("");
  %>
            <h3>天气好晴朗，处处好风光</h3>
  <%
      }
  %>
  <h3>现在的是时间是:<%=date%></h3>
<%--九大内置对象可以动态显示内嵌java代码--%>
  <h2><%=request.getParameter("username")%></h2>
  </body>
</html>
<%--page域
        范围 当前页面
        对应的域对象pageContext
        域对象的类型pageContext
    request域
        范围 当前请求（一次请求）
        对应的域对象：request
        域对象的类型HttpServletRequest
    session域
        范围 当前会话（一次会话）
        对应的域对象 session
        域对象的类型 HttpSession
    application域
        范围 当前web应用
        对应的域对象 application
        域对象的类型 ServletContext

四个对象都有以下三个方法
void setAttribute(string key，object value) 往域中放置
object getAttribute(string key) 从域中取值
void removeAttribute(string key) 从域中移除--%>
<%
    pageContext.setAttribute("pageKey","pageValue");
    request.setAttribute("reqKey","reqValue");
    session.setAttribute("sesKey","sesValue");
    application.setAttribute("appKey","appValue");
%>
<h1>获取属性值</h1>
pageContext<%= pageContext.getAttribute("pageKey")%><br/>
request<%= request.getAttribute("reqKey")%><br/>
session<%= session.getAttribute("sesKey")%><br/>
application<%= application.getAttribute("appKey")%>
<%--<jsp:forward page="index1.jsp"></jsp:forward>    相当于一次请求 （转发标签）--%>
<%--两次请求--%>
<a href="index1.jsp">去index1页面</a>