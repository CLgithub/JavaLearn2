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
####day7	xml解析相关
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

* 在dom4j中使用xPath技术

		List<Node> selectNodes("xpath表达式");   查询多个节点对象
		Node selectSingleNode("xpath表达式");  查询一个节点对象
		xPath语法
			/		绝对路径	表示从xml的根位置开始或子元素（一个层次结构）
			//					表示不分任何层次结构的选择元素。
			*		通配符		表示匹配所有元素
			[]		条件		表示选择什么条件下的元素
			@		属性		表示选择属性节点
			and		关系		表示条件的与关系（等价于&&）
			text()	文本		表示选择文本内容
	* xpath同样也可以查找html的document
	* 学习struts2时自己模拟实现struts2功能时有用到xml解析
	
####day8	xml约束
	XML约束技术
		1.DTD约束：语法相对简单，功能也相对简单。学习成本也低。
		2.Schema约束：语法相对复杂，功能也相对强大。学习成本相对高！！！（名称空间）
* struts2配置文件struts.xml使用的是DTD约束
* spring配置文件中酒使用的是Schema约束
* mybatis映射文件使用的是DTD约束

####day8	web入门
	软件结构
		C/S		B/S
	服务器
		web服务器，把本地的资源共享给外部访问。
	常见服务软件
		WebLogic: BEA公司的产品。 收费的。支持JavaEE规范。(13种技术)
		WebSphere： IBM公司的产品。收费的。支持JavaEE规范
		JBoss: Redhat公司的产品。收费的。支持JavaEE规范
		Tomcat： 开源组织Apache的产品。免费的。支持部分的JavaEE规范。（servlet、jsp。jdbc，但ejb， rmi不支持）
			javase的规范,包含IO流，线程，集合，socket编程。。。。
		
	URL
		URL全名叫统一资源定位符，用于定位互联网的资源。
		问题： http://localhost:8081/myweb/test.html  看到文件？
		http://     协议。http协议。
		localhost    域名。为了找到IP地址。
						本地域名： localhost
						外部域名：www.google.com
		8081       端口。软件监听的
					8080： tomcat默认的端口
					3306：mysql数据库的端口
					1521： orace数据库的端口。
		/myweb:   web应用的名称。默认情况下，在webapps目录下找
		/test.html  ： 资源名称。
		
	url:统一资源定位符,用于定位互联网的资源,只标识互联网位置，是uri的特例（子）
	uri:统一资源标识符,用于标识资源位置,即可以是互联网位置，也可以是其他位置，可以是一个域，也可以是一个资源（父）
		
	Tomcat的目录结构
		|-bin: 存放tomcat的命令。
				catalina.bat 命令：
					startup.bat  -> catalina.bat start	
					shutdown.bat - > catalina.bat stop
	    |- conf: 存放tomcat的配置信息。其中server.xml文件是核心的配置文件。
		|-lib：支持tomcat软件运行的jar包。其中还有技术支持包，如servlet，jsp
		|-logs：运行过程的日志信息
		|-temp: 临时目录
		|-webapps： 共享资源目录。web应用目录。（注意不能以单独的文件进行共享）
		|-work： tomcat的运行目录。jsp运行时产生的临时文件就存放在这里
		
	WEB应用的目录结构
	|-WebRoot:web应用的根目录
		|-静态资源（html，css，js，image……）
		|-WEB-INF：固定写法
			|-classes:(可选)固定写法。存放class字节码文件
			|-lib：（可选）固定写法。存放jar包文件。
			|-web.xml
			|- TLD文件：标签库描述文件

	注意：
		1.WEB-INF目录里的资源不能通过浏览器直接访问
		2.如果希望访问到WEB-INF里面的资源，就必须把资源配置到一个叫web.xml的文件中。
		
####day9	http	
			
	
