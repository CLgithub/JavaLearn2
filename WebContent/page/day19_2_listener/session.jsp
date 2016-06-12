<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.setAttribute("sname", "svalues");	//添加
		
		session.setAttribute("sname", "ssssss");	//修改
		
		session.removeAttribute("sname");			//除移
	
	%>
</body>
</html>