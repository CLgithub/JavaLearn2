<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="l" uri="http://tag.cl.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自动登录</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/Demo5LoginServlet" method="post">
		<table cellpadding='5' cellspacing='1' border='0' align='center'>
		<tr>
			<td><b>用户名：</b></td>
			<td><input type='text' name='loginName' id='loginName' value="${user.loginName}" style='width: 160px' /></td>
		</tr>
		<tr>
			<td><b>密码：</b></td>
			<td><input type='password' name='password' id='password' value="${user.password}" style='width: 160px' /></td>
		</tr>
		<tr>
			
			<td colspan='2' align='right'>记住密码:<input type="checkbox" name="rememberMe" value="true" <c:if test="${user.loginName!=null}">checked="checked"</c:if> ><input type='submit' value='登录' /></td>
		</tr>
		</table>
	</form>
</body>
</html>