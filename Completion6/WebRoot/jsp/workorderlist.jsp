<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">

<title>电子图书列表</title>
 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/workorder.css" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<c:if test="${workoredrList==null||workoredrList==''}">
	<%
		request.getRequestDispatcher("workorderlist.html").forward(request, response);
	%>
</c:if>
</head>
<body>
	<div align="center">
		<table border="1px">
			<tr>
				<td colspan="6" align="center"><h1>企业工单管理系统</h1>
				</td>
			</tr>
			<tr style="background-color:#808080;">
				<th style="width:65px;">工单编号</th>
				<th>项目名称</th>
				<th style="width:50px;">执行人</th>
				<th>任务描述</th>
				<th style="width:35px;">级别</th>
				<th>创建时间</th>
			</tr>
			<c:forEach var="w" items="${workoredrList}" varStatus="num">
				<tr
					<c:if test="${num.index % 2==1}">style="background-color:rgb(222,158,226)"</c:if>>
					<td>${w.id}</td>
					<td>${w.projectName}</td>
					<td>${w.executor}</td>
					<td>${w.description}</td>
					<td>${w.orderLevel}级</td>
					<td><fmt:formatDate value="${w.createDate}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="center"><span>${tishi}</span></td>
			</tr>
		</table>
	</div>
</body>
</html>
