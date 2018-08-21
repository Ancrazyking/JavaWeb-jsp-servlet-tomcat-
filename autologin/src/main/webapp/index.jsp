<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>索引页面</title>
</head>
<body>
<h2>这是首页</h2>,
<c:if test="${not empty user}">
    欢迎您,${user.username}
</c:if>
<c:if test="${empty user}">
    您好,请登录!
</c:if>


</body>
</html>
