<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>布局加面板练习</title>
	<!-- 引入easyui css文件,不限顺序 -->
	<link rel="stylesheet" href="../../easyui/themes/default/easyui.css" type="text/css" />
	<link rel="stylesheet" href="../../easyui/themes/icon.css" type="text/css" />
	<!-- 引入js文件，有顺序限制 -->
	<script type="text/javascript" src="../../easyui/jquery.min.js" ></script>
	<script type="text/javascript" src="../../easyui/jquery.easyui.min.js" ></script>
</head>
<body>
	<!-- 布局容器 --><!-- fit:true 是否填充满 -->
	<div  id="layoutID" style="width: 700px;height: 400px;" class="easyui-layout" data-options="fit:true">
		<!-- 北 --><!-- region:位置，title:面板标题， -->
		<div data-options="region:'north',split:true ,border:false " style="height:100px;">
			<center><font style="font-size: 60px; " >top 欢迎xxx</font></center>
		</div>  
	    <!-- 南 -->
	    <div data-options="region:'south',title:'南',split:true ,border:false" style="height:100px;"></div>  
	    <!-- 东 -->
	    <div data-options="region:'east',iconCls:'icon-reload' ,border:false,title:'East',split:true" style="width:100px;">
	    </div>  
	    <!-- 西 -->
	    <div data-options="region:'west',title:'West',split:false ,border:false" style="width:200px;">
	    	<!-- 容器 -->
			<div id="accordionID" 
				class="easyui-accordion" 
				data-options="fit:true,border:false,animate:true,multiple:false,selected:0" 
				>
				<!-- 面板 -->
				<div title="系统设置" data-options="iconCls:'icon-save'" >
					上海
				</div>
				<div title="功能管理一" data-options="iconCls:'icon-reload'" >
					北京
				</div>
				<div title="功能管理二" data-options="iconCls:'icon-reload'">
					深圳
				</div>
			</div>
	    </div>  
	    <!-- 中 -->
	    <div data-options="region:'center',title:'center title', href:'/JavaLearn2/page/day59_easyui/img/mm.html'" style="padding:5px;background:#eee;"></div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#layoutID").layout('collapse','south');
		$("#layoutID").layout('collapse','east');
	});
</script>
</html>