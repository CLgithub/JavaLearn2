<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>猜数字游戏</title>
</head>
<body>
	<%-- 显示信息 --%>
	<%=request.getAttribute("massage") %><br>
	<form action="/JavaLearn2/GuessServlet" method="post">
	<input type="text" name="userNum">
	<input type="submit" value="确定">
	</form>
</body>
</html>