<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../../../js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("input:button").click(function(){
		//	span标签.load(url);
			var url="${pageContext.request.contextPath}/day48Servlet1";
			var sendDate={
				"name":"aa汉字",
				"password":123,
			};
			$("#time").load(url,sendDate);
		})
	});
</script>
<title>使用jquery的ajax获取服务端时间</title>

</head>
<body>
	<!-- 
		传统ajax在/JavaLearn2/WebContent/page/day23_ajax/demo2.jsp
	 -->
	 当前时间：<span id="time"></span><br>
	 <input type="button" value="获取时间" >
</body>
</html>