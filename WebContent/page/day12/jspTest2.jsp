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
		String name="小明"; 		//局部变量，声明在service方法里
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
	<hr>
	<!-- jsp声明 -->
	<%!
		//声明一个成员变量
		String name2="aaa";		
		
		//声明一个成员方法
		public String getName(){
			return name2;
		}
		
		//方法重载
		public void _jspService(){
			
		}
		
		//jsp的声明中不能重复定义翻译好的一些方法
		/* public void _jspInit() {
		} */
	%>
	<!-- html的注释，会翻译，被当做html内容输出，然后再根据html语法隐藏 -->
	<%-- <jsp:forward page="jspTest1.jsp"></jsp:forward> --%>
	<%-- jsp的注释 ，不会被翻译--%>
</body>
</html>