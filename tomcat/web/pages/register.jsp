<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19 0019
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<base href="http://localhost:8080/tomcat/">
<body>
<form action="RegisterServlet" method="post">
    <p>用户姓名: <input type="text" name="username" /></p>
    <p>用户密码: <input type="password" name="password" /></p>
    <p>用户年龄: <input type="text" name="age" /></p>
    <input type="submit" value="post立即注册" />
</form>
</body>
</html>
