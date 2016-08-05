package day19_2_listener;

/*

javaweb中servlet规范中定义了三种技术：servlet	 listener filter总结

	listener监听器：
		问题：什么是监听器，监听器有什么作用
			监听机制4个要素：
				1.事件源
				2.事件
				3.监听器
				4.注册监听
		监听器就是可以监听某个事物在执行一个特定操作时，我们可以让其触发一个操作
		可以在满足特定条件的情况下执行一段操作
		
		javaweb中的监听器，主要用于监听javaweb中的常用对象（request（HpptServletRequest），session（HttpSession），application（ServletContext））的三种类型操作
			1.对象的创建与销毁
				HttpServletRequest
					监听器：ServletRequestListener接口，可以监听request对象的创建与销毁
				HttpSession
					监听器：HttpSessionListener接口，可以监听session对象的创建与销毁
				ServletContext
					监听器：ServletContextListener接口，可以监听application对象的创建与销毁
			2.对象的属性变化
				HttpServletRequest
					监听器：ServletRequestAttributeListener接口	监听request对象属性的变化
				HttpSession
					监听器：HttpSessionAttributeListener接口	监听session对象属性的变化
				ServletContext
					监听器：ServletContextAttributeListener接口 监听application对象属性的变化
			3.session绑定javaBean
				1.HttpSessionBindingListener
					这个监听器，可以让JavaBean对象，感知他被绑定到session中或从session中移除。
				2.HttpSessionActivationListener
					这个监听器，可以让javaBean对象，感知被钝化或活化
						（服务器正常关闭时，session会被保存到文件里？）
						钝化：内存--》硬盘，活化：硬盘---》内存
					使用：需要创建一个配置文件context.xml
						这个配置文件保持到META-INF目录下（和配置tomcat链接池一样）
						<?xml version="1.0" encoding="UTF-8"?>
						<Context>
							<Manager className="org.apache.catalina.session.PersistentManager"
								maxIdleSwap="1">
								<Store className="org.apache.catalina.session.FileStore"
									directory="cltest" />
							</Manager>
						</Context>
				这两个监听器都由javaBean实现，并且都不用配置
		创建监听器的步骤：
			1.创建一个类，去实现指定的监听器接口
			2.重写接口中方法
			3.在web.xml文件中配置注册监听
	
	serlvet
		https://github.com/CLgithub/JavaLearn2/wiki/day1~day10
		day10_servlet
	
	filter过滤器
		day21.Doc1
		
	servlet和filter的比较总结
		0.性质
			serlvet是一种动态资源，是运行在服务器端的一个组件
			filter过滤器，能拦截请求和响应，完成一些特定的功能（如权限判断，过滤敏感词，压缩相应信息，加密，标记过滤等）
		1.使用步骤比较
			serlet
				1）编写java类，继承 javax.servlet.http.HttpServlet类
			    2）重新doGet和doPost方法
			    3）在web.xml文件中进行配置
			    	<servlet>									配置一个servlet
						<servlet-name></servlet-name>				配置名称
						<servlet-class></servlet-class>				配置处理类
						<init-param>								配置初始化参数
							<param-name></param-name>				配置初始化参数名
							<param-value></param-value>				配置初始化参数值
						</init-param>
						<load-on-startup>1</load-on-startup>		配置为web启动是加载，正数的值越小，启动该servlet的优先级越高。
					</servlet>
					<servlet-mapping>							配置映射mapping
						<servlet-name></servlet-name>				配置用哪个servlet处理
						<url-pattern></url-pattern>					配置映射路径
					</servlet-mapping>
	        filter
	        	1）创建一个类，实现 javax.servlet.Filter接口
				2）重写接口中的方法
				3）在web.xml文件中配置
					<filter>									配置一个filter
						<filter-name></filter-name>					配置名称
						<filter-class></filter-class>				配置处理类
						<init-param>								配置初始化参数
							<param-name></param-name>				配置初始化参数名
							<param-value></param-value>				配置初始化参数值
						</init-param>
					</filter>
				<filter-mapping>								配置映射mapping
						<filter-name></filter-name>					配置用哪个filter处理
						<url-pattern></url-pattern>					配置映射路径
						<sevlet-name></sevlet-name>					配置拦截哪个servlet
						<dispatcher></dispatcher>					配置所过滤的资源被 Servlet 容器调用的方式
					</filter-mapping>
				
				serlvet是通过实现类，filter是继承接口
				映射路径url-pattern，两者基本一致
					1.完全匹配	必须使用"/"开始
					2.可以使用*通配符
						1.目录匹配		必须"/"开始
						2.后缀匹配		以*.xxx结束，不能以"/"开始
						
					注意：
					    1）url-pattern要么以 / 开头，要么以*开头。例如， Servlet6是非法路径。
					    2）后缀匹配,以*.xxx结束，不能以"/"开始    例如 /l/*.do是非法路径
					    3）当有输入的URL有多个servlet同时被匹配的情况下：
					        3.1 精确匹配优先。（长的最像优先被匹配）
					        3.2 以后缀名结尾的模糊匹配优先级最低！！！
		
		2.生命周期
			serlvet
				默认情况下：第一次访问servlet的时候调用构造方法创建servlet对象，       	构造方法
				    只调用一次，证明时servlet对象在tomcat服务器中时单例的
				创建完成后调用init方法初始化											init方法
				每次发送请求的时候调用service方法为请求服务               				service方法
				当停止服务器或重新部署web应用的时候，销毁servlet对象的时候调用destroy方法       destroy方法
			filter
				服务器启动是会创建filter对象，也会调用init方法
				1.public void init(FilterConfig arg0) throws ServletException
					初始化方法，只执行一次
				每次过滤都要执行doFilter方法
				2.public void doFilter(ServletRequest request, ServletResponse response, FilterChain fChain)
					真正进行拦截操作的方法，通过fChain.doFilter(request, response);放行
				当停止服务器或重新部署web应用的时候，调用destroy方法
				3.public void destroy()
					销毁操作
					
		3.servletConfig和filterConfig的比较
			语法上很解决，都是用来的到各种相应的配置环境，初始化参数
			day10_servlet.Demo4
			day21.Demo1Filter2
			
			
		servlet有初始化参数
		filter有初始化参数
		listener没有初始化参数，在开发中一般使用servletCentext中的（<context-param>）
		
		
		
		
		


*/
public class Day19_Day21 {

}
