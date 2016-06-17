<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajax开发步骤--关于参数携带</title>
	<script type="text/javascript">
	function fun1(){
		//1.得到XMLHttpRequest对象
		var xmlhttpRequest=null;
		if (window.XMLHttpRequest){// 新的浏览器，包括ie7及以上
			xmlhttpRequest=new XMLHttpRequest();
		} else if (window.ActiveXObject){// code for IE5 and IE6
			xmlhttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
		}
		//2.设置回调函数,当XMLHttpRequest对象的readyState改变时调用
		/*
			readyState共5个状态：
					0：XMLHttpRequest对象创建状态
					1.open操作
					2.send操作
					3.接受到相应数据，当时只有相应头，正文还没有接收
					4.所有http相应接收完成
		*/
		xmlhttpRequest.onreadystatechange=function(){
			//5.处理相应数据
			//alert(xmlhttpRequest.readyState);
			//表示所有http相应接收完成并且正常访问成功
			if(xmlhttpRequest.readyState==4&&xmlhttpRequest.status==200){
				//接收请求数据
				alert(xmlhttpRequest.responseText);
			}
		}
		//get请求方式参数设置
		//3.open
		//xmlhttpRequest.open("get", "${pageContext.request.contextPath}/ajax2?name=aaa");
		//4.发送请求
		//xmlhttpRequest.send(null);
		//post请求方式参数设置
		xmlhttpRequest.open("post", "${pageContext.request.contextPath}/ajax2");
		xmlhttpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");//post需要多设置一个请求头
		xmlhttpRequest.send("name=abc");
	}
	</script>
</head>
<body>
	<a href="#" onclick="fun1()">ajax1</a>
</body>
</html>