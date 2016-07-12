<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../../../js/jquery-1.4.2.js"></script>
<!-- 省市联动 -->
<script type="text/javascript">
	$(function(){
		$("#province").change(function(){
			//得到选择的省份
			var province=$("#province option:selected").text();
			if("选择省份"!=province){
				var url="${pageContext.request.contextPath}/day48Servlet3";
				var sendData={
					"province":province	
				};
				//$.post(url,sendData,function(){});
				$.ajax({
					type: "post",	//以什么方式发送
					url : url,		//url
					data: sendData,	//发送的数据，json格式
					success:function(backData,textStatus,xmlHttpRequest){	//成功后调用的函数
						//$("#city").html('<option>选择城市</option>');
						$("#city option:gt(0)").remove();	//删除>0的选项
						var $data=$(eval(backData));
						$data.each(function(){
						//	alert($(this));
							$option=$('<option>'+this+'</option>');
							$("#city").append($option);
						})
					}
				});
			}else{
				$("#city option:gt(0)").remove();	//删除>0的选项
			}
		})
			
	});
</script>
<title>省市联动</title>

</head>
<body>
	<select id="province">
		<option>选择省份</option>
		<option>湖南</option>
		<option>广东</option>
	</select>
	<select id="city">
		<option>选择城市</option>
	</select>
	
</body>
</html>