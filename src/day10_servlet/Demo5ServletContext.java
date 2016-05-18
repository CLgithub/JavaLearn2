package day10_servlet;

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

	

*/
public class Demo5ServletContext {

}
