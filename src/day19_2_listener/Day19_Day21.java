package day19_2_listener;

/*

javaweb中servlet规范中定义了三种技术：servlet	 listener filter总结

	listener监听器：
		问题：什么是监听器，监听器有什么作用
			监听机制4个要素：
				1.事件源
				2.事件
				3.监听器
				4.注册监听
		监听器就是可以监听某个事物在执行一个特定操作时，我们可以让其触发一个操作
		可以在满足特定条件的情况下执行一段操作
		
		javaweb中的监听器，主要用于监听javaweb中的常用对象（request（HpptServletRequest），session（HttpSession），application（ServletContext））的三种类型操作
			1.对象的创建与销毁
				HttpServletRequest
					监听器：ServletRequestListener接口，可以监听request对象的创建与销毁
				HttpSession
					监听器：HttpSessionListener接口，可以监听session对象的创建与销毁
				ServletContext
					监听器：ServletContextListener接口，可以监听application对象的创建与销毁
			2.对象的属性变化
				HttpServletRequest
					监听器：ServletRequestAttributeListener接口	监听request对象属性的变化
				HttpSession
					监听器：HttpSessionAttributeListener接口	监听session对象属性的变化
				ServletContext
					监听器：ServletContextAttributeListener接口 监听application对象属性的变化
			3.session绑定javaBean
				1.HttpSessionBindingListener
					这个监听器，可以让JavaBean对象，感知他被绑定到session中或从session中移除。
				2.HttpSessionActivationListener
					这个监听器，可以让javaBean对象，感知被钝化或活化
						（服务器正常关闭时，session会被保存到文件里？）
						钝化：内存--》硬盘，活化：硬盘---》内存
					使用：需要创建一个配置文件context.xml
						这个配置文件保持到META-INF目录下（和配置tomcat链接池一样）
						<?xml version="1.0" encoding="UTF-8"?>
						<Context>
							<Manager className="org.apache.catalina.session.PersistentManager"
								maxIdleSwap="1">
								<Store className="org.apache.catalina.session.FileStore"
									directory="cltest" />
							</Manager>
						</Context>
				这两个监听器都由javaBean实现，并且都不用配置
		创建监听器的步骤：
			1.创建一个类，去实现指定的监听器接口
			2.重写接口中方法
			3.在web.xml文件中配置注册监听


*/
public class Day19_Day21 {

}
