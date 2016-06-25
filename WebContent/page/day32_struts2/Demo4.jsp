<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用ognl取出valueStack中的数据</title>
</head>
<body>
	<s:debug />
	<hr>
	1.根据map的key依次查找数据<br>
	<s:property value="#root"/><br>
	<s:property value="#root.userName"/><br><!-- #root不省略，相当于是取出context中的root，再从root中去取 -->
	<s:property value="userName"/><br><!-- #root省略,相当于时从root中去取  -->
	<hr>
	2.从某个位置开始查找数据，top只查找某个位置的数据<br>
	<s:property value="[0].top"/><br>
	<hr>
	3.获取OgnlContext中的数据<br>
	<% 
		request.setAttribute("rName", "rValue");
		session.setAttribute("sName", "sValue");
		application.setAttribute("aName", "aValue");
	%>
	
	获取request中的数据：<s:property value="#request.rName"/><br>
	获取session中的数据：<s:property value="#session.sName"/><br>
	获取application中的数据：<s:property value="#application.aName"/><br>
	在request,session,application中查找数据：<s:property value="#attr.aName"/><br>
	获取请求参数：<s:property value="#parameters.userName"/><br>
</body>
</html>