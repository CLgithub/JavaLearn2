<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>%用法</title>
</head>
<body>
	<%
		request.setAttribute("userName", "小强");
	%>
	<s:property value="#request.userName" /><br>
	<!-- 当前表达式会被做为ognl解析. -->
	<s:property value="%{#request.userName}"  /><br>
	<!-- 当前表达式不会被做为ognl解析。 -->
	<s:property value="%{'#request.userName'}" /><br>
	<!-- 当前表达式会被做为ognl解析. -->
	<s:textfield name="abc" value="%{#request.userName}" /><br>
	<!-- 当前表达式不会被做为ognl解析。 -->
	<s:textfield name="abc" value="#request.userName" /><br>
</body>
</html>