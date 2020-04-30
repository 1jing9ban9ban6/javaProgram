<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/8 0008
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/testUser/100">测试get</a><br />
    <a href="${pageContext.request.contextPath}/testUser/100" methods="post">测试post</a>
<form action="${pageContext.request.contextPath}/testUser" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" name="s" value="测试put"/>
</form><br />
    <form action="${pageContext.request.contextPath}/testUser" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <input type="submit" name="s" value="测试delete"/>
    </form><br />
    <form action="${pageContext.request.contextPath}/param" method="post">
        username<input type="text" name="name" />
        password<input type="text" name="password" />
        age<input type="text" name="age" />
        <input type="submit" name="s" value="测试param"/>
    </form>
    <a href="${pageContext.request.contextPath}/modelAndView">测试modelAndView</a>
</body>
</html>
