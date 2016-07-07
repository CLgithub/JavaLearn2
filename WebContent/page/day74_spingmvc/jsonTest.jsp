<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json测试</title>
</head>
<body>
	<input type="button" value="请求json响应json" onclick="fun1()"><br>
	<input type="button" value="请求key/value响应json" onclick="fun2()"><br>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js" ></script>
<script type="text/javascript">
	/* 此处涉及到的jquery知识后期会看 */	
	function fun1(){
		$.ajax({
			url:'${pageContext.request.contextPath}/jsonTest/test1.action',
			type:"post",
			contentType:"application/json;charset=utf-8",
			//请求json数据,使用json表示商品信息
			data:'{"name":"手机","price":2499,"createtime":"2015-01-06"}',
			success:function(data){
				alert(data);
				alert(data.createtime);
				//查看请求头和响应头
			}
		})
	}
	
	
	function fun2(){
		$.ajax({
			url:"${pageContext.request.contextPath}/jsonTest/test2.action",
			type:"post",
			//contentType:"application/json;charset=utf-8",
			//请求key/value数据,
			data:"name=手机&price=2499&createtime=2015-01-06 12-04-05",
			success : function(data) {
				alert(data);
				alert(data.createtime);
			}
		})
	}
</script>
</html>