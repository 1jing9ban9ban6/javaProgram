<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
</head>

<body>
	<div align="center">
		<form id="addform" name="addform" method="post" action="${pageContext.request.contextPath }/addsave.html">
			<input type="hidden" name="projectId" value="${projectId}"/>
			<table border="1px" style="width:400px; ">
				<tr>
					<td colspan="3" style="text-align: center;" ><h1>添加工单</h1></td>
				</tr>
				<tr>
					<td style="height: 42px;background-color:#dda0dc; ">执行人(*)：</td>
					<td><input type="text" id="executor" name="executor"/>
					</td>
				</tr>
				<tr>
					<td style="height: 60px;background-color:#dda0dc; ">任务描述(*)：</td>
					<td>    <textarea id="description" name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td style="height: 39px;background-color:#dda0dc; ">级别(*)：</td>
					<td><select id="orderLevel" name="orderLevel">
				        <option value="0">全部</option>
				        <option value="1">1级</option>
				        <option value="2">2级</option>
				        <option value="3">3级</option>
			            </select></td>
				</tr>
				<tr>
  					<td colspan="3" style="text-align: center;"><input type="submit" value="提交" id="add"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="../statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/workorderkadd.js"></script>
</html>
