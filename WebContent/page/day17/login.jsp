<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/jdbcDemo4Login" method="post">
	<table cellpadding="5" cellspacing="1" border="0" align="center">
		<tr>
			<td><b>用户名：</b></td>
			<td><input type="text" name="name" id="name"  style="width: 160px" /></td>
		</tr>
		<tr>
			<td><b>密码：</b></td>
			<td><input type="password" name="password" id="password" style="width: 160px" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit"  value="登录" /></td>
		</tr>
	</table>
	</form>
</body>
</html>