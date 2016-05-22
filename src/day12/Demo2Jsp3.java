package day12;

/*
6.jsp的三大指令
	6.1 include指令
		作用：在当前页面包含其他的页面
		语法：<%@include file="common/header.jsp" %>
		注意：
			1）把被包含的页面（header.jsp）的内容翻译到包含页面（index.jsp）中，合并翻译成一个java源文件，再编译运行。
				这种包含叫静态包含（源码包含）
			2）如果使用静态包含，被包含页面中就不需要出现全局的html标签了
			
	6.2 page指令
		作用：告诉tomcat服务器如何翻译jsp文件
			<%@ page 
			language="java" 							//告诉服务器使用什么动态语言来翻译jsp文件
			import="java.util.*,java.net.*"				//告诉服务器java文件使用了什么包,多个包之间用,分割
		    
		    pageEncoding="UTF-8"						//告诉服务器使用什么编码翻译jsp文件为java文件
			contentType="text/html; charset=UTF-8"		//服务器发送给浏览器的数据类型（text/html）和内容编码（UTF-8）（这个属性可以省略，如果省略就参考pageEncoding）	相当于servlet里的resp.setContentType("text/html; charset=utf-8");
			
			//错误相关的
			errorPage="common/error.jsp"				//指定当前jsp页面的错误处理页面
			isErrorPage="false"							//指定当前页面是否为错误处理页面 false不是错误处理页面,true是错误处理页面,错误处理页面能使用内置对象exception，输出简单错误信息
			   
			    //全局错误处理页面配置在web.xml中
			     <!-- 全局错误页面配置 -->
					  <error-page>
					  	<error-code>500</error-code>
					  	<location>/page/day12/common/500.jsp</location>
					  </error-page>
					  <error-page>
					  	<error-code>404</error-code>
					  	<location>/page/day12/common/404.html</location>
					  </error-page>
		    
		    
		    
		    buffer="8kb"							//jsp页面缓存区大小，后期说,使用out内置对象向浏览器输出内容时，会先输出到缓存区，这里就是指定这个缓冲区大小
			session="true"							//是否开启session的功能	false不能使用内置对象session，true可以使用session内置对象
			isELIgnored="false"    					//是否是忽略el表达式，后期说
		    %>
		
		
	6.3 taglib指令
*/
public class Demo2Jsp3 {

}
