<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 2019/8/1
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
<br/>
<div style="width:100%;text-align: center;">
    页数：${requestScope.page.current}/${requestScope.page.totalPage}&#12288;&#12288;&#12288;
    <a href="${pageContext.request.contextPath}/page?p=${requestScope.page.current-1>1?requestScope.page.current-1:1}">上一页</a>&#12288;&#12288;&#12288;
    <a href="${pageContext.request.contextPath}/page?p=${requestScope.page.current+1>requestScope.page.totalPage?requestScope.page.totalPage:requestScope.page.current+1}">下一页</a>&#12288;&#12288;&#12288;
    <%--不写items，则会当成普通的for循环来使用--%>
    <c:forEach var="i" begin="1" end="${requestScope.page.totalPage}">
        <a href="${pageContext.request.contextPath}/page?p=${i}">${i}</a>&#12288;
    </c:forEach>
    <br/>
    总行数：${requestScope.page.totalRow}
</div>
</body>
</html>
