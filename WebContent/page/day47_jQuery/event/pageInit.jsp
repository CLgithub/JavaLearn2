<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动态绑定事件，动态解绑事件</title>
<script type="text/javascript" src="../../../js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#button1").click(function(){
			$("div").bind("mouseover",function(){
			//	$(this).css("background","blue");
				alert("a");
			})
		});
		
		$("#button2").click(function(){
			//接触所有事件
			$("div").unbind();
		})
	});
</script>
<style type="text/css">
	.css1{
		height: 200px;
		width: 200px;
		background: red;
	}
</style>
</head>
<body>
	<input type="button" value="绑定事件" id="button1" />
	<input type="button" value="解绑事件" id="button2" />
	<div class="css1"></div>
</body>
</html>