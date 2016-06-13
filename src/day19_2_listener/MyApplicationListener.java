package day19_2_listener;

import java.io.IOException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
问题：现在学习的是javaweb，那么javaweb中有什么监听器，有什么作用
	javaweb中的监听器，主要用于监听javaweb中的常用对象（request（HpptServletRequest），session（HttpSession），application（ServletContext））的三种类型操作
		1.对象的创建与销毁
			HttpServletRequest
				监听器：ServletRequestListener可以监听request对象的创建与销毁
			HttpSession
				监听器：HttpSessionListener可以监听session对象的创建与销毁
			ServletContext
				监听器：ServletContextListener可以监听application对象的创建与销毁
		2.对象的属性变化
			HttpServletRequest
				监听器：ServletRequestAttributeListener	监听request对象属性的变化
			HttpSession
				监听器：HttpSessionAttributeListener	监听session对象属性的变化
			ServletContext
				监听器：ServletContextAttributeListener 监听application对象属性的变化
		3.session绑定javaBean
			1.HttpSessionBindingListener
				这个监听器，可以让JavaBean对象，感知他被绑定到session中或从session中移除。
			2.HttpSessionAttributeListener
				这个监听器，可以让javaBean对象，感知被钝化或活化
					（服务器正常关闭时，session会被保存到文件里？）
					钝化：内存--》硬盘，活化：硬盘---》内存
			这两个监听器都由javaBean实现，并且都不用配置
	在javaweb中servlet规范中定义了三种技术 servlet、Listener、Filter

演示关于web中的监听器怎么使用
	创建监听器的步骤
		1.创建一个类，去实现指定的监听器接口
		2.重写接口中方法
		3.在web.xml文件中配置注册监听
		演示：
			1.监听application对象的创建与销毁
				web应用启动的时候创建，web应用关闭时销毁
			2.监听session对象的创建与销毁
				session对象创建：
					request.getSession():它是用于获取session
					是否创建，分以下几种情况：
						1.请求中如果没有jsessionid，那么就是创建session对象
						2.如果请求中有jsessionid值：
							1.如果在服务器端，有一个session的id与其一样，不创建，直接使用
							2.没有这个session的id值，就创建
				session对象销毁：
					1.默认超时	30m
					2.设置超时时间
					3.HttpSession.invalidate()手动销毁
					4.web应用关闭
			3.监听request对象的创建与销毁
				请求发生时创建
				响应产生时销毁
演示监听属性变化
	演示监听session的属性变化（MySessionAttributeListener）

思考：在监听器中能拿到属性值吗
	常识：在java的监听机制中，是可以在监听器中获取事件源的
	我们在开发中，如果遇到事件触发机制，那么一般情况下，都可以使用方法的参数（事件对象）来获取想要的信息
				
问题：这些监听器在web开发中有什么用
	在主流中应用比较少，但是可以完成一些性能监测操作
	
	
*/
public class MyApplicationListener implements ServletContextListener{

	//创建
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContext对象创建");
	}
	
	//销毁
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext对象销毁");
	}
	
}
