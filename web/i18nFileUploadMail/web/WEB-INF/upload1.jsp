<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 2019/8/20
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload1" method="post" enctype="multipart/form-data">
    <div>用户名：<input type="text" name="text" id="text"/></div>
    <div>文件：<input type="file" name="file"/></div>
    <button>上传</button>
</form>
</body>
</html>
