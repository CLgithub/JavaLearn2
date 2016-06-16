<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="l" uri="http://tag.cl.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%!
	ResourceBundle bundle=null; 
%>
<%
	String country=request.getParameter("country");
	bundle=ResourceBundle.getBundle("message", Locale.CHINA);
	if("US".equals(country)){
		bundle=ResourceBundle.getBundle("message", Locale.US);
	}else {
		bundle=ResourceBundle.getBundle("message", Locale.CHINA);
	}
%>
<title><%=bundle.getString("loginPage") %></title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/Demo5LoginServlet" method="post">
		<table cellpadding='5' cellspacing='1' border='0' align='center'>
		<tr>
			<td><b><%=bundle.getString("loginName")%>：</b></td>
			<td><input type='text' name='loginName' id='loginName' value="${user.loginName}" style='width: 160px' /></td>
		</tr>
		<tr>
			<td><b><%=bundle.getString("password")%>：</b></td>
			<td><input type='password' name='password' id='password' value="${user.password}" style='width: 160px' /></td>
		</tr>
		<tr>
			<td colspan='2' align='right'>
			<input type='submit' value='<%=bundle.getString("login")%>' /></td>
		</tr>
		</table>
		
	</form>
	<a href="?country=CN" >中文</a>
	<a href="?country=US" >English</a>
	
</body>
<script type="text/javascript">
</script>
</html>