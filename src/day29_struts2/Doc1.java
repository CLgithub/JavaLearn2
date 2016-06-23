package day29_struts2;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

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

----------------------------------------------------------------------
Action
	1.关于cation类的创建方式介绍
		有三种方式
		1.创建一个POJO类
			朴素的java对象（plain old java object）
			指的是没有实现任何借口，没有基础任何父类（除object）
			优点：无耦合
			缺点：所有工作都要自己实现
			
			在struts2框架底层是通过反射来操作:
				* struts2框架 读取struts.xml 获得 完整Action类名 
				* obj = Class.forName("完整类名").newInstance();
				* Method m = Class.forName("完整类名").getMethod("execute");  m.invoke(obj); 通过反射 执行 execute方法
			
		2.创建一个类，实现Action接口	com.opensymphony.xwork2.Action
			优点：耦合低，提供了五种结果视图，定义了一个行为方法
			缺点：所有工作都要自己实现，但是有规范
			
			public static final String SUCCESS = "success";  // 数据处理成功 （成功页面）
			public static final String NONE = "none";  // 页面不跳转  return null; 效果一样
			public static final String ERROR = "error";  // 数据处理发送错误 (错误页面)
			public static final String INPUT = "input"; // 用户输入数据有误，通常用于表单数据校验 （输入页面）
			public static final String LOGIN = "login"; // 主要权限认证 (登陆页面)
			
		3.创建一个类，继承ActionSupport类	 com.opensymphony.xwork2.ActionSupport  该类实现了Action接口
			优点:表单校验、错误信息设置、读取国际化信息 三个功能都支持.
			缺点：耦合度高
		
		在开发中，第三种会使用得比较多
		
------------------------------------------------------------------------------
	关于action的访问:
		1.通过设置method的值，来确定action类中访问哪个方法
		2.设置通配符类简化配置
			<action name="book_*" class="day29_struts2.BookAction"	method="{1}"></action>
			当输入：http://localhost:8090/JavaLearn2/book_add时，便会访问BookAction里的add方法
			
			使用通配符注意事项：
				1.必须定义一个统一的命名规范
				2.不建议使用过多的通配符
		
		3.动态方法调用
			<!-- 开启动态方法调用 -->
			<constant name="struts.enable.DynamicMethodInvocation" value="true" />
			<!-- 动态方法调用 -->
			<action name="book" class="day29_struts2.BookAction" ></action>

---------------------------------------------------------------------------------
在struts2框架中获取servlet api
	对于struts2框架，不建议直接使用servlet api；
	在struts2中获取servlet api有三种方式
		1.通过ActionContext来获取（demo5）
			1.获取ActionContext对象
			2.通过actionContext对象获取servlet api
				注意：通过actioncontext对象获取的servlet api是一个map集合
				
				1.Map<String, Object> application = aContext.getApplication();	//appliction
				2.Map<String, Object> session = aContext.getSession();			//session
				3.Map<String, Object> parameters = aContext.getParameters();	//获取请求参数,相当于request.getParameters()
				4.aContext.put("userName", "小明");	//相当于request.setAttribute(String,value);
				
		2.注入方式获取(这种方式是真正的获取到了servlet api)（demo6）
			1.要求action必须实现指定的接口
				ServletContextAware ： 注入ServletContext对象
				ServletRequestAware ：注入 request对象
				ServletResponseAware ： 注入response对象
			2.重写方法
		
			3.声明web对象，使用接口中的方法对声明的参数赋值
				private HttpServletRequest request;
				@Override
				public void setServletRequest(HttpServletRequest request) {
					this.request=request;
				}
			扩展：分析其实现
				是使用struts2中的一个拦截器interceptor完成的
				类似经典ssh中user的获取方式，这种方式就是注入
				<interceptor name="servletConfig" class="org.apache.struts2.interceptor.ServletConfigInterceptor"/>
				
				if (action instanceof ServletResponseAware) {	//判断该action是否实现了ServletResponseAware接口，如果实现了
		            HttpServletResponse response = (HttpServletResponse) context.get(HTTP_RESPONSE);//得到request对象
		            ((ServletResponseAware) action).setServletResponse(response);//调用注入方法
		        }
		3.通过ServletActionContext获取（demo7）
			四大域对象
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpServletResponse response = ServletActionContext.getResponse();
				PageContext pageContext = ServletActionContext.getPageContext();
				ServletContext servletContext = ServletActionContext.getServletContext();
				ServletConfig servletConfig = ServletActionContext.getPageContext().getServletConfig();
---------------------------------------------------------------
struts2 结果类型
	<result>标签
		1.name 与action的方法的返回值匹配，进行跳转
		2.type 作用：用于定义跳转方式
			对于type属性，它的值有以下几种：
				在struts-default.xml中定义了type可以取的值
					<result-type name="chain" class="com.opensymphony.xwork2.ActionChainResult"/>
					<result-type name="dispatcher" class="org.apache.struts2.dispatcher.ServletDispatcherResult" default="true"/>
					<result-type name="freemarker" class="org.apache.struts2.views.freemarker.FreemarkerResult"/>
					<result-type name="httpheader" class="org.apache.struts2.dispatcher.HttpHeaderResult"/>
					<result-type name="redirect" class="org.apache.struts2.dispatcher.ServletRedirectResult"/>
					<result-type name="redirectAction" class="org.apache.struts2.dispatcher.ServletActionRedirectResult"/>
					<result-type name="stream" class="org.apache.struts2.dispatcher.StreamResult"/>
					<result-type name="velocity" class="org.apache.struts2.dispatcher.VelocityResult"/>
					<result-type name="xslt" class="org.apache.struts2.views.xslt.XSLTResult"/>
					<result-type name="plainText" class="org.apache.struts2.dispatcher.PlainTextResult" />
				必会：chain  dispatcher  redirect redirectAction  stream
					despatcher：请求转发，默认，他一般用于从action到jsp
					chain：相当于请求转发，他一边情况先用于冲一个action跳转的另一个action
					redirect：重定向，一般用于从action跳转到jsp
					redirectAction：重定向，一般用于从一个action跳转到另一个action(之前用的是这个)
					stream：服务器端返回的是流，一般用于下载
				了解 ：freemarker  velocity（模板）
				
				局部结果页面，全局结果页面
					<!-- 定义全视图 ，全局结果页面 -->
					<global-results>
						<result name="login">/page/onRight.jsp</result>
						<result name="noRight">/page/onRight.jsp</result>
					</global-results>
				
*/
public class Doc1 {

}
