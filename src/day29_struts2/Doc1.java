package day29_struts2;

/*
1.介绍struts2框架
	问题：什么是框架，框架有什么用？
		框架 是 实现部分功能的代码 （半成品），使用框架简化企业级软件开发 ,提高开发效率。
		学习框架 ，清楚的知道框架能做什么？ 还有哪些工作需要自己编码实现 ？
	
	问题:什么是struts2框架，它有什么用?
		struts2是一个标准的mvc框架
		struts2框架是在javaweb开发中使用的。
		使用struts2框架，可以简化我们的web开发，并且降低程序的耦合度。
		
		Struts 2是Struts的下一代产品，是在 struts 1和WebWork的技术基础上进行了合并的全新的Struts 2框架。
		其全新的Struts 2的体系结构与Struts 1的体系结构差别巨大。Struts 2以WebWork为核心
		struts2=struts1+webwork;
		struts2框架是apache的产品
		
		类似于struts2框架的产品 :
			struts1  webwork  jsf  springmvc
			
			ssh---struts2 spring hibernate
			ssi---springmvc spring ibatis
			ssm---springmvc spring mybatis
			
		XWork---它是webwork核心
			Xwork提供了很多核心功能：前端拦截机（interceptor），运行时表单属性验证，类型转换，
			强大的表达式语言（OGNL – the Object Graph Navigation Language），
			IoC（Inversion of Control反转控制）容器等
			
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
struts2流程
	1.运行流程
		请求－－－》web.xml里配置的StrutsPrepareAndExecuteFilter核心控制区－－－》interceptors拦截器（实现代码功能）
		－－－》action的execuute方法－－－－》结果页面result
		拦截器在struts-default.xml定义
		执行拦截器是defaultStack中引用拦截器

	---- 通过源代码级别断点调试，证明拦截器是执行 
	2.关于手动配置struts.xml文件中提示操作
		 如果安装Aptana编辑器 ，请不要用Aptana自带xml编辑器 编写struts2配置文件 
		 struts.xml提示来自于 DTD约束， 
			<!DOCTYPE struts PUBLIC
			"-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
			"http://struts.apache.org/dtds/struts-2.3.dtd">
			如果可以上网，自动缓存dtd，提供提示功能
			如果不能上网，也可以配置本地DTD提示 

		*** 导入DTD时，应该和配置DTD版本一致 
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
struts2配置（重点）
	1.struts2配置文件加载顺序
		struts2框架要能执行，必须先加载StrutsPrepareAndExecuteFilter
		在StrutsPrepareAndExecuteFilter的init方法中对Dispatcher对象进行初始化
		在Dispatcher类中定义的init方法内就描述类struts2配置文件的加载顺序
			init_FileManager();
            init_DefaultProperties(); // [1]		org/apache/struts2/default.properties 
            init_TraditionalXmlConfigurations(); // [2]		struts-default.xml,struts-plugin.xml,struts.xml
            init_LegacyStrutsProperties(); // [3]			自定义配置struts.properties
            init_CustomConfigurationProviders(); // [5]		自定义配置常量
            init_FilterInitParameters() ; // [6]			web.xml
            init_AliasStandardObjects() ; // [7]			Bean加载
        
        1.default.properties文件
         	作用：定义类struts2框架中所有常量
		2.struts-default.xml,	配置类bean，interceptor，result等
			struts-plugin.xml,		struts2中所使用的插件的配置文件
			struts.xml				我们自己的配置文件
		3.自定义的struts.properties		
			可以自定义常量
		4.web.xml
		
		在开发中，后加载文件中的配置会将先加载文件中的配置覆盖
		default.properties
		struts-default.xml
		struts.xml
		
	2.关于Action的配置
		1.<package>  作用:是用于声明一个包。用于管理action。
			1.name     它用于声明一个包名，包名不能重复，也就是它是唯一的。 
			2.namespace  它与action标签的name属性合并确定了一个唯一访问action的路径。
			3.extends  它代表继承的包名。
			4.abstrace 它可以取值为true/false,如果为true,代表这个包是用于被继承的。
		2<action>  用于声明 一个action
			1.name  就是action的一个名称，它是唯一的(在同包内) 它与package中的namespace确定了访问action的路径。
			2.class Action类的全名
			3.method 要访问的Action类中的方法的名称,方法无参数 ，返回值为String.
		3.<result> 用于确定返回结果类型
			1.name  它与action中的方法返回值做对比，确定跳转路径。
		
		关于action配置其它细节：
			1.关于默认值问题
				<package namespace="默认值"> namespace的默认值是""
				<action class="默认值"  method="默认值">
					class的默认值是  com.opensymphony.xwork2.ActionSupport
					method的默认值是  execute
				<resultd	X name="默认值"> name的默认值是 "success"  
			2.关于访问action的路径问题
				现在的action配置是
				<action name="struts2Demo1" class="day29_struts2.Demo1Action" method="say" >
					<result name="good">/page/day29_struts2/struts2Demo1.jsp</result>
				</action>
				当我们输入：
					http://localhost:8090/JavaLearn2/a/b/c/struts2Demo1
					也能访问action
				原因：struts2中action中的action被访问是，它会首先查找
					1.namespace="/a/b/c"	action的name=struts2Demo1	没有
					2.namespace="/a/b"		action的name=struts2Demo1	没有
					3.namespace="/a"		action的name=struts2Demo1	没有
					4.namespace="/"			action的name=struts2Demo1	找到了
					
					如果最后也查找不到，就会404
			3.默认的action
				作用：处理其他action处理不了的路径
				<!-- 配置查找不到action是，默认使用struts2Demo1 -->
				<default-action-ref name="action名称" />
			
			4。action的默认处理类
				在action配置时，如果class不写，默认处理下是com.opensymphony.xwork2.ActionSupport
				<!-- 配置action默认处理类 -->
				<default-class-ref class="day29_struts2.Demo1Action" />
	
	关于常量配置
		default.properties 他声明了struts中的常量
		问题：人为设置常量，可以在那些位置设置？
			1.struts.xml（应用最多）
				<!-- 在struts.xml中配置常量 -->
				<constant name="struts.action.extension" value="abc,," />
			2.struts.properties（基本不使用）
			3.web.xml（了解）
				<!-- 在web.xml中配置struts常量，使用filter初始化参数方式配置 -->
				<init-param>
					<param-name>struts.action.extension</param-name>
					<param-value>do,,</param-value>
				</init-param>

		常用常量：
			（/org/apache/struts2/default.properties下）
			struts.action.extension=action,,
				用于指定struts2框架默认拦截的后缀
			<constant name="struts.i18n.encoding" value="UTF-8"/>  
				相当于request.setCharacterEncoding("UTF-8"); 解决post请求乱码
			<constant name="struts.serve.static.browserCache" value="false"/> 
				false不缓存，true浏览器会缓存静态内容，产品环境设置true、开发环境设置false
			<constant name="struts.devMode" value="true" />  
				提供详细报错页面，修改struts.xml后不需要重启服务器 （要求）
				
----------------------------------------------------------------------
	struts配置文件的分离
		<!-- 引入struts_0.xml -->
		<include file="struts_0.xml"></include>
				
				
*/
public class Doc1 {

}
