package day21;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
Filter过滤器
	1.Filter介绍以及相关配置api
	2.Filter实例
		1.自动登录
		2.url级别权限控制
		3.全局编码过滤器

1.filter介绍
	问题：filter是什么，有什么作用
		过滤器，能拦截请求和响应，完成一些特定的功能（如权限判断，过滤敏感词，压缩相应信息，加密，标记过滤等）
		
		从技术角度来说：javax.servlet.filter也是一个接口,
			这个接口中有一个方法doFilter方法，它是真正用于进行过滤的方法
			filter也需要在web.xml中配置
			
	filter入门：
		问题：filter怎么创建？
			1.创建一个类，实现 javax.servlet.Filter接口
			2.重写接口中的方法
			3.在web.xml文件中配置
		filter怎么实现过滤器操作
			1.<url-pattern>设置要过滤的路径
			2.在doFilter方法中的第三个参数FilterChain，它是用于控制是否可以访问资源的
				在web应用中，可以编写多个filter，这些filter组合起来称之为一个filter链（FilterChain）
				web服务器根据Filter在web.xml文件中的注册顺序<mapping>,决定先调用哪个filter，当第一个filter
				的doFilter方法被调用时，web服务器会创建一个代表filter链的FilterChain对象，传递给该方法。在
				doFilter方法中，开发人员如果调用了FilterChain对象的doFilter方法，则web服务器会检查FilterChain
				对象中是否还有filter，如果有，则调用第2个filter，如果没有，则调用目标资源
	
		
	filter生命周期
		java.servlet.Filter接口中的三个方法
			1.public void init(FilterConfig arg0) throws ServletException
				初始化方法，只执行一次
			2.public void doFilter(ServletRequest request, ServletResponse response, FilterChain fChain)
				真正进行拦截操作的方法，通过fChain.doFilter(request, response);放行
			3.public void destroy()
				销毁操作
	
	filterConfig（和servletConfig对象很相似，day10_servlet/Demo4.java）
		在filter的init方法中有一个参数filterConfig
		filterConfig作用也是获取的filter的相关配置信息
			1.初始化参数的获取
				String gitInitParameter(String name)
				Enumeration gitInitParameter();
			2.filter的名称的获取
				getFilterName();
			3.servletContext对象获取
				getServletContext();
			
	filter详细配置
		1.关于配置filter 详情看web.xml

		2.Filter链
			在web应用中，可以编写多个filter，这些filter组合起来称之为一个filter链（FilterChain）
			web服务器根据Filter在web.xml文件中的注册顺序<mapping>,决定先调用哪个filter，当第一个filter
			的doFilter方法被调用时，web服务器会创建一个代表filter链的FilterChain对象，传递给该方法。在
			doFilter方法中，开发人员如果调用了FilterChain对象的doFilter方法，则web服务器会检查FilterChain
			对象中是否还有filter，如果有，则调用第2个filter，如果没有，则调用目标资源
			注意：
				1.filter的顺序由filter-mapping的配置顺序执行
		3.url-pattern
			对于filter来说，它是确定拦截资源的路径
			<url-pattern>有几种写法：	day10_servlet/Demo1.java
				1.完全匹配	必须使用"/"开始
				2.可以使用*通配符
					1.目录匹配		必须"/"开始
					2.后缀匹配		以*.xxx结束，不能以"/"开始
		
		
*/
public class Doc1 {

}
