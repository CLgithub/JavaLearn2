<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量修改商品信息列表</title>
</head>
<body> 
<form name="itemsForm" action="${pageContext.request.contextPath }/itemsController/queryItem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td>
	<select>
		<c:forEach items="${itemsType}" var="item" >
			<option value="${item.key}">${item.value}</option>
		</c:forEach>
	</select>
<!-- <input type="submit" value="查询"/> -->
<input type="button" value="提交批量修改" onclick="updateItems()"/>
</td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
</tr>
<c:forEach items="${itemsList }" var="item" varStatus="s">
	<tr>
		<td><input type="text" value="${item.name}" name="itemsCustoms[${s.index}].name"></td>
		<td><input type="text" value="${item.price }" name="itemsCustoms[${s.index}].price"></td>
		<td>
			<input type="text" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/>" 
				name="itemsCustoms[${s.index}].createtime">
			</td>
		<td><input type="text" value="${item.detail}" name="itemsCustoms[${s.index}].detail"></td>
	</tr>
</c:forEach>
</table>
</form>
</body>
<script type="text/javascript">
	function updateItems(){
		//设置itemsForm的action为删除商品的地址
		document.itemsForm.action="${pageContext.request.contextPath }/itemsController/doEditList.action";
		//提交form
		document.itemsForm.submit();
	}
</script>
</html>