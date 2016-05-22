<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="day13_el.Student"%>
<%@page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- 
el表达式
	5.1作用
		jsp的核心语法：jsp表达式<%= %>和jsp脚本<% %>
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
		（3）输出集合对象：
			List 和 Map
		（4）表达式计算
			4.1 算术表达式运算
			4.2 比较运算
			4.3 逻辑运算
			4.4 判空
				${empty name} 等价于${name==null || name==""}
				null 或空字符串
				
--%>
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
		//普通对象
		Student s1=new Student("小白",5);
		Student s2=new Student("小红",25);
		pageContext.setAttribute("s1", s1);
		
		//List
		List<Student> list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		pageContext.setAttribute("list", list);
		
		//Map
		Map<String,Student> map=new HashMap<String,Student>();
		map.put("st1", s1);
		map.put("st2", s2);
		pageContext.setAttribute("map", map);
	%>
	<%-- 输出对象的属性值 --%>
	el表达式输出对象属性值：<br>
	s1的姓名：${s1.name}<br>		<%-- 注意，这里的.不是调用属性，而是调用方法，所以name虽然是private的，但是同样能得到 --%>
	s1的年龄：${s1.age}<br>
	相当于：<%=((Student)pageContext.findAttribute("s1")).getName() %>
	<hr>
	<%-- 输出list集合 --%>
	e表达式输出list集合对象：<br>
	list集合对象：${list}<br>
	list集合对象第一个元素：${list[0]}<br>
	list集合对象第二个元素的名字：${list[1].name}<br>	
	相当于：<%=((List<Student>)pageContext.findAttribute("list")).get(1).getName() %><brz>
	<hr>
	<%-- 输出map集合 --%>
	e表达式输出map集合对象：<br>
	map集合对象：${map}<br>
	map集合对象的st1元素：${map['st1']}<br>
	map集合对象的st1元素的名字：${map['st1'].name}<br>
	相当于：<%=((Map<String,Student>)pageContext.findAttribute("map")).get("st1").getName() %><brz>
	<hr>
	<%-- 算术表达式运算 --%>
	表达式计算<br>
	算术表达式运算:3+5=${3+5}<br>
	<%-- 比较运算 --%>
	比较运算：10<5吗？${10<5}<br>
	比较运算：10==10吗？${10==10}<br>
	比较运算：4!=10吗？${4!=10}<br>
	<%-- 逻辑运算 --%>
	逻辑运算：true&&false吗？${true&&false}<br>
	<br>
	判空<br>
	<%
		String n1=null;
		String n2="";
		pageContext.setAttribute("n1", n1);
		pageContext.setAttribute("n2", n2);
	%>
	n1为null或空字符串吗？${empty n1}<br>	<%-- 相当于${n1==null || n1==""} --%>
	n2为null或空字符串吗？${empty n2}<br>
		
</body>
</html>