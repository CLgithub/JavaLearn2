<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>3大指令4大域对象9大内置对象总结</title>
</head>
<body>
<%-- 待总结jsp语法：模版，表达式，脚本，声明，注释 --%>
<%-- 
 	jsp三大指令
 		6.1 include指令：
 			作用：在当前页面包含其他的页面
 			语法：<%@include file="common/header.jsp" %>
 			注意：
 				（1）这是静态包含，先合并，再翻译
 				（2）如果使用静态包含，被包含页面中就不需要出现全局的html标签了
		6.2 page指令
			作用：告诉tomcat服务器如何翻译jsp文件
				<%@ page 
				language="java"							告诉tomcat使用什么语言翻译jsp文件
				import="java.util.*,java.net.*"			导入需要的包，多个包中间用“,”隔开
				
				pageEncoding="UTF-8"						使用什么编码翻译jsp文件为java文件
				contentType="text/html; charset=UTF-8"		服务器以什么文件格式（text/html）什么编码（utf-8）发送到浏览器
				 
				errorPage="common/error.jsp"				错误页面配置（也可以在web.xml进行全局错误出来页面配置）
				isErrorPage="false"						当前页面是否可以使用Throwable(exception)内置对象
				 
				buffer="8kb"								设置jspWriter（out）向浏览器输出数据时的缓存区大小
				session="true"								该页面是否启用session
				isELIgnored="false"						该页面是否忽略el表达式
				%>
		6.3 taglib指令：向页面导入标签库
		
		静态包含  vs 动态包含
		静态包含：
			1.原理：先包含，后翻译
			2.语法：<%@include file="common/header.jsp" %>
			3.传参数：不能向被包含页面传参
		动态包含：
			1.原理：先翻译，后包含
			2.语法：<jsp:include page="被包含的页面" />
			3.可以向被包含的页面传参
--%>
<%-- 
	4大域对象：
		ServletContext			同一个应用
		HttpSession				同一个会话
		HttpServletRequest		同一个请求
		PageContext				同一个jsp页面
	作用：保存数据，取出数据，在不同资源之间共享数据
	方法：
		setAttribute("数据名","数据值")		保存数据
		getAttribute("数据名")				获取数据
		removeAttribute("数据名")			清除数据



	9大内置对象：
		ServletContext（application）		Servlet上下文环境
		ServletConfig（config）				Serlvet配置
		HttpSession(session)				会话对象
		HttpServletRequest（request）		请求对象
		HttpServletResponse（response）		相应对象
		
		PageConfig（pageContext）			jsp上下文对象
		Object（page）						相当于jsp的this
		
		jspWriter（out）						向浏览器输出信息用
		Throwable(exception)				异常对象（需要在page指令中设置后才能用）
		
	特殊的：PageContext，jsp上下文对象，
		（1）可以得到其他八个对象
		（2）作为域对象使用，不仅可以将数据存入自己，还可以将数据存入其他3个域对象
				//保存数据,默认保存在page域中
				pageContext.setAttribute("message", "test信息page");
				//保存到其他域中
				pageContext.setAttribute("message", "test信息ServletContext", PageContext.APPLICATION_SCOPE);	//保持到ServletContext域中
				pageContext.setAttribute("message", "test信息session", PageContext.SESSION_SCOPE);	//保持到session域中
				pageContext.setAttribute("message", "test信息request", PageContext.REQUEST_SCOPE);	//保持到request域中
		取出数据时：pageContext.findAttribute("message")，自动查找，顺序从小到大page---》request---》session---》ServletContext
 --%>
<%-- 待总结jsp标签，动作标签，jstl标签，自定义标签 --%>
<%-- el表达式 --%>
 <%
 	
 %>
</body>
</html>