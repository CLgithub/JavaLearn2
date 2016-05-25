<%@page import="day13_el.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jspy页面使用javaBean</title>
</head>
<body>
	<%-- <%
		Student s1=new Student();
		s1.setName("小白");
		s1.setAge(23);
	%> --%>
	
	<%--创建对象  	Student s1=new Student();--%>
	<jsp:useBean id="s1" class="day13_el.Student" />
	<%--赋值 	 s1.setName("小白"); --%>
	<jsp:setProperty name="s1" property="name" value="小白" />
	<%--获取值 	 s1.getName()--%>
	<jsp:getProperty name="s1" property="name" />
	
	<br>
	<% 
		pageContext.setAttribute("s1", s1);
	%>
	${s1}	
</body>
</html>