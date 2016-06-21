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
		
		


*/
public class Doc1 {

}
