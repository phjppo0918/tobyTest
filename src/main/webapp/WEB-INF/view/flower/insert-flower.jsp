<%--
  Created by IntelliJ IDEA.
  User: Alex park
  Date: 2022-01-31
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/flower" method="post">
    이름 <input name="name" type="text">
    가격 <input name="price" type="text">
    꽃말 <input name="flowerLanguage" type="text">
    <input type="submit" value="꽃 등록하기!">
</form>
</body>
</html>
