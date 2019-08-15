<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 2019/8/8
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>sex</td>
        <td>date</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.age}</td>
            <td>${item.sex}</td>
            <td>${item.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
