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
<!--
如果路径是/demo1，比如当前访问地址是http://localhost:8080/gather/list，则此访问地址是：localhost:8080/demo1
如果路径是demo1，则此访问地址是：http://localhost:8080/gather/demo1；加上/是取根路径，不加/则是当前目录(比如此处是gather/)加上访问路径
-->
<a href="demo1">bbb</a>
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
                    <td>
                        <a href="${pageContext.request.contextPath}/download?origin=${item.key}&handled=${item.value}">下载</a>
                        <br/>
                        <!--此处就算直接写上文件路径，也不会下载文件，将会在浏览器中打开此文件而已-->
                        <a href="upload/${item.key}">下载2</a>
                    </td>
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
