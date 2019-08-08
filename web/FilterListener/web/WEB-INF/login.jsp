<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 2019/8/7
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:url var="url" value="${pageContext.request.contextPath}">--%>
<%--</c:url>--%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <%--也可以直接使用这种方式，让浏览器自动加上路径--%>
    <%--<link rel="stylesheet" type="text/css" href="css/index.css" />--%>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login">
    <div class="center">
        <div class="textRed">${requestScope.error}</div>
    <div>
        用户名：<input type="text" name="name"/>
    </div>
    <div>
        密码：<input type="text" name="password"/>
    </div>
    <div>
        <button>提交</button>
    </div>
    </div>
</form>
</body>
</html>
