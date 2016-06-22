<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>demo5</title>
</head>
<body>
	<%
		application.setAttribute("msg1", "aaa");
		session.setAttribute("msg2", "bbb");
	%>
	
	<a href="${pageContext.servletContext.contextPath}/struts2Demo5_">访问demo5action</a>
	<hr>
	${userName}
</body>
</html>