<%@page import="day7_sax.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>联系人列表页</title>
</head>
<body>
	<%-- <%=request.getAttribute("contacts") %> --%>
	

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
		<%
			//从request中接受数据
			List<Contact> contacts=(List<Contact>)request.getAttribute("contacts");	
			for(Contact c:contacts){
				%><tr><%
					%><td><%=c.getName()%></td><%
					%><td><%=c.getAge()%></td><%
					%><td><%=c.getPhone()%></td><%
					%><td><%=c.getEmail()%></td><%
					%><td><%=c.getQq()%></td><%
					%><td><a href='<%=request.getContextPath()+"/updateC?id="+c.getId() %>'>修改</a>
					<a href='<%=request.getContextPath()+"/deleteC?id="+c.getId() %>'>删除</a></td><%
				%></tr><%
			}
		%>
	</table>
</body>
</html>