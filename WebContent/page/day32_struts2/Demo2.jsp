<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用ognl来通过对象调用方法</title>
</head>
<body>
	<s:property value="'aaa'.length()"  /><br>
	<s:property value="@java.lang.Math@max(10,20)"  />
</body>
</html>