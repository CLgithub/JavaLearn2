<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>struts2文件上传</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/day31/Demo3UpLoadFile_" method="post"
		enctype="multipart/form-data"
		>
		<input type="file" name="upLoadFile">
		<input type="submit" value="上传">
	</form>
</body>
</html>