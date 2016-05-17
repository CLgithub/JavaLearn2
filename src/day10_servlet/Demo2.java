package day10_servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*

4,servlet的生命周期（重点）
	4.1引入
		servlet的生命周期，servlet对象什么时候创建，什么时候调用什么方法，什么时候销毁
		
		servlet程序的生命周期由tomcat服务器控制的
		
	4.2	servlet重要的四个生命周期方法
		默认情况下：第一次访问servlet的时候调用构造方法创建servlet对象，				构造方法
			只调用一次，证明时servlet对象在tomcat服务器中时单例的
		创建完成后调用init方法初始化												init方法
		每次发送请求的时候调用service方法为请求服务									service方法
		当停止服务器或重新部署web应用的时候，销毁servlet对象的时候调用destroy方法			destroy方法
		
	4.3 用伪代码来演示生命周期
		(1)通过映射查找到了servlet－class的内容，字符串：day10_servlet.Demo2
		(2)通过反射构造firstServlet对象
			2.1得到字节码对象
				Class clazz1=class.forName();
			2.2调用函数的构造方法构造对象
				Object obj=clazz1.newInstance		--1.构造方法被调用
		(3) 通过反射调用init方法
			3.1得到方法对象
				Method initMethod=clazz1.getDeclareMethod("init",ServletConfig.class);
			3.2调用该方法
				initMethod.invoke(obj,config);			--2.init方法被调用
		(4) 通过反射调用service方法
			4.1得到方法对象
				Method serviceMethod=clazz1.getDeclareMethod("service",HttpServletRequest.class,HttpServletResponse.class);
			4.2调用该方法
				serviceMethod.invoke(obj,request,response);		--3.service方法被调用
		(5) 当停止服务器或重新部署web应用的时候，通过反射调用destroy方法
			5.1得到方法对象
				Method destroyMethod=clazz1.getDeclareMethod("destroy");
			5.2调用该方法
				destroyMethod.invoke(obj)					--destroy方法被调用
				
5.servlet的自动加载
	默认情况下。第一次访问servlet的时候创建servlet对象，如果servlet的构造方法或init方法中执行啦比较多的逻辑代码，那么会导致
		用户第一次访问servlet的时候比较慢
	
	改变servlet创建对象的时间：提前到加载web应用的时候
	在servlet的配置中加上一个<load-on-startup>1</load-on-startup>即可
	
			
		
				
		
		
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
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		System.out.println("3_1.调用service方法");
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
