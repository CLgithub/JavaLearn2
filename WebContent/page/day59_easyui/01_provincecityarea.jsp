<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>省份-城市-区域三级联动</title>
    <script type="text/javascript" src="../../easyui/jquery.min.js"></script>
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

	<select id="area">
		<option>选择区域</option>
	</select>
	
	
	<!-- 省份--城市 -->
	<script type="text/javascript">
		//定位"省份"下拉框，同时提交change事件
		$("#province").change(function(){
			//清空城市下拉框中的内容，除第一项外
			$("#city option:gt(0)").remove();
			//清空区域下拉框中的内容，除第一项外
			$("#area option:gt(0)").remove();
			//获取选中的省份
			var province = $("#province option:selected").text();
			//如果不是"选择省份"的话
			if("选择省份" != province){
				//异步发送请求到服务器
				//参数一：url表示请求的路径
				var url = "${pageContext.request.contextPath}/provinceCityAreaController/findCityRequest.action";
				//参数二：sendData表示以JSON格式发送的数据
				var sendData = {
					"province" : province
				};
				//参数三：function(){}处理或回调函数
				$.post(url,sendData,function(backData,textStatus,ajax){
					for(var i=0;i<backData.length;i++){
						var city=backData[i].city;
						var $option = $("<option>"+city+"</option>");
						$("#city").append( $option );
					}
				});
			}
		});					
	</script>


	
  </body>
</html>








