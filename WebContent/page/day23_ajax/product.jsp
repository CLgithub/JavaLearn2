<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ajax异步展示商品信息</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<td>编号</td>
				<td>商品名称</td>
				<td>价格</td>
			</tr>
			<c:forEach items="${productList}"  var="p" >
				<tr>
					<td>${p.id}</td>
					<td>${p.pName}</td>
					<td>${p.price}</td>
				</tr>	
			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>