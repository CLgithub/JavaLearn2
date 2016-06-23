<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>list</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/Demo2ListAction_" method="post">
		<table cellpadding='5' cellspacing='1' border='0' align='center'>
			<tr>
				<td><b>用户名1：</b></td><td><input type='text' name='users[0].name' id='name' style='width: 160px' /></td>
			</tr>
			<tr>
				<td><b>密码1：</b></td><td><input type='password' name='users[0].password' id='password' style='width: 160px' /></td>
			</tr>
			<tr>
				<td><b>用户名2：</b></td><td><input type='text' name='users[1].name' id='name' style='width: 160px' /></td>
			</tr>
			<tr>
				<td><b>密码2：</b></td><td><input type='password' name='users[1].password' id='password' style='width: 160px' /></td>
			</tr>
			<tr>
				<td colspan='2' align='right'>${msg}<input type='submit' value='提交' /></td>
			</tr>
		</table>
	</form>
</body>
</html>