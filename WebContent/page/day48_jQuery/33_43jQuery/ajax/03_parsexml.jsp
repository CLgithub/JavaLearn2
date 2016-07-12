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
			var url="${pageContext.request.contextPath}/page/day48_jQuery/33_43jQuery/ajax/03_city.xml";
			/* var url="03_city.xml"; */
			var sendData=null;
			$.get(url,sendData,function(xml){
				//alert(xml);
				//用jquery中的api解析xml文件。这里的xml是js对象
				var $xml=$(xml);
				var $citys=$xml.find("city");
				$citys.each(function(){
					alert($(this).text());
				});
			})
		});
	});
</script>
<title>jquery解析xml</title>

</head>
<body>
	<input type="button" value="解析服务器响应的xml文件">
</body>
</html>