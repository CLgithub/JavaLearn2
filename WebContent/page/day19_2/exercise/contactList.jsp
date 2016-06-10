<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人列表页</title>
<script type="text/javascript">
	function checkAll() {
		var contactItems=document.getElementsByName("contactItem");
		for(var i=0;i<contactItems.length;i++){
			contactItems[i].checked=true;
		}
	}
	function reAll() {
		var contactItems=document.getElementsByName("contactItem");
		for(var i=0;i<contactItems.length;i++){
			contactItems[i].checked=contactItems[i].checked==false?true:false;
		}
	}
	function batchD() {
		var contactItems=document.getElementsByName("contactItem");
		var ids="";
		for(var i=0;i<contactItems.length;i++){
			if(contactItems[i].checked){
				id=contactItems[i].value;
				ids+=id+",";
			}
		}
		var url="${pageContext.servletContext.contextPath}/ContactMain4?mark=batchD&ids="+ids;
		location.href=url;
	}
</script>
</head>
<body>
	
	<table border='1' style='border-collapse: collapse' align="center">
		<tr>
			<td colspan='1'>
				<a href='${pageContext.servletContext.contextPath}/ContactMain4?mark=toAddOrU'>新增</a>
			</td>
			<td colspan='7' align="left">
				<form action="${pageContext.servletContext.contextPath}/ContactMain4" method="post">
					<select name="s">
						<option value="">请选择条件</option>
						<option value="name">按姓名查询</option>
						<option value="phone">按手机号查询</option>
						<option value="email">按邮箱查询</option>
					</select> <input type="text" name="msg"> <input type="submit" value="查询">
				</form>
			</td>
		</tr>
		<tr>
			<th><a href="#" onclick="checkAll()">全选</a>/<a href="#" onclick="reAll()">反选</a></th>
			<th width="80">姓名</th>
			<th width="80">年龄</th>
			<th width="80">性别</th>
			<th width="120">电话</th>
			<th width="180">邮箱</th>
			<th width="120">dateTest</th>
			<th width="80">操作</th>
		</tr>
		<c:forEach items="${list}" var="c" varStatus="vs">
			<tr>
				<td><input type="checkbox" name="contactItem" value="${c.id}" ></td>
				<td>${c.name}</td>
				<td>${c.age}</td>
				<td>${c.gender}</td>
				<td>${c.phone}</td>
				<td>${c.email}</td>
				<td>${c.dateTest}</td>
				<td>
					<a href="${pageContext.servletContext.contextPath}/ContactMain4?mark=toAddOrU&id=${c.id}">修改</a> 
					<a href="${pageContext.servletContext.contextPath}/ContactMain4?mark=delete&id=${c.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan='8'><a href="#" onclick="batchD()">批量删除选中</a></td>
		</tr>
	</table>
</body>
</html>