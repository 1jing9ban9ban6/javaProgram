<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<base href="http://localhost:8080/tomcat/">
<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(function () {
        //给文本框绑定focus事件 登录密码错了之后点击登录框 “登录错无得”消息就会消失
        $("#username").focus(function () {
            // 将显示错误信息中的文本置空
            $("#msgId").html("");
        });
        $("#login").click(function () {
            var name = $("#username").val();
            if (name == "") {
                alert("用户名不能为空");
                //取消提交表单的默认行为
                return false;
            }
            var password = $("#password").val();
            if (password == ""){
                alert("密码不能为空");
                return false;
            }
        });
    });
</script>
<body>
<form action="LoginServlet" method="get">
    <p>用户姓名: <input type="text" name="username" id="username"/>
        <span id="msgId">${msg}</span>
    </p>
    <p>用户密码: <input type="password" name="password" id="password" />
<%--        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
    </p>
    <input type="submit" value="get登录" id="login" />
</form>
</body>
</html>
