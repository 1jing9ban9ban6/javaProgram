<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/16 0016
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
  </head>
  <body>
<%-- 调用服务端的三种情况，form表单 a标签链接 按钮 --%>
    <form action="BaseServlet02?method=addStu" method="post">
        用户<input type="text" name="username"/><br/>
        <button>提交</button>
    </form>
    <br/>
    <a href="BaseServlet02?method=delStu">删除学生</a><br/>
    <button onclick="fn()">按钮</button>
  <script>
      function fn() {
          $.post("BaseServlet02",{"method":"checkUser","user":"tom"},function (data) {
                alert(data);
          });
      }
  </script>
  </body>
</html>
