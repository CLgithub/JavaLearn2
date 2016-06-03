<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人列表页</title>
</head>
<body>
	<a href='${pageContext.servletContext.contextPath}/ContactMain2?mark=toAddOrU'>新增</a>
	<table border='1' style='border-collapse: collapse;0'>
		<tr>
			<td colspan='6'></td>
		</tr>
		<tr>
			<th>姓名</th>
			<th>年龄</th>
			<th>电话</th>
			<th>邮箱</th>
			<th>qq</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="c" varStatus="vs">
			<tr>
				<td>${c.name}</td>
				<td>${c.age}</td>
				<td>${c.phone}</td>
				<td>${c.email}</td>
				<td>${c.qq}</td>
				<td>
					<a href="${pageContext.servletContext.contextPath}/ContactMain2?mark=toAddOrU&id=${c.id}">修改</a> 
					<a href="${pageContext.servletContext.contextPath}/ContactMain2?mark=delete&id=${c.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>