<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增或修改商品</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/itemsController/doEditOrAddItems.action">
	<table>
		<tbody>
			<tr>
				<td>商品名称</td>
				<td>
					<input type="text" name="name" value="${items.name}">
				</td>
			</tr><tr>
				<td>商品价格</td>
				<td>
					<input type="text" name="name" value="${items.price}">
				</td>
			</tr><tr>
				<td>商品描述</td>
				<td>
					<input type="text" name="name" value="${items.detail}">
				</td>
			</tr><tr>
				<td>pic</td>
				<td>
					<input type="text" name="name" value="${items.name}">
				</td>
			</tr><tr>
				<td>上架时间</td>
				<td>
					<input type="text" name="name" value="${items.createtime}">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>