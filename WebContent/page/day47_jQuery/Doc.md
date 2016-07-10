#jQuery
流行的js类库

市场用得比较多两个框架： jQuery 比较适合做一些互联网 的应用（12306.com,蘑菇街，美丽说，聚美）

extjs 比较适合做后台管理系统（电商（订单管理），银行，电信）

##核心（重点）
	主要功能：javascript开发人员查找元素、操作DOM、处理事件、执行动画和开发Ajax的操作。
	jQuery 优势：（宗旨：write less ，do more 写更少的代码，做更多的事情）
	bs 架构：性能
	1.轻量级（js 库非常小）
	2.强大的选择器（获取页面上面的dom
		元素document.getElementById()
		操作dom 必须先得到dom
	）
	3.出色的DOM操作的封装
	4.可靠的事件处理机制(对事件进行了一个封装)
	5.完善的Ajax（底层封装xmlhttprequest）
	6.不污染顶级变量（在jquery 里面只有一个对象   jQuery  == $）
	7.出色的浏览器兼容性
	8.链式操作方式($("#ddd").addClass().removeClass())
	9.隐式迭代 (显示迭代:迭代一个数组)
		显示迭代（for(var i=0;i<array.length;i++){
		}）
		隐身迭代屏蔽掉for 操作
	10.行为层与结构层的分离
	11.丰富的插件支持  后期扩展非常方便
	12.完善的文档
jQuery只有一个对象（jQuery==$）一定要搞清楚jQuery 与dom 对象之间的区别于联系	
##选择器 （重点：要操作dom 必须先得到dom）（jQuery 给我们提供九种类型的选择器）
1.基本选择器


2.层级选择器
	
	<body>
    <div>
        <div>
        </div>
    </div>
    <div>
    </div>

	</body>

	//只有当前的方法放回的是jquery对象，才能进行链式操作
3.过滤选择器


	（找到一对页面元素，名可以对这些元素加过滤条件，）
	内容过滤选择器
4.可见度过滤器

5.属性过滤选择器
	
	<div title="text" class=""  id="" ></div>
6.子元素过滤选择器

7.表单选择器	
		
		
##插件
##UI