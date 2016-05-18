package day10_servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
7.有参的init方法和无参的init方法
 
8.servlet在tomcat下是单实例，多线程的
 	有线程安全问题，如果多个对象同时访问啦servlet对象的公共部分，可能会有线程安全问题
 
  解决办法：锁
  
  
*/
public class Demo3init extends HttpServlet{
	
	private Integer count=1;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		synchronized (Demo3init.class) {
			resp.getWriter().write("你现在是该网站的第"+count+"个访客");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
	}
	
	
	
	/**
	 * 有参init方法
	 * 该方法时servlet的生命周期方法，一定会被tomcat调用
	 * 如果要编写初始化代码，不需要覆盖有参的init方法（看源码）
	 */
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		System.out.println("有参init方法");
//	}
	
	/**
	 * 无参init方法
	 * 该方法是servlet的编写初始化代码的地方，是sun公司设计处理专门给开发者进行覆盖，然后在里面编写serlvet的初始化逻辑代码的地方
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("无参init方法");
	}
	
	
}
