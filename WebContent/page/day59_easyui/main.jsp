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
				<div title="系统设置" data-options="iconCls:'icon-save'" style="padding: 10px;">
					上海
				</div>
				<div title="部门管理" data-options="iconCls:'icon-reload'" style="padding: 10px;">
					<a id="btn_add" href="#" class="easyui-linkbutton" 
						data-options="iconCls:'icon-add',plain:true">新增部门</a><p>
					<a id="btn_find" href="#"class="easyui-linkbutton" 
						data-options="iconCls:'icon-search',plain:true">查询部门</a><p>
					<a id="btn_update" href="#" class="easyui-linkbutton" 
						data-options="iconCls:'icon-edit',plain:true ">修改部门</a><p>
					<a id="btn_delete" href="#" class="easyui-linkbutton" 
						data-options="iconCls:'icon-remove',plain:true">删除部门</a><p>
				</div>
				<div title="功能管理二" data-options="iconCls:'icon-reload'" style="padding: 10px;">
					深圳
				</div>
			</div>
	    </div>  
	    <!-- 中 -->
	    <div data-options="region:'center', href:''" style="padding:5px;background:#eee;">
	    	<!-- 嵌入tabs选卡 -->
	    	<div id="tabsID" 
				class="easyui-tabs" 
				style="width:500px;height:250px;"
				data-options="plain:true,fit:true,border:false,
				toolPosition:'right', tabPosition:'top', selected:0
				">  
				<!-- 选项卡 -->
				<div title="首页" style="padding:20px;display:none;">  
			        tab1
			    </div>  
			</div>
	    </div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#layoutID").layout('collapse','south');
		$("#layoutID").layout('collapse','east');
		
		//定位上面的导航条按钮，绑定其点击事件
		$("#accordionID a").click(function(){
			var titletext=$.trim($(this).text());
			//先检测改选项卡是否已经打开
			var flag=$("#tabsID").tabs('exists',titletext+'面板');
			if(flag){	//已经打开，则选中打开页
				$("#tabsID").tabs('select',titletext+'面板');
			}else{	//否则就打开一个新的
				//添加选项卡
				$("#tabsID").tabs('add',{
					id:titletext,
					title:titletext+'面板',
					iconCls:'icon-ok',
					closable:true,
					content:titletext+'内容',
					href:'${pageContext.request.contextPath}/page/day59_easyui/img/mm.html'
				});
			}
		});
	});
	
</script>
</html>