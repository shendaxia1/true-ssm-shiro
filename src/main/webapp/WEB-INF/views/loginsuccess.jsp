<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆成功</title>
</head>
<body>
<h1>登陆成功</h1>
<shiro:hasAnyRoles name="1">
<a href="${pageContext.request.contextPath}/page/toAdmin">去admin页面</a>
</shiro:hasAnyRoles>
</body>
</html>