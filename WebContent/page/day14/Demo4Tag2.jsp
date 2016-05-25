<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="day13_el.Student"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tag.cl.com"  prefix="l" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%--c:forEach --%>
	<%
		Student s1=new Student("小明",23);
		Student s2=new Student("小红",13);
		Student s3=new Student("小白",22);
		Student s4=new Student("小黑",17);
		
		List<Student> list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		pageContext.setAttribute("list", list);
		
		Set<Student> set=new HashSet<>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		pageContext.setAttribute("set", set);
		
		Map<String,Student> map=new HashMap<String,Student>();
		map.put("001", s1);
		map.put("002", s2);
		map.put("003", s3);
		map.put("004", s4);
		pageContext.setAttribute("map", map);
	%>
	<h4>c：Collection</h4><br>
	<c:forEach items="${set}" var="s" varStatus="vS" >
		序号：${vS.count},姓名：${s.name},年龄：${s.age}<br>
	</c:forEach>
	<hr>
	<h4>l：Collection</h4><br>
	<l:forEach items="${set}" var="s" >
		姓名：${s.name},年龄：${s.age}<br>
	</l:forEach>
	<hr>
	<h4>c：map</h4><br>
	<c:forEach items="${map}" var="entry" varStatus="vS"  >
		序号：${vS.count},键：${entry.key},值：${entry.value},姓名：${entry.value.name}<br>
	</c:forEach>
	<hr>
	<h4>l：map</h4><br>
	<l:forEach items="${map}" var="entry" >
		键：${entry.key},值：${entry.value},姓名：${entry.value.name}<br>
	</l:forEach>
</body>
</html>