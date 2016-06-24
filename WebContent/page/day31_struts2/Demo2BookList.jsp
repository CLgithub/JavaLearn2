<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
	你好[${user.name}]<br>
	<a href="${pageContext.servletContext.contextPath}/day31_2/Demo2BookAction_add">新增</a><br>
	<a href="${pageContext.servletContext.contextPath}/day31_2/Demo2BookAction_update">修改</a><br>
	<a href="${pageContext.servletContext.contextPath}/day31_2/Demo2BookAction_delete">删除</a><br>
	<a href="${pageContext.servletContext.contextPath}/day31_2/Demo2BookAction_search">查询</a>
</body>
</html>