<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isErrorPage="true"
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- 
	2.4 pageContext		pageContext对象的类型是PageContext，叫jsp的上下文对象
		1)可以获取其他8个内置对象		通常在自定义标签时很有用
		2)本身也是一个域对象
			PageContext
				作用：保存数据和获取数据，在不同资源之间共享数据
			
			2.1可以作为域对象使用，不仅可以讲数据存入自己，并且可以往其他3个域存数据
			
	jsp中四大域对象
		（1）域对象的作用：
			保持数据		获取数据	，用于在不同资源间共享数据
		（2）域方法：
			setAttribute("数据名","数据值")		保存数据
			getAttribute("数据名")				获取数据
			removeAttribute("数据名")			清除数据
			
		（3）	域						作用范围
				ServletContext			同一个应用
				HttpSession				同一个会话
				HttpServletRequest		同一个请求
				PageContext				同一个jsp
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>内置对象pageContext</title>
</head>
<body>
	<%
		//1）获取其他8个内置对象
	//	response.getWriter().write("内置对象out和pageContext得到的是否是同一个对象："+(out==pageContext.getOut())+"<br>");
	%>
	
	<%-- 2）作为域对象使用 --%>
	<%
		//保存数据,默认保存在page域中
		pageContext.setAttribute("message", "test信息page");
		
		//保存到其他域中
		pageContext.setAttribute("message", "test信息ServletContext", PageContext.APPLICATION_SCOPE);	//保持到ServletContext域中
		pageContext.setAttribute("message", "test信息session", PageContext.SESSION_SCOPE);	//保持到session域中
		pageContext.setAttribute("message", "test信息request", PageContext.REQUEST_SCOPE);	//保持到request域中
		//request.setAttribute("message", "test信息1");		等价于上面的代码
	%>
	<%-- 获取数据  --%>
	<%=pageContext.getAttribute("message")%><br>
	<%-- <%=pageContext.getAttribute("message", pageContext.PAGE_SCOPE) %><br> --%>
	
	<%-- 从其他域获取数据  在哪个域中保存，就只能在哪个域中取--%>
	<%=pageContext.getAttribute("message", pageContext.APPLICATION_SCOPE) %><br>
	<%=pageContext.getAttribute("message", pageContext.SESSION_SCOPE) %><br>
	<%=request.getAttribute("message") %><br>
	<hr>
	
	<%-- 
		findAttribute()自动搜索各个域中存储的信息：
			顺序：page---》request---》session---》ServletContext	（从小到大）
	--%>
	<%=pageContext.findAttribute("message") %>
	
	<%-- 转发到jspTest5pageContext2.jsp --%>
	<%
		application.getRequestDispatcher("/page/day12/jspTest5pageContext2.jsp").forward(request, response);
	%>
</body>
</html>