<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pargma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/d21Demo3Servlet1" method="post">
		<input type="text" name="name" value="post提交中文测试">
		<input type="submit" value="提交">
	</form>
</body>
</html>