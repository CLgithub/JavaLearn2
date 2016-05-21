<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jsp语法</title>
</head>
<body>
	<!-- jsp脚本，java代码写在其中 -->
	<% 
		String name="小明"; 
		int a=2;
		int b=3;
	%>
	<!-- jsp表达式 -->
	<%=name %><br><!-- 向浏览器输出变量name的值 -->
	<%=a+b %><br><!-- 向浏览器输出表达式计算的值 -->
	<hr>
	<!-- 脚本穿插html代码 -->
	<%
		for(int i=0;i<6;i++){
			%><h<%=i+1%>>标题<%=i+1%></h<%=i+1%>><%
		}
	%>
	<hr>
	<!-- 练习：显示99乘法表 -->
	<%="练习：显示99乘法表" %><br>
	<%
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				if(i>=j){
					%><%=j%>*<%=i%>=<%=i*j %>&nbsp;<%
				}
			}
			%><br><%
		}
	%>
</body>
</html>