package day12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
jsp内置对象（重点）
	2.1 什么是jsp内置对象？
	在jsp的开发中，会频繁的使用到一些对象，比如：httpServlet，ServletContext，ServletContext，HttpServletRequest
		如果我们每次都要使用这些对象都要创建这些对象就会显得非常麻烦，所有sun公司在设计jsp时，在jsp页面加载完毕之后就会自动帮
		开发者创建好这些对象，二开发这只学院直接使用这些对象即可，这些创建好的对象就叫内置对象
	2.2 jsp9大内置对象：常用的9个tomcat已经给我们创建好，
			内置对象名					类型
			
			request					HttpServletRequest			请求
			response				HttpServletResponse			响应
			config					ServletConfig				servlet配置
			application				ServletContext				servlet内容
			session					HttpSession					session
			
			exception				Throwable					异常
			
			page					Object(this)				相当于this
			
			out						jspWriter					向浏览器输出信息类
			pageContext				PageContext
			
	2.3 out对象
		out对象类型，jspWriter类，相当于带缓存的PrintWriter
		PrintWriter
			write(内容)	直接向浏览器输出内容
		jspWriter
			write(内容)	向jsp缓存区写出内容		缓冲区大小默认8k，可以用page指令设置
			
*/
public class Demo2jsp4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
//		writer.write(s);
	}
}
