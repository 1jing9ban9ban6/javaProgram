<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
<%-- 引入jquery 的库--%>
      <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js"></script>
      <script type="text/javascript">
          alert($);
      </script>
<%--      <script type="text/javascript">--%>
<%--          // 获取变量名字--%>
<%--          window.onload = function () {--%>
<%--              var btn = document.getElementById("first")--%>
<%--              btn.onclick = function () {--%>
<%--                  alert("hello js")--%>
<%--              }--%>
<%--          };--%>
<%--      </script>--%>
  </head>
  <body>
      <h1>index2获取属性值</h1>
      pageContext<%= pageContext.getAttribute("pageKey")%><br/>
      request<%= request.getAttribute("reqKey")%><br/>
      session<%= session.getAttribute("sesKey")%><br/>
      application<%= application.getAttribute("appKey")%>

  <button id="first">hello</button>
  </body>

