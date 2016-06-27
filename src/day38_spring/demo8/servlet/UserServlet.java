package day38_spring.demo8.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import day38_spring.demo8.service.UserService;

/*
正常整合Servlet和Spring没有问题的
但是每次执行Servlet的时候加载Spring配置,加载Spring环境.
	解决办法:在Servlet的init方法中加载Spring配置文件?
		当前这个Servlet可以使用,但是其他的Servlet的用不了了!!!
	于是想到，将加载的信息内容放到servletContext中servletContext对象是全局对象，服务器启动时候创建的，
		在创建ServeltContext是加载Spring的环境
	可以使用ServletContextListener监听器来实现，该监听器可以监听servletContext对象的创建与销毁
	
	导入;spring-web-3.2.0.RELEASE.jar（忽略版本）
	在web.xml中配置:
	 <listener>
	 	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	 </listener>
	 
	 <context-param>
	 	<param-name>contextConfigLocation</param-name>
	 	<param-value>classpath:applicationContext.xml</param-value>
	 </context-param>
	修改程序的代码:
	WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	WebApplicationContext applicationContext = (WebApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	
 * */

//1配置通过"/day38_UserServlet"来访问该servlet
@WebServlet(urlPatterns="/day38_UserServlet")
public class UserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38_3.xml");
//		UserService userService = (UserService) applicationContext.getBean("userService");
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		UserService userService = (UserService) webApplicationContext.getBean("userService");
		userService.sayHello();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
