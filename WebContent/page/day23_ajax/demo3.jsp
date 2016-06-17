<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>验证用户名是否可以使用</title>
<script type="text/javascript" src="my.js"  ></script>
<script type="text/javascript">
	function fun1(){
		var name=document.getElementById("name").value;
		//alert(name);
		funx("${pageContext.request.contextPath}/ajax3",name)
	}
	function funx(str1,str2){
		//1.得到XMLHttpRequest对象
		var xmlhttpRequest=getXMLHttpRequest();
		
		//2.设置回调函数,当XMLHttpRequest对象的readyState改变时调用
		xmlhttpRequest.onreadystatechange=function(){
			//5.处理相应数据
			if(xmlhttpRequest.readyState==4&&xmlhttpRequest.status==200){
				var msg=xmlhttpRequest.responseText;
				//alert(msg);
				var spanN=document.getElementById("s");
				spanN.innerHTML=msg;
			}
		}
		//post请求方式参数设置
		xmlhttpRequest.open("post", str1);
		xmlhttpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");//post需要多设置一个请求头
		xmlhttpRequest.send("name="+str2);
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table cellpadding='5' cellspacing='1' border='0' align='center'>
		<tr>
			<td><b>用户名：</b></td>
			<td><input type='text' name='name' id='name' value="" style='width: 160px'
				onblur="fun1()" /><span id="s" ></span></td>
		</tr>
		<tr>
			<td><b>密码：</b></td>
			<td><input type='password' name='password' id='password' style='width: 160px' /></td>
		</tr>
		<tr>
			<td colspan='2' align='right'><input type='submit' value=‘注册新用户' /></td>
		</tr>
		</table>
	</form>
</body>
</html>