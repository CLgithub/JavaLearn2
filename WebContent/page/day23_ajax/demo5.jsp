<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ajax异步展示商品信息</title>
<script type="text/javascript" src="my.js"  ></script>
<script type="text/javascript">
	function fun1(){
		//1.得到XMLHttpRequest对象
		var xmlhttpRequest=getXMLHttpRequest();
		
		//2.设置回调函数,当XMLHttpRequest对象的readyState改变时调用
		xmlhttpRequest.onreadystatechange=function(){
			//5.处理相应数据
			if(xmlhttpRequest.readyState==4&&xmlhttpRequest.status==200){
				var json=eval(xmlhttpRequest.responseText);		//eval()函数将字符变成js代码，此处就是将[{},{}]字符串变成js代码，即变成了数组
		//		alert(json);
		//		alert(json[0].id+json[0].name);
				var msg="<table><tr><td>编号</td><td>商品名称</td><td>价格</td></tr>";
				for(var i=0;i<json.length;i++){
					msg+="<tr>";
					msg+="<td>"+json[i].id+"</td><td>"+json[i].pName+"</td><td>"+json[i].price+"</td>";
					msg+="</tr>"
				}
				msg+="</table>"
				document.getElementById("d").innerHTML = msg;
			}
		}
		//post请求方式参数设置
		xmlhttpRequest.open("post", "${pageContext.request.contextPath}/ajax5");
		xmlhttpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");//post需要多设置一个请求头
		xmlhttpRequest.send(null);
	}
</script>
</head>
<body>
	<a href="#" onclick="fun1()">商品信息</a>
	<div id="d"></div>
</body>
</html>