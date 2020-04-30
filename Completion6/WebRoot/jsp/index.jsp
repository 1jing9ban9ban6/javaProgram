<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>企业工单管理系统</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<div class="container-fluid">
    <div class="col-md-3" style="padding-top:20px">
        <ol class="list-inline">
            <c:if test="${empty loginUser}">
                <li><a href="${pageContext.request.contextPath}/UserServlet?method=loginUI">登录</a></li>
                <li><a href="${pageContext.request.contextPath}/UserRegisterStep">注册</a></li>
            </c:if>

            <c:if test="${not empty loginUser}">
                <li>欢迎${loginUser.username}</li>
                <li><a href="${pageContext.request.contextPath}/UserServlet?method=logOut">退出</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/product_list.jsp">历史工单</a></li>
                <li><a href="${pageContext.request.contextPath}/OrderServlet?method=findMyOrdersWithPage&num=1">我的订单</a></li>
            </c:if>
        </ol>
    </div>
</div>
<div align="center">
    <table border="1px">
        <tr>
            <td colspan="22" style="text-align: center; width:470px"><h2>企业工单管理系统</h2></td>
        </tr>
        <tr>
            <td style="background-color:#dda0dc; width:175px;">选择项目：</td>
            <td><input type="hidden" value="${workorder.projectId}" id="rid"/>
                <select name="projectId" id="projectId"></select>&nbsp;&nbsp;
                <button id="SubmitProject">确定</button>
            </td>
        </tr>
    </table>
</div>
</body>
<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="../statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/workorder.js"></script>
</html>
