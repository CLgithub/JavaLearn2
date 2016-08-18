<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示天气☁️</title>
<!-- 通过访问远程webservice得到天气，显示在该页面 -->
<script type="text/javascript" src='${pageContext.servletContext.contextPath}/js/jquery-1.4.2.min.js'></script>
<script type="text/javascript">
	$(function(){
		$("#city").change(function(){
			var va=$('#city>option:selected').val();
			var url='${pageContext.servletContext.contextPath}/WSDemo2CServlet';
			var sendData={
					"cityName":va	
				};
			$.ajax({
				type: "post",	//以什么方式发送
				url : url,		//url
				data: sendData,	//发送的数据，json格式
				success:function(backData,textStatus,xmlHttpRequest){	//成功后调用的函数
					$('span').text(backData);
				}
			});
		});
	})
</script>
</head>
<body>
	<select id="city">
		<option value="guiyang">贵阳</option>
		<option value="beijing">北京</option>
		<option value="shenzhen">深圳</option>
		<option value="shanghai">上海</option>
	</select>
	当前温度：<span></span>
</body>
</html>