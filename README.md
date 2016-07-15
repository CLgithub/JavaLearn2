# JavaLearn2
java就业学习及零散<br>
##主要知识点：<br>
	js相关
	xml相关
	http协议
	servlet
	jsp
	mysql数据库
	jdbc
	事务
	连接池
	元数据
	监听器listener
	过滤器filter
	ajax，注解，类加载器，范型反射，动态代理，servlet3...
	javaee框架：
		struts2
		spring
		mybatis
		springMVC
	
	
	
	
##知识点目录梳理与复习
####day1	部分基础复习
####day3	js基础
####day4	js基础语法
####day5	js应用与练习
	javascript组成：
		EMCAScript(基本语法)
		BOM(Browser Object Model)	浏览器对象模型
		DOM(Document Object Model)文档对象模型
####day6	xml基础语法
####day7	xml解析
	两种解析方式：DOM解析，SAX解析
	使用dom解析（一次性全部读取到document）
		读取：Document document=new SAXReader().read(xml文件输入流);
		创建：Document document=DocumentHelper.createDocument();
	写入xml文件（可指定编码、格式...）	（dom4j工具）
		new XMLWriter(fos,format).write(document);
	使用dom解析修改xml内容
		增加：文档，标签，属性
		修改：属性值，文本
		删除：标签，属性
	使用SAX解析（一点一点读取）
		//1.创建SAXParser对象
		SAXParser saxParser=SAXParserFactory.newInstance().newSAXParser();
		//2.调用parse方法，MyDefaultHandler2继承DefaultHandler类，实现里面的方法（startElement()读到开始标签,characters()读到文本等方法）来完成读取工作
		saxParser.parse(xml文件对象, new MyDefaultHandler2(sBuilder));

	DOM解析	
		原理： 一次性加载xml文档，不适合大容量的文件读取
		DOM解析可以任意进行增删改成
		DOM解析任意读取任何位置的数据，甚至往回读
		DOM解析面向对象的编程方法（Node，Element，Attribute）,Java开发者编码比较简单。
	SAX解析
		原理： 加载一点，读取一点，处理一点。适合大容量文件的读取
		SAX解析只能读取
		SAX解析只能从上往下，按顺序读取，不能往回读
		SAX解析基于事件的编程方法。java开发编码相对复杂。
dom操作xml节点方法
<table border=1 width='100%'>
	<tr>
		<td width='7%'></td>
		<td>标签</td>
		<td>属性</td>
		<td>文本</td>
	</tr>
	<tr>
		<td align='center'>增</td>
		<td>Element.addElement("标签名")</td>
		<td>Element.addAtrribute("name","value")</td>
		<td>／</td>
	</tr>
	<tr>
		<td align='center'>删</td>
		<td>Element.detach()</td>
		<td>Attribute.detach()</td>
		<td>／</td>
	</tr>
	<tr>
		<td align='center'>改</td>
		<td>／</td>
		<td>Attribute.setValue("value");修改属性值</td>
		<td>Element.setText("value")</td>
	</tr>
	<tr>
		<td align='center'>查</td>
		<td colspan='3' align='center'>XPath技术： 快速找到xml元素（标签，属性，文本）</td>
	</tr>
</table>

		
		