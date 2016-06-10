<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改或新增</title>
</head>
<body>
	<form action='${pageContext.servletContext.contextPath}/ContactMain4?mark=doAddOrU' method='post'>
		<table border='1' style='border-collapse: collapse;' >
			<tr>
				<td>姓名</td><td>
					<input type="hidden" name="id" value="${contact.id}">
					<input type="text" name="name" value='<c:out value="${contact.name}" />'>
				</td>
			</tr><tr>
				<td>年龄</td><td><input type="text" name="age" value="${contact.age}"></td>
			</tr><tr>
				<%-- <td>性别</td><td><input type="text" name="gender" value="${contact.gender}"></td> --%>
				<td>性别</td>
					<td>
						男<input type="radio" name="gender" value="男" <c:if test="${contact.gender eq '男'}"> checked="checked"</c:if> />
						女<input type="radio" name="gender" value="女" <c:if test="${contact.gender eq '女'}"> checked="checked"</c:if> />
						<%-- 男<input type="radio" name="gender" value="男" <c:if test="${contact.gender == '男'}"> checked="checked"</c:if> />
						女<input type="radio" name="gender" value="女" <c:if test="${contact.gender == '女'}"> checked="checked"</c:if> /> --%>
					</td>
				
			</tr><tr>
				<td>电话</td><td><input type="text" name="phone" value="${contact.phone}"></td>
			</tr><tr>
				<td>邮箱</td><td><input type="text" name="email" value="${contact.email}"></td>
			</tr><tr>
				<td>dateTest</td><td><input type="text" name="dateTest" value="${contact.dateTest}"></td>
			</tr><tr>
				<td colspan="2" align="center"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>