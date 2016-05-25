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
<%-- 
	5.jsp语法
		5.1 jsp模版
			jsp页面中的html代码就是jsp的模版
		5.2 jsp表达式
			语法：<%= %>
			作用：向浏览器输出变量的值或表达式的运算结果
			注意：
				（1）表达式的原理就是翻译成out.print("内容");通过该方法向浏览器输出内容
				（2）表达式后不需要加;
		5.3 jsp脚本
			语法：<% %>
			作用：执行java代码
			注意：
				（1）原理就是把其中的java代码拷贝到service中去执行
		5.4 jsp声明
			语法：<%! %>
			作用：声明成员变量或成员方法
			注意：
				（1）如果是变量的话，会翻译成成员变量
				（2）如果是方法，会翻译成成员方法
		5.5 jsp注释
			语法：
			注意：html注释会被翻译和执行，jsp注释不会被翻译和执行

--%>
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
		静态包含：（jsp的include指令）
			1.原理：先包含，后翻译
			2.语法：<%@include file="common/header.jsp" %>
			3.传参数：不能向被包含页面传参
		动态包含：（jsp的include标签）
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
		Object（page）						相当于jsp的this，翻译过来的java源文件这个类
		
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
<%-- 
	el表达式：
		作用：替换	jsp表达式，向浏览器输出 域对象中的 变量的值或表达式计算的结果
		语法：${变量或表达式}
			(1)输出基本数据类型变量
				1.1 从四个域获取
					${变量或表达式}
				1.2 定制域获取
					${requestScope.name}
					域范围：pageScope,requestScope,sessionScope,applicationScope
			(2)输出对象的属性值
			(3)输出集合对象：
				List和Map
			(4)表达式计算
				4.1 算术表达式
				4.2 比较运算
				4.3 逻辑运算
				4.4 判空运算
					${empty name}等价于${name==null || name==""}
					null 或空字符串
			
--%>

<%-- 总结jsp标签，动作标签，jstl标签，自定义标签 替换jsp脚本
	jsp标签
		作用：替换jsp脚本<% %>执行java代码，流程判断，转发页面等
		jsp标签分类：
			（1）内置标签（动作标签）：不需要在jsp页面导入就可以使用
			（2）jstl标签：java标准标签库（java standard tag libarary），需要在jsp页面中导入
			（3）自定义标签：开发者自行定义的标签，需要在jsp页面中导入
		（1）动作标签（内置标签）：
			常见：
				转发标签:<jsp:forward />
				参数标签:<jsp:pararm />
				包含标签:<jsp:include />
					原理：先翻译，后包含，动态包含
		（2）jstl标签
			jstl：java标准标签库（java standard tag libarary）
			核心标签库：（c标签库）
			国际化标签库：（fmt标签库）
			el标签库：（fn标签库）
			xml标签库：（x标签库）
			sql标签库：（sql标签库）
			
			使用步骤：
				（1）如果没有jar包，导jstl的jar包
				（2）使用jsp三大指令中的taglib指令，在jsp页面中导入标签库
					<%@taglib uri="tld文件的uri名称" prefix="" %>	uri统一资源标识符
				（3）使用：常用有
					<c:set></c:set>					保存数据
					<c:out value=""></c:out>		获取数据
					<c:if test=""></c:if>			单个条件判断
					
					<c:choose>			多条件判断
						<c:when test=""></c:when>		
						<c:otherwise></c:otherwise>
					</c:choose>
					
					<c:forEach></c:forEach>								循环
					<c:forTokens items="" delims=""></c:forTokens>		循环特殊
					
					<c:redirect></c:redirect>			重定向
				
		（3）自定义标签：开发者自己定义开发的标签
			开发过程：
				（1）编写标签处理器类，一个普通的java类，继承SimpleTagSupport类
				（2）重写SimpleTagSupport的方法：doTag()方法处理具体标签要做什么
					void setJspContext(JspContext pc)		设置pageContext对象，传入pageContext，之后就可以通过getJspContext()方法得到（一定调用）
					void setParent(JspTag parent)			设置父标签对象，如果没有父标签，则不调用该方法，如果有则调用传入JspTag父标签对象,之后可以通过getParent()得到
					void setJspBody(JspFragment jspBody)	设置标签体内容，标签体内容封装到jspFragment对象中，然后传入JspFragment对象，通过getJspBody()方法得到,如果没有标签体内容，则不调用次方法
					void doTag() throws JspException, IOException	执行标签时调用的方法	（一定调用）
				（3）注册（声明）标签到标签库：在WEB-INF目录下建立一个l.tld文件，可以参考c标签库标签声明文件
				（4）在jsp页面导入标签库<%@taglib uri="http://tag.cl.com"  prefix="l" %>
				（5）使用：<l:showIp />
			
			自定义标签执行过程
				tomcat启动的时候，会加载每个web应用，加载每个web应用下WEB-INF的所有文件：web.xml tld文件等
				访问Domo1.jsp资源，
				tomcat把jsp翻译成java源文件，编译成class文件，构造类对象，调用jspService方法
				检查jsp文件中的taglib指令，是否存在一个名为http://tag.cl.com的tld文件，
				上一步已经读到了l.tld文件，当读到<l:showIp />时，会到l.tld文件中查找name为<tag>的标签
				找到tag标签后，读取<tag-class>day14.Dome1ShowIpTag</tag-class>的内容
				得到day14.Dome1ShowIpTag，
				构造Dome1ShowIpTag对象，调用Dome1ShowIpTag的方法
			
			自定义标签处理器类的生命周期：
				SimpleTag接口：
					void setJspContext(JspContext pc)		设置pageContext对象，传入pageContext，之后就可以通过getJspContext()方法得到（一定调用）
					void setParent(JspTag parent)			设置父标签对象，如果没有父标签，则不调用该方法，如果有则调用传入JspTag父标签对象,之后可以通过getParent()得到
					void setJspBody(JspFragment jspBody)	设置标签体内容，标签体内容封装到jspFragment对象中，然后传入JspFragment对象，通过getJspBody()方法得到,如果没有标签体内容，则不调用次方法
					void doTag() throws JspException, IOException	执行标签时调用的方法	（一定调用）
			
			自定义标签能做什么：
				（1）控制标签体内容是否输出
					通过getJspBody()方法可以获得标签体对象JspFragment，调用JspFragment对象的invoke()方法可以将标签体内容输出到一个Writer中
					invoke(null)输出到this.getJspContext().getOut()中，即输出到浏览器，不调用，不输出
				（2）控制标签余下内容是否输出
					默认会输出，抛出throw new SkipPageException();异常不输出
				（3）控制重复输出标签体内容
					多次调用invoke方法，多次输出
				（4）改变标签体内容
					将标签体内容输出到一个临时容器，改变这个内容后输出到浏览器
					StringWriter是个合适的容器
				（5）带属性的标签
					需要在标签声明文件中声明，在标签处理器类中设置成员变量，并提供其set方法
				
--%>
 <%
 	
 %>
</body>
</html>