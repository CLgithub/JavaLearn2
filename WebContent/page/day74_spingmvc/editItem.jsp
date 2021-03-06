<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增或修改商品</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/itemsController/doEditOrAddItems.action" 
		method="post" enctype="multipart/form-data" >
	<input type="text" name="id" value="${itemsCustom.id}">
	<table>
		<tbody>
			<tr>
				<td>商品名称</td>
				<td>
					<input type="text" name="name" value="${itemsCustom.name}">
				</td>
			</tr><tr>
				<td>商品价格</td>
				<td>
					<input type="text" name="price" value="${itemsCustom.price}">
				</td>
			</tr><tr>
				<td>商品描述</td>
				<td>
					<%-- <input type="text" name="name" value="${items.detail}"> --%>
					<textarea rows="3" cols="30" name="detail">${itemsCustom.detail}</textarea>
				</td>
			</tr><tr>
				<td>商品图片</td>
				<td>
					<c:if test="${itemsCustom.pic!=null}">
						<img width=100 height=100 src="${itemsCustom.pic}">
						<br />
					</c:if>
					<input type="file" name="pictureFile" />
				</td>
			</tr><tr>
				<td>上架时间</td>
				<td>
					<input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/>">
				</td>
			</tr><tr>
				<td></td>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>