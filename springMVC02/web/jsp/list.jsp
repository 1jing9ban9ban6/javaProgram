<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
    <table>
        <tr>
            <th>id</th>
            <th>lastName</th>
            <th>email</th>
            <th>gender</th>
            <th>departmentName</th>
            <th>option<a href="${pageContext.request.contextPath}/emp">add</a></th>
        </tr>
        <c:forEach items="${emps}" var="emps">
            <tr>
                <td>${emps.id}</td>
                <td>${emps.lastName}</td>
                <td>${emps.email}</td>
                <td>${emps.gender==0?"女":"男"}</td>
                <td>${emps.department.departmentName}</td>
                <td><a href="${pageContext.request.contextPath}/emp/${emps.id}">update</a></td>
                <td><a href="${pageContext.request.contextPath}/emp">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
