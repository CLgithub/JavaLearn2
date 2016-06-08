<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/AccountServlet" method="post">
		转入账户：<input type="text" name="accountin"><br>
		转出账户：<input type="text" name="accountout"><br>
		金额：<input type="text" name="money"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>