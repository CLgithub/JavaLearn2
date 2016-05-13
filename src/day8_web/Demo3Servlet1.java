package day8_web;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
7 手动开发动态资源
	7.1 静态资源和动态资源的区别
		静态资源： 当用户多次访问这个资源，资源的源代码永远不会改变的资源。（不能与客户交互）
		动态资源：当用户多次访问这个资源，资源的源代码可能会发送改变。（能用客户交互） 
		
	7.2 动态资源的开发技术
		Servlet : 用java语言来编写动态资源的开发技术。
		
		Servlet特点：
			1）普通的java类，继承HttpServlet类，覆盖doGet方法
			2）Servlet类只能交给tomcat服务器运行！！！！（开发者自己不能运行！！！）	
		
		Servlet手动编写步骤：
			1）编写一个servlet程序，继承HttpServlet
			2）找到Demo3Servlet1类的class字节码，然后把拷贝到tomcat的一个web应用中WEB-INF/classes目录下
			3）在当前web应用下的web.xml文件配置Servlet。
			4）启动tomcat服务器，运行访问
				http://localhost:8090/myweb/hello
			
			
			
*/
public class Demo3Servlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码问题
		resp.setContentType("text/html;charset=utf-8");
		//向浏览器输出内容
		resp.getWriter().write("第一个servlet程序,当前时间为："+new Date());
	}

	
}
