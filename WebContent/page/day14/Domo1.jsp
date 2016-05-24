<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://tag.cl.com"  prefix="l" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
自定义表情：
	引入：
		需求：向浏览器输出当前客户端的ip地址（要求只能使用jsp标签）
	
	第一个自定义标签开发步骤：
		1.编写标签处理器类：一个java类，集成SimpleTagSupport类
		2.编写标签库声明文件：在web-inf目录下建立一个l.tld文件，可以参考jstl核心标签库声明文件写法
		3.导入：在jsp页面导入自定义标签库<%@taglib uri="http://tag.cl.com"  prefix="l" %>
		4.使用：<l:showIp />
		
	自定义标签执行过程：
		http://168.10.10.223:8090/JavaLearn2/page/day14/Domo1.jsp
		tomcat启动时，加载每个web应用，加载每个web应用WEB-INF下的所有文件,
		例如web.xml,还有tld文件
		（1）访问Domo1.jsp资源，
		（2）tomcat把jsp翻译成java源文件，编译为class文件，构造类对象，调用jspService方法
		（3）检查jsp文件的taglib指令，是否存在一个名为http://tag.cl.com的tld文件，
		（4）上一步已经读到了l.tld文件，当读到<l:showIp />时，会到l.tld文件中查找name为<tag>的标签
		（5）找到tag标签后，读取<tag-class>day14.Dome1ShowIpTag</tag-class>的内容
		（6）得到day14.Dome1ShowIpTag，
		构造Dome1ShowIpTag对象，调用Dome1ShowIpTag的方法
	
	自定义标签处理器类的生命周期：
		SimpleTag接口：
			void setJspContext(JspContext pc)		设置pageContext对象，传入pageContext，之后就可以通过getJspContext()方法得到（一定调用）
			void setParent(JspTag parent)			设置父标签对象，如果没有父标签，则不调用该方法，如果有则调用传入JspTag父标签对象,之后可以通过getParent()得到
			void setJspBody(JspFragment jspBody)	设置标签体内容，标签体内容封装到jspFragment对象中，然后传入JspFragment对象，通过getJspBody()方法得到,如果没有标签体内容，则不调用次方法
			void doTag() throws JspException, IOException	执行标签时调用的方法	（一定调用）
		
	自定义标签的作用：
		（1）控制标签体内容是否输出
		（2）控制标签余下内容是否输出
		（3）控制重复输出标签体内容
		（4）改变标签体内容
		（5）带属性的标签
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自定义标签</title>
</head>
<body>
	<%-- 你当前的ip：<%=request.getRemoteHost()%><br> --%>

	<%--使用标签库里的表情 --%>
	你当前的ip：<l:showIp >xxxx</l:showIp> <br>
</body>
</html>