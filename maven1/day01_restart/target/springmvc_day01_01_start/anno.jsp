<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/17 0017
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <a href="anno/testRequestParam?name=aaa">RequestParam</a>--%>
<br>

<form action="anno/testRequestBody" method="post">
    用户姓名：<input type="text" name="username" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" />
</form>
    <a href="anno/testPathVariable/10">PathVariable</a>
    <a href="anno/testRequestHeader">RequestHeader</a>
    <a href="anno/testCookieValue">testCookieValue</a>


<form action="anno/testModelAttribute" method="post">
    用户姓名：<input type="text" name="username" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" />
</form>

</body>
</html>
