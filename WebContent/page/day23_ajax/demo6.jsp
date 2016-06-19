<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市联动框（ajax+json)</title>
<script type="text/javascript" src="my.js"></script>
<script type="text/javascript">
	function showCity(sf){
		//根据省份，ajax去获得json格式的城市
		var sfid=sf.value;
		funx1("${pageContext.request.contextPath}/ajax6", "sfid="+sfid);
		
	}
	
	function funx1(url,data){
		//1.得到XMLHttpRequest对象
		var xmlhttpRequest=getXMLHttpRequest();
		
		//2.设置回调函数,当XMLHttpRequest对象的readyState改变时调用
		xmlhttpRequest.onreadystatechange=function(){
			//5.处理相应数据
			if(xmlhttpRequest.readyState==4&&xmlhttpRequest.status==200){
				var citys=eval("("+xmlhttpRequest.responseText+")");
				var citys=eval(xmlhttpRequest.responseText);
				//将城市填充如city
				var cityNode=document.getElementById("city");
				cityNode.options.length=0;
				for(var i=0;i<citys.length;i++){
					var y=document.createElement('option');
					y.text=citys[i].name;
					cityNode.appendChild(y);
				}
			}
		}
		//post请求方式参数设置
		xmlhttpRequest.open("post", url);
		xmlhttpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");//post需要多设置一个请求头
		xmlhttpRequest.send(data);
	}
	
</script>
</head>
<body>
	省份：<select onchange="showCity(this)" >
			<option value="0">省份</option>
			<option value="1">广东</option>
			<option value="2">湖南</option>
			<option value="3">广西</option>
		</select>
	城市:<select id="city">
			<option>城市</option>
		</select>
</body>
</html>