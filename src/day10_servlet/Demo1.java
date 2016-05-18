package day10_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
Servlet学习的大纲：
	1. servlet概念及相关接口简介
	2. servet 执行过程
	3. servlet路径映射
	4. 缺省servlet          --应用
	5. servlet生命周期(重点)   --理解（重点）
	6. Servlet自动加载 
	7. Servlet线程安全 
	8. servletConfig对象
	9. Servlet相关接口详解
	10. ServletContext对象     --知识点
		
	1 如何开发一个Servlet
		1.1 步骤：
			1）编写java类，继承HttpServlet类
			2）重新doGet和doPost方法
			3）Servlet程序交给tomcat服务器运行！！
				3.1 servlet程序的class码拷贝到WEB-INF/classes目录
				3.2 在web.xml文件中进行配置
				
	问题：访问次URL：  http://localhost:8090/JavaLearn2/Servlet6
	前提： tomcat服务器启动时，首先加载webapps中的每个web应用的web.xml配置文件。	
		http://: http协议
		localhost： 		到本地的hosts文件中查找是否存在该域名对应的IP地址 127.0.0.1
		8090：    		找到tomcat服务器
		/JavaLearn2     在tomcat的webapps目录下找 JavaLearn2的目录
		/Servlet6    	资源名称。
			1）在JavaLearn2的web.xml中查找是否有匹配的url-pattern的内容（/Servlet6）
			2）如果找到匹配的url-pattern,则使用当前servlet-name的名称到web.xml文件中查询是否相同名称的servlet配置
			3）如果找到，则取出对应的servlet配置信息中的servlet-class内容：
				字符串： day10_servlet.Demo1
				通过反射：
					a）构造FirstServlet的对象
					b）然后调用FirstServlet里面的方法
					
	2 Servlet的映射路径
	<servlet-mapping>
		<servlet-name>Servlet6</servlet-name>
		<url-pattern>/Servlet6</url-pattern>
	</servlet-mapping>
	
					url-pattern			浏览器输入
	精确匹配			/Servlet6			http://localhost:8090/JavaLearn2/Servlet6
					/l/Servlet6			http://localhost:8090/JavaLearn2/l/Servlet6
	
	*任意字符串，包括/,也包括""空字符串
	模糊匹配			/*					http://localhost:8090/JavaLearn2/	后面接任意
					/l/*				http://localhost:8090/JavaLearn2/l/fd/s
					*.后缀
					*.do				http://localhost:8090/JavaLearn2/fdsa.do
					*.action			http://localhost:8090/JavaLearn2/fdsa.action
					*.html(伪静态)		http://localhost:8090/JavaLearn2/fdsa.html
					
					
	
	
	注意：
		1）url-pattern要么以 / 开头，要么以*开头。  	例如， Servlet6是非法路径。
		2）*匹配和后缀匹配不能同时使用，					例如 /l/*.do是非法路径
		3）当有输入的URL有多个servlet同时被匹配的情况下：
			3.1 精确匹配优先。（长的最像优先被匹配）
			3.2 以后缀名结尾的模糊匹配优先级最低！！！
	
	3.servlet缺省路径
		servlet的缺省路径是在tomcat服务器内置的一个路径。该路径对应的是一个org.apache.catalina.servlets.DefaultServlet（缺省servlet）
		这个缺省的servlet的作用是用于解析web应用的静态资源文件
		
		问题：url输入http://localhost:8090/JavaLearn2/index.jsp的时候是如何读取文件的？？？
		
		1）到JavaLearn2应用下的web.xml中去查找是否有匹配的 url－pattern，如果找到就处理
		2）如果某页匹配的url－pattern，则交给tomcat内置的DefaultServlet去处理，
		3）DefaultServlet程序到javalearn2应用的根目录下去查找是否存在一个名称为index.jsp的静态文件。
		4）如果找到改文件，这读取改文件内容，返回给浏览器，如果找不到，返回404
		
		结论：先找动态资源，再找静态资源
	
*/
public class Demo1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("this is servlet");
	}
}
