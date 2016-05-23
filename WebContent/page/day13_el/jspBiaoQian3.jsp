<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="day13_el.Student"%>
<%@page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
jstl常用标签使用：
	<c:set></c:set>					保存数据
	<c:out value=""></c:out>		获取数据
	<c:if test=""></c:if>			单个条件判断
	
	<c:choose></c:choose>			多条件判断
	<c:when test=""></c:when>		
	<c:otherwise></c:otherwise>
	
	<c:forEach></c:forEach>								循环
	<c:forTokens items="" delims=""></c:forTokens>		
	
	<c:redirect></c:redirect>			重定向
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- <c:set></c:set> 保存数据（保存到域中，默认保存到pageConfig域）--%>
	<c:set var="name" value="小明" scope="request"></c:set>
	${name}<br>	
	<%-- 相当于：<%=pageContext.getAttribute("name") %> --%>
	相当于：<%=request.getAttribute("name") %><br>
	<hr>
	
	<%--<c:out value=""></c:out>获取数据(从域中获取)--%>
	<%
		String msg=null;
		pageContext.setAttribute("msg", msg);
	%>
	<%--default：当value的值为null时，使用默认值 --%>
	<%--escapeXml="false" 是否对默认值转义，false不转义，按html输出，true转义， --%>
	<c:out value="${msg}" default="<h3>默认值</h3>" escapeXml="true"></c:out>
	<hr>
	
	<%--if标签：单条件判断 --%>
	<%-- <c:if test="true"> --%>
	<%-- <c:if test="${10>5}"> --%>
	<c:if test="${empty msg}">
		条件成立
	</c:if>
	<hr>
	
	<%--<choose标签＋when标签＋otherwirse标签 多条件判断--%>
	<c:set var="score" value="86"></c:set>
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
	<hr>
	
	<%--forEach标签：循环 --%>
	<%
		//普通对象
		Student s1=new Student("小白",5);
		Student s2=new Student("小红",25);
		Student s3=new Student("小黄",25);
		pageContext.setAttribute("s1", s1);
		
		//List
		List<Student> list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		pageContext.setAttribute("list", list);
		
		//Map
		Map<String,Student> map=new HashMap<String,Student>();
		map.put("001", s1);
		map.put("002", s2);
		map.put("003", s3);
		pageContext.setAttribute("map", map);
	%>
	<%-- 
	items：需要遍历的集合，从0开始	
	begin：从哪个开始遍历			默认从0开始
	end：在哪个结束				默认到最后
	step：步长，（每次加多少）		默认1
	var：每隔元素的名称
	varStatus：当前这种遍历元素的状态属性：（count属性：当前位置，从1开始） --%>
	list:<br>
	<c:forEach items="${list}" begin="0" end="2" step="1" var="student" varStatus="vs">
		序号:${vs.count},&nbsp;姓名:${student.name},&nbsp;年龄:${student.age}<br>
	</c:forEach>
	<br>
	map<br>
	<c:forEach items="${map}" var="entry" >
		${entry}}------${entry.key}-姓名：${entry.value.name}<br>
	</c:forEach>
	<hr>
	
	<%--forToken标签：循环特殊字符串 --%>
	<%
		String str="java-php-net-平面";
		pageContext.setAttribute("str", str);
	%>
	<c:forTokens items="${str}" var="s" delims="-">
		${s}<br>
	</c:forTokens>
	
	<%--redrict:重定向 --%>
	<%-- <c:redirect url="https://www.google.com.hk"></c:redirect> --%>
</body>
</html>