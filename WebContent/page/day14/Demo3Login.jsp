<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://tag.cl.com"  prefix="l" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
开发一个含有[用户名]和[密码]的登录表格标签
   	 <form action="#" method="post"> 
  		<simple:login username="username(表单项名字)" 
						password="password(表单项名字)" />
  	 </form>
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义标签练习</title>
</head>
<body>
	<l:loginForm action="" method="post" userName="userName" password="password" />
</body>
</html>