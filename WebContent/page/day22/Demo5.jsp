<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>超链接下载</title>
</head>
<body>
	<a href="${pageContext.servletContext.contextPath}/uploadFile/c/2/fileName">超链接下载</a><br>
	<hr>
	<a href="${pageContext.servletContext.contextPath}/DownLoad1?fileName=xxx">流下载</a><br>
</body>
</html>