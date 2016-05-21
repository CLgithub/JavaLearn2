<%@ page 
	language="java" 	
	import="java.util.*,java.net.*"
    pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"
	errorPage="common/error.jsp"				
	isErrorPage="false"
	session="true"
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page指令</title>
</head>
<body>
	<!-- 产生一个异常来测试 -->
	<%
		int i=100/0;
	%>
</body>
</html>