<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 2019/8/22
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/upload2">上传文件</a>
<table border="1">
    <tr>
        <td>文件id</td>
        <td>文件原始名</td>
        <td>文件现名</td>
        <td>操作</td>
    </tr>
    <c:choose>
        <c:when  test="${not empty requestScope.map}">
            <c:forEach var="item" items="${requestScope.map}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${item.key}</td>
                    <td>${item.value}</td>
                    <td><a href="${pageContext.request.contextPath}/download?origin=${item.key}&handled=${item.value}">下载</a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="4">暂无数据</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
