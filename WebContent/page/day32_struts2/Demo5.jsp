<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用ognl获取valueStack中的数据</title>
</head>
<body>
	<s:debug />
	<hr>
	valueStack（中的context）中root的数据：<br>
	<s:property value="#root" />
	<hr>
	1获取push方式存储的数据<br>
	<s:property value="#root[1].top" />
	<br>
	<s:iterator value="#root[1].top" var="user">
		userName:<s:property value="userName" />
		password:<s:property value="#user.password" />
		<br>
	</s:iterator>
	<hr>
	2获取push方式存储的数据<br>
	<s:property value="#root[0].top.users2" /><br>
	<s:iterator value="#root[0].top.users2" var="user">
		userName:<s:property value="#user.userName" />
		password:<s:property value="#user.password" />
		<br>
	</s:iterator>
</body>
</html>