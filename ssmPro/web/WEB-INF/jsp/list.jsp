<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示员工信息</title>
</head>
<body>
<table>
    <tr>
        <th>eid</th>
        <th>ename</th>
        <th>age</th>
        <th>sex</th>
        <th>dname</th>
        <th>option<a href="${pageContext.request.contextPath}/emp">add</a></th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.eid}</td>
            <td>${emp.ename}</td>
            <td>${emp.age}</td>
            <td>${emp.sex==0?"女":"男"}</td>
            <td>${emp.dept.dname}</td>
            <td><a href="${pageContext.request.contextPath}/emp/${emp.eid}">update</a></td>
            <td><a href="${pageContext.request.contextPath}/emp">delete</a></td>
        </tr>
    </c:forEach>
</table>
${page}
</body>
</html>
