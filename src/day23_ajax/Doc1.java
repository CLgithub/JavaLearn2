package day23_ajax;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/*
ajax
	问题：ajax是什么，它有什么作用
		AJAX即“Asynchronous JavaScript and XML”（异步的JavaScript与XML技术），
			指的是一套综合了多项技术的浏览器端网页开发技术
		
		使用ajax目的是为了提高用户的感受
	问题：什么是异步
		异步操作的核心：XMLHttpRequest对象
		
		传统web交互模型，浏览器直接将请求发送给服务器，服务器回送响应，直接发给浏览器， 
		Ajax交互模型，浏览器首先将请求 发送 Ajax引擎（以XMLHttpRequest为核心），
			AJax引擎再将请求发送给 服务器，服务器回送响应先发给Ajax引擎，再由引擎传给浏览器显示 

		1、同步交互模式，客户端提交请求，等待，在响应回到客户端前，客户端无法进行其他操作 
		2、异步交互模型，客户端将请求提交给Ajax引擎，客户端可以继续操作，由Ajax引擎来完成与服务武器端通信，
		    当响应回来后，Ajax引擎会更新客户页面，在客户端提交请求后，用户可以继续操作，而无需等待 。 

		Google ： suggest建议、邮件定时保存、map地图
------------------------------------------------------------------
ajax开发步骤：（demo1.jsp）
	ajax核心：XMLHttpRequest对象
	1.得到XMLHttpRequest对象
		在w3school文档中的 xmldom文档中就可以查找到  dom XMLHttpRequest对象.
		var xmlhttpRequest=null;
		if (window.XMLHttpRequest){// 新的浏览器，包括ie7及以上
			xmlhttpRequest=new XMLHttpRequest();
		} else if (window.ActiveXObject){// code for IE5 and IE6
			xmlhttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
		}
	2.给XMLHttpRequest对象注册回调函数，当XMLHttpRequest对象的readyState改变时调用
		xmlhttpRequest.onreadystatechange=function(){}
	3.open
		只是初始化http请求参数，例如url和http方法，它不发送请求
	4.send
		发送请求
		send(null);	null代表没有请求参数，如果有请求参数可以写成："userName=tom&id=1"
	5.在回调函数中处理数据
		1.readyState属性代表XMLHttpRequest对象的状态
			共5个状态：
				0：XMLHttpRequest对象创建状态
				1.open操作
				2.send操作
				3.接受到相应数据，当时只有相应头，正文还没有接收
				4.所有http相应接收完成
		2.status属性，由服务器返回的http状态码，200（成功）
			xmlhttpRequest.status==200
		3.在回调函数中可以通过以下方式获取服务器返回的数据
			1.responseText	响应的是文本
			2.responseXML	响应的是xml？？？
	--------------------------------------------
	关于ajax操作中请求参数的设置（demo2）
		1.对于get请求方式,参数设置
			直接在url后面拼接
			例如："${pageContext.request.contextPath}/ajax2?name=aaa"
		2.对于post请求方式，参数设置
			xmlhttpRequest.open("post", "${pageContext.request.contextPath}/ajax2");
			xmlhttpRequest.send("name=abc");
			注意：如果是post请求方式，还需要设置一个http请求头
			xmlhttpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	 	
 	-----------------------------------------------------
 	ajax案例1---验证用户名是否可以使用（demo3）
 	－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
 	展示商品信息
 		版本1（demo4）
 			向浏览器输出页码及数据
 		版本2（demo5）(json)
 			在服务器端得到数据，只将要显示的数据返回，而不返回html代码，而html代码的拼接，在浏览器端完成
 			问题：服务器返回什么样的数据格式
 				json：一种轻量级的数据交换格式（Javascript的一个子集）
 				[{'id':'1','name':'洗衣机','price':'1800'},{'id':'2','name':'电视机','price':'3800'}]
 				在js中{name:value,name:value},这就是一个js对象
 				[{},{}]两个对象装入到了浏览器中
			
			json插件使用：
				在java中，可以通过jsonlib插件，在java对象与json之间做转换
				使用：
					1.导jar包(6个)
					
					2.将java对象转换成json
						1.对于数组，list集合，
							JSONArray.fromObject(list)	["value1","value2","value3",...]
						2.对于javaBean
							JSONObject.fromObject(product)	{"name1":"value1","name2":"value2",...}
					对于json数据，只有两种格式
						1.["value1","value2","value3",...]	-----就是javascript中的数组
 						2.{"name1":"value1","name2":"value2",...}		---就是javascript中的对象
 						但是，这两种格式可以嵌套
 						[{},{},{}]
 						{name1:[],name2,[]}
 						
					3.如果javaBean中有一个属性，不想生成在json中，怎样处理？
						JsonConfig config=new JsonConfig();
						config.setExcludes(new String[]{"type"});		//Exclude	拒绝…参加

	
	
*/
public class Doc1 {

}
