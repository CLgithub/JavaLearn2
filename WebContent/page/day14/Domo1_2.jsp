<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://tag.cl2.com"  prefix="l2" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
自定义标签：
	第一个自定义标签开发步骤：
		1.编写标签处理器类：一个java类，集成SimpleTagSupport类
		2.编写标签库声明文件：在web-inf目录下建立一个l.tld文件，可以参考jstl核心标签库声明文件写法
		3.导入：在jsp页面导入自定义标签库<%@taglib uri="http://tag.cl.com"  prefix="l" %>
		4.使用：<l:showIp />
		
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自定义标签</title>
</head>
<body>
		你当前的ip：<l2:showIp2 >xxxx</l2:showIp2> <br>
	<HR>
		自定义标签2：<br>
			<l2:Demo2Tag2 num='3'> 标签体内容aaAABBDECD<br> </l2:Demo2Tag2> 标签余下的内容
	<hr>
		自定义标签实现登录框：
			<l2:loginForm action="" method="post" loginName="loginName" password="password" />
</body>
</html>