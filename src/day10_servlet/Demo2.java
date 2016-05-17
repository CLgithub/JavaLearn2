package day10_servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

4,servlet的生命周期（重点）
	4.1引入
		servlet的生命周期，servlet对象什么时候创建，什么时候调用什么方法，什么时候销毁
		
		servlet程序的生命周期由tomcat服务器控制的
		
	4.2	servlet重要的生命周期方法
		第一次访问servlet的时候调用构造方法创建servlet对象，							构造方法
		创建完成后调用init方法初始化												init方法
		每次发送请求的时候调用service方法为请求服务									service方法
		停止服务器或重新部署web应用的时候，销毁servlet对象的时候调用destroy方法			destroy方法
		
		
*/
public class Demo2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		resp.getWriter().write("fdsafFDSFdfa放假快乐；及");
	}
	
	/**
	 * 1.创建时调用改方法
	 */
	public Demo2() {
		System.out.println("1.创建时调用改方法构造方法");
	}
	
	/**
	 * 2.初始化方法
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("2.调用初始化init方法");
	}

	/**
	 * 3.调用service方法
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		System.out.println("3.调用service方法");
	}
	
	/**
	 * 4.销毁时调用destroy
	 */
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("4.销毁时调用destroy");
	}
	
	
}
