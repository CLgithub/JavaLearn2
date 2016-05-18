package day10_servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
10.ServletContext对象
	10.1 servletContext对象，叫做servlet的上下文对象。
		表示一个当前的web应用环境，
		一个servlet环境封装到一个servletconfig对象
		整个web应用的环境（web.xml）都封装到了servletContext对象中
		一个web应用中只有一个servletContext对象，多个servletConfig对象（一个servletConfig对应一个servlet）
	
	10.2 对象的创建的得到
		创建时机：加载当前web应用时创建ServletContext对象
		得到对象：从servletConfig的getServletContext方法得到
			为什么要在servletConfig的方法去得到
			我们的设计：方案一：
				创建ServletContext对象
				创建ServletConfig对象
				public void init( ServletConfig config，ServletContext context ){  多了一个参数
					得到ServletConfig对象
					得到ServletContext对象；
				}
			Sun公司设计：将ServletContext对象放到ServletConfig对象中
				创建ServletContext对象	ServletContext context = new ServletContext()
				创建ServletConfig对象	ServetConfig config = new ServletConfig();
										config.setServletContxt(context);
				class ServletConfig{
					ServletContext context;
					pubilc ServletContext getServletContext(){
						return context;
					}
				}
				public void init( ServletConfig config){  多了一个参数
					得到ServletConfig对象
					config.getServletContext得到servletContext对象
				}
	
	10.3 ServletContext对象的核心API(作用)
		java.lang.String getContextPath()   --得到当前web应用的路径
	
		java.lang.String getInitParameter(java.lang.String name)  	--得到当前web应用的初始化参数
		java.util.Enumeration getInitParameterNames()  
	
		void setAttribute(java.lang.String name, java.lang.Object object) --和域对象有关的方法
		java.lang.Object getAttribute(java.lang.String name)  
		void removeAttribute(java.lang.String name)  
	
		RequestDispatcher getRequestDispatcher(java.lang.String path)   --转发（类似于重定向）
	
		java.lang.String getRealPath(java.lang.String path)    --得到web应用的资源
		java.io.InputStream getResourceAsStream(java.lang.String path) 

	10.3.1 	java.lang.String getContextPath()   --得到当前web应用的路径
	10.3.2 	java.lang.String getInitParameter(java.lang.String name)  	--得到当前web应用的初始化参数（全局）
			java.util.Enumeration getInitParameterNames()  
			web应用参数可以让当前web应用的所有servlet获取
			
	
	10.3.4	RequestDispatcher getRequestDispatcher(java.lang.String path)   --转发（类似于重定向）
	
	转发和重定向的区别。
		1）转发
			地址栏不会变
			只转发到当前 web应用内的资源
		2）重定向
			地址栏会改变，变成了重定向的地址
			可以跳转到当前web应用，其他web应用， 或外部域名
		
	
*/
public class Demo5ServletContext extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//0.得到上下文对象servletContext
		ServletContext servletContext = this.getServletConfig().getServletContext();
		ServletContext servletContext2 = this.getServletContext();//第二种写法，看源码，其实也是通过上面的方法得到的getServletConfig().getServletContext()
		
		//1.得到web应用路径	web应用路径：部署到tomcat服务器上运行的web应用的名称
		String contextPath = servletContext.getContextPath();
		System.out.println("web应用的路径："+contextPath);		//web应用的路径：/JavaLearn2
		//应用到请求重定向
//		resp.sendRedirect(contextPath+"/index.jsp");
		
		//2.得到web应用参数
		Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
		while(initParameterNames.hasMoreElements()){
			String parameterName = initParameterNames.nextElement();
			System.out.println("web应用参数:"+parameterName+"="+servletContext.getInitParameter(parameterName));
		}
		
		//3.和域对象有关的方法
			//将数据共享给servlet11
		servletContext.setAttribute("student1", new Student(1, "小明", 23));
		
		//4.转发（类似于重定向）,效果：跳转页面
		RequestDispatcher rDispatcher = servletContext.getRequestDispatcher("/index.jsp");
		rDispatcher.forward(req, resp);
		//请求重定向
//		resp.sendRedirect(contextPath+"/index.jsp");
		//转发和重定向的区别。转发时地址栏不会变，cong
		
	}
}

