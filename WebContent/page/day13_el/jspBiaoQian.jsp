<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
jsp标签
	6.1 作用
		替换jsp脚本	<% %>
		（1）流程判断
		（2）转发页面
		（3）……
		
	6.2jsp标签分类
		（1）内置标签（动作标签）：不需要在jsp页面导入标签
		（2）jstl标签：需要在jsp页面中导入
		（3）自定义标签：开发者自行定义，需要在jsp页面中导入		

	6.3 动作标签
		转发标签：<jsp:forward />
		参数标签：<jsp:pararm />
		包含标签：<jsp:include />
			原理：包含与被包含的页面先各种翻译成java源文件，然后在运行合并在一起（先翻译，再合并）动态包含
		
		静态包含 vs 动态包含的区别
		（1）原理：
			静态包含：先合并，再翻译
			动态包含：先翻译，再合并
		（2）语法：
			静态包含：<%@include file="被包含的页面" %>
			动态包含：<jsp:include page="被包含的页面" />
		（3）传参数
			静态包含：不能向被包含页面传参
			动态包含：可以向被包含页面传参

	6.4 jstl标签
		jstl全名（java standard tag libarary）java标准标签库
		核心标签库：	（c标签库）		天天用
		国际化标签库：	（fmt标签库）
		el标签库：	（fn函数库）
		xml标签库：	（x标签库）
		sql标签库：	（sql标签库）
		
		jstl标签使用步骤
			（1）(如果没有jar包)导jstl的jar包
			（2）使用jsp三大指令的最后一个taglib指令，在jsp页面导入标签库
				 <%@taglib uri="tld文件的uri名称" prefix="简写" %>
			 (3)使用，常用有
				<c:set></c:set>					保存数据
				<c:out value=""></c:out>		获取数据
				<c:if test=""></c:if>			单个条件判断
				
				<c:choose></c:choose>			多条件判断
				<c:when test=""></c:when>		
				<c:otherwise></c:otherwise>
				
				<c:forEach></c:forEach>								循环
				<c:forTokens items="" delims=""></c:forTokens>		
				
				<c:redirect></c:redirect>			重定向

--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp标签</title>
</head>
<body>
	<%--转发标签：<jsp:forward />  参数标签：<jsp:pararm />	--%>
	<%-- <% request.getRequestDispatcher("/page/day13_el/jspBiaoQian2.jsp?name=aa&password=123").forward(request, response); %> --%>
	<%-- <jsp:forward page="/page/day13_el/jspBiaoQian2.jsp" >
		<jsp:param value="bb" name="name"/>
		<jsp:param value="123456" name="password"/>
	</jsp:forward> --%>
	
	<%-- 包含标签：<jsp:include />	--%>
	<jsp:include page="common/header.jsp">
		<jsp:param value="123" name="id1"/>
	</jsp:include>
	<%-- <%@include file="common/header.jsp?id1=123" %>   不可以，要报错--%>
	主页内容xx
	<hr>
	jstl标签使用：<br>
	<c:set></c:set>
	<c:out value=""></c:out>
	<c:if test=""></c:if>
	<c:choose></c:choose>
	<c:when test=""></c:when>
	<c:otherwise></c:otherwise>
	<%-- <c:forEach></c:forEach> --%>
	<c:forTokens items="" delims=""></c:forTokens>
	<c:redirect></c:redirect>
</body>
</html>