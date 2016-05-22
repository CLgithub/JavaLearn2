<%@page import="day13_el.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 
el表达式
	5.1作用
		jsp的核心语法：jsp表达式和jsp脚本
		以后开发jsp的原则，尽量在jsp页面中少写甚至不写java代码
		
	替换	jsp表达式，向浏览器输出 域对象中的 变量的值或表达式计算的结果
	${变量或表达式}
	5.2	语法：
		（1）输出基本数据类型变量
			1.1从四个域获取
				${变量或表达式}
			1.2制定域获取
				${requestScope.name}
			域范围：pageScope，requestScope，sessionScope，applicationScope
		（2）输出对象的属性值

 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>el表达式</title>
</head>
<body>
	<%
		String name="小明";
	//	pageContext.setAttribute("name", name);
		pageContext.setAttribute("name", name, PageContext.REQUEST_SCOPE);
		
	%>
	JSP表达式：<%=name %><br>
	EL表达式1自动搜索：${name}<br>	<%-- 相当于pageContext.findAttribute("")自动搜索 --%>
	EL表达式3从指定域中获取：${requestScope.name}<br>	<%-- 相当于<%=pageContext.getAttribute("name", pageContext.REQUEST_SCOPE) %>从指定域中获取 --%>
	<hr>
	
	
	<%
		Student s1=new Student("小白",5);
		Student s2=new Student("小红",25);
		pageContext.setAttribute("s1", s1);
	%>
	el表达式输出对象属性值：<br>
		s1的姓名：${s1.name}<br>		<%-- 注意，这里的.不是调用属性，而是调用方法，所以name虽然是private的，但是同样能得到 --%>
		s1的年龄：${s1.age}<br>
		相当于：<%=((Student)pageContext.findAttribute("s1")).getName() %>
</body>
</html>