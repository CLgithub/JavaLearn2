<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tag.cl.com"  prefix="l" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义标签实现c标签部分功能</title>
</head>
<body>
	<%--c:if	c:choose	c:forEach --%>
	
	<%--if --%>
	<c:if test="true">
		条件成立
	</c:if>
	<l:if test="true">
		条件成立
	</l:if>
</body>
</html>