#jQuery常用Method-API

    目的：对web页面（HTML/JSP/XML）中的任何标签，属性，内容进行增删改查
   
###（1）DOM简述与分类
	（A）DOM是一种W3C官方标准规则，可访问任何标签语言的页面(HTML/JSP/XML)
	（B）DOM是跨平台(window/linux/unix)，跨语言(javascript/java)，跨浏览器(ie/firefox/Chrome)的标准规则	
	（C）我们只需要按照DOM标准规则，针对主流浏览器(ie/firefox/Chrome)编程
	（D）JS/jQuery按照DOM的标准规则，既可以操作HTML/JSP，也能操作CSS
	（E）DOM标准规则不是JS的专属，其它语言，也能适用，例如:VBScript，Java语言等

###（2）DOM标准规则下的jQuery常用API，注意：以下方法均由jQuery对象调用
   
	each()：是jQuery中专用于迭代数组的方法，参数为一个处理函数，this表示当前需要迭代的js对象
	append()：追加到父元素之后
	prepend()：追加到父元素之前
	after()：追加到兄弟元素之后
	before()：追加到兄弟元素之前 
	attr(name)：获取属性值
	attr(name,value)：给符合条件的标签添加key-value属性对 
	$("<div id='xxID'>HTML代码</div>")：创建元素，属性，文本  
	remove()：删除自已及其后代节点  
	val()：获取value属性的值
	val("")：设置value属性值为""空串，相当于清空
	text()：获取HTML或XML标签之间的值
	text("")：设置HTML或XML标签之间的值为""空串 
	clone()：只复制样式，不复制行为
	clone(true)：既复制样式，又复制行为
	replaceWith()：替代原来的节点
	removeAttr()：删除已存在的属性
	addClass()：增加已存在的样式
	removeClass()：删除已存在的样式
	hasClass()：判断标签是否有指定的样式，true表示有样式，false表示无样式
	toggleClass()：如果标签有样式就删除，否则增加样式
	offset()：获取对象的left和top坐标
	offset({top:100,left:200})：将对象直接定位到指定的left和top坐标
	width()：获取对象的宽
	width(300)：设置对象的宽
	height()：获取对象的高
	height(500)：设置对象的高
	children()：只查询子节点，不含后代节点
	next()：下一下兄弟节点
	prev()：上一下兄弟节点
	siblings()：上下兄弟节点
	show()：显示对象
	hide()：隐藏对象
	fadeIn()：淡入显示对象
	fadeOut()：淡出隐藏对象
	slideUp()：向上滑动
	slideDown()：向下滑动
	slideToggle()：上下切换滑动，速度快点
        
面试题--find("9类选择器")：查询指定的节点和多重each()迭代
        
	//使用jquery弹出奇数的tr标签下的td里的值
	var $tr = $("table tr:lt(4):even");
	$tr.each(function(){
		//tr中查找td标签,$(this)表示tr
		var $td = $(this).find("td");
		$td.each(function(){
			//$(this)表示td
			var txt = $(this).text();
			alert(txt);
		});
	});
	
jQuery常用Event-API

    目的：对web页面（HTML/JSP）进行事件触发，完成特殊效果的处理
    window.onload：在浏览器加载web页面时触发，可以写多次onload事件，但后者覆盖前者
    ready：在浏览器加载web页面时触发，可以写多次ready事件，不会后者覆盖前者，依次从上向下执行，我们常用$(函数)简化
	       ready和onload同时存在时，二者都会触发执行，ready快于onload
    change：当内容改变时触发
    focus：焦点获取
    select：选中所有的文本值
    keyup/keydown/keypress：演示在IE和Firefox中获取event对象的不同
    mousemove：在指定区域中不断移动触发
    mouseover：鼠标移入时触发
    mouseout：鼠标移出时触发
    submit：在提交表单时触发，true表示提交到后台，false表示不提交到后台
    click：单击触发
    dblclick：双击触发
    blur：焦点失去	

#jQuery常用AJAX-API 
目的：简化客户端与服务端进行局部刷新的异步通讯

####1）取得服务端当前时间（jquer对象.load）

	简单形式：jQuery对象.load(url)
		返回结果自动添加到jQuery对象代表的标签中间
		如果是Servlet的话，采用的是GET方式
	复杂形式：jQuery对象.load(url,sendData,function(backData,textStatus,ajax){... ...})
		sendData = {"user.name":"jack","user.pass":"123"}; 
 		以JSON格式文本方式发送，使用POST方式发送，服务端能收到数据
	注意：对于load方法而言，如果请求体无参数发送的话，load方法，将采用GET方式提交
	注意：对于load方法而言，如果请求体有参数发送的话，load方法，将采用POST方式提交
	注意：使用load方法时，自动进行编码，无需手工编码
####2）检查主持用户名和密码是否存在（$get()和$post()）

	$.get(url,sendData,funciton(backData,textStatus,ajax){...})//强行使用get
	$.post(usl,sendData,funciton(backData,textStatus,ajax){...})//强行使用post
	注意：使用get货post方法时，自动进行编码，无需手动编码
####3)	jQuery对象.serialize()
	作用：自动生成json格式的文本
	注意：为每个jQuery对象设置一个name属性，因为name 属性会被认为请求参数名
	注意：必须用<form>标签
	适用：如果属性过多，强烈推荐使用这个api
####4)$.ajax()
	
	$.ajax({
		type: "post",	//以什么方式发送
		url : url,		//url
		data: sendData,	//发送的数据，json格式
		success:function(backData,textStatus,xmlHttpRequest){//成功后调用的函数
			
		}
	});	