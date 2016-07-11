<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>事件</title>
<script type="text/javascript" src="../../../js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	$(function(){
		//鼠标悬停事件
		/* $("ul>li").mouseover(function(){
			$(this).css("background", "red");
		}); */
		
		//鼠标移出
		/* $("ul>li").mouseout(function(){
			$(this).css("background", "white");
		}); */
		
		$("ul>li").hover(function(){
			$(this).css("background", "red");
		},function(){
			$(this).css("background", "white")
		});
	});
</script>
<style type="text/css">
	ul li{
		list-style: none;
	}
	ul{
		width: 100px;
		height: 180px;
		border: 1px solid red;
	}
</style>
</head>
<body>
	<ul>
		<li>郑州</li>
		<li>许昌</li>
		<li>洛阳</li>
		<li>周口</li>
		<li>新乡</li>
		<li>南阳</li>
		<li>日本</li>
		<li>大阪</li>
	</ul>
</body>
</html>