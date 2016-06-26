<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el表达式获取valueStack中的数据</title>
</head>
<body>
	<s:debug />
	<hr>
	valueStack（中的context）中root的数据：<br>
	<s:property value="#root" />
	<hr>
	ognl表达式获取：<s:property value="#root.userName" /><br>
	el表达式获取：${userName}
</body>
</html>