<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>list</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/Demo2MapAction_" method="post">
		<table cellpadding='5' cellspacing='1' border='0' align='center'>
			<tr>
				<td><b>mapA：</b></td><td><input type='text' name="map['aaa'].name" id='name' style='width: 160px' /></td>
			</tr>
			<tr>
				<td><b>mapA：</b></td><td><input type='password' name="map['aaa'].password" id='password' style='width: 160px' /></td>
			</tr>
			<tr>
				<td><b>mapB：</b></td><td><input type='text' name="map['bbb'].name" id='name' style='width: 160px' /></td>
			</tr>
			<tr>
				<td><b>mapB：</b></td><td><input type='password' name="map['bbb'].password" id='password' style='width: 160px' /></td>
			</tr>
			<tr>
				<td colspan='2' align='right'>${msg}<input type='submit' value='提交' /></td>
			</tr>
		</table>
	</form>
</body>
</html>