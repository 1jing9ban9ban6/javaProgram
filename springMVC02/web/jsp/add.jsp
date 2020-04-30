<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/9 0009
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/emp" method="post">
        <table>
            <tr>
                <th colspan="2">添加员工信息</th>
            </tr>
            <tr>
                <td>lastName</td>
                <td>
                    <input type="text" name="lastName"/>
                </td>
            </tr>
            <tr>
                <td>email</td>
                <td>
                    <input type="text" name="email"/>
                </td>
            </tr>
            <tr>
                <td>gender</td>
                <td>
                    <input type="radio" name="gender" value="1"/>男
                    <input type="radio" name="gender" value="0"/>女
                </td>
            </tr>
            <tr>
                <td>department</td>
                <td>
                    <select name="department.id">
                        <option>select-department</option>
                        <c:forEach items="${depts}" var="depts">
                            <option value="${depts.id}">${depts.departmentName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="add"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
