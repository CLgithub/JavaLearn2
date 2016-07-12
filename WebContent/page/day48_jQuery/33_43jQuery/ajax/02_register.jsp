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
			var userName=$("input:text").val();
			var password=$("input:password").val();
			var url="${pageContext.request.contextPath}/day48Servlet2";
			/* 手工写json文本 */
			/* var sendData={
				"userName":userName,
				"password":password
			}; */
			//jquery对象自动生成json对象
			var sendData=$("form").serialize();
			alert(sendData);
			//使用
			$.post(url,sendData,function(backData){
			//	alert(backData);
				//如果服务器返回html，即backDate是字符串，不需要解析
				//如果服务器返回json，即backDate是object，需要解析
				//如果服务器返回xml，即backDate是object，需要解析
				$("span").text(backData);
			});
		});
	});
</script>
<title>使用jquery的ajax获取服务端时间</title>

</head>
<body>
	<form>
	<!-- <form action="xxx" method="get"> -->
		<table border="1" align="center">
			<tr>
				<th>用户名</th>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="检查" style="width: 100px" />
				</td>
			</tr>
		</table>
	</form>
	<span></span>
</body>
</html>