<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="day13_el.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tag.cl2.com"  prefix="l2" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义标签实现c标签部分功能</title>
</head>
<body>
	<%--c:if	c:choose	c:forEach --%>
	
	<%--if --%>
	<c:if test="${10>5}">
		c:条件成立<br>
	</c:if>
	<l2:if test="${10>5}">
		l:条件成立<br>
	</l2:if>
	<hr>
	
	<%--c:choose --%>
	<%-- <c:set var="score" value="86"></c:set> --%>
	<l2:set var="score" value="75" />
	<c:choose>
		<c:when test="${score>=90 &&score<=100}">
			优秀
		</c:when>
		<c:when test="${score>=80 &&score<90}">
			良好
		</c:when>
		<c:when test="${score>=70 &&score<80}">
			一般
		</c:when>
		<c:when test="${score>=60 &&score<70}">
			及格
		</c:when>
		<c:otherwise>
			不及格
		</c:otherwise>
	</c:choose>
	<br>
	
	<l2:choose>
		<l2:when test="${score>=90 &&score<=100}">
			优秀
		</l2:when>
		<l2:when test="${score>=80 &&score<90}">
			良好
		</l2:when>
		<l2:when test="${score>=70 &&score<80}">
			一般
		</l2:when>
		<l2:when test="${score>=60 &&score<70}">
			及格
		</l2:when>
		<l2:otherwise>
			不及格
		</l2:otherwise>
	</l2:choose>
</body>
</html>