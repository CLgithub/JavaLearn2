package day10_servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  
servlet核心4大对象：
	HttpServletRequest		请求对象：获取请求信息
	HttpServletResponse		相应对象：设置相应对象
	ServletConfig			servlet配置对象
	ServletContext			servlet上下文对象
  
 9.ServletConfig对象
 	9.1作用
 		servletConfig对象：主要是用于加载servlet的初始化参数
 	9.2对象的创建和得到
 		创建时机：在创建问servlet对象之后，在调用init方法之前创建
 		得到对象：直接从有参数的init方法中得到
 		
 	9.3 servlet的初始化参数配置
 		配置在web.xml文件中,放到servlet标签下
 		<init-param>
			<param-name>path</param-name>
			<param-value>E:/aaa/a.txt</param-value>
		</init-param>
		
 		注意： servlet的参数只能由当前的这个sevlet获取！！！！
		
		ServletConfig的API：
			java.lang.String getInitParameter(java.lang.String name)  根据参数名获取参数值
			java.util.Enumeration getInitParameterNames()    获取所有参数
		    ServletContext getServletContext()     得到servlet上下文对象
			java.lang.String getServletName()       得到servlet的名称

 		
*/
public class Demo4 extends HttpServlet{
//	private ServletConfig config;
	/*
	 <!-- 初始化参数配置,这些参数会在加载web应用的时候，
			封装到servletConfig对象中，通过init有参数的初始化方法传入servlet -->
		<init-param>
			<param-name>path</param-name>
			<param-value>E:/aaa/a.txt</param-value>
		</init-param>
	 */
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
////		this.config=config;
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
//		FileInputStream fileInputStream=new FileInputStream("/Users/L/Downloads/aaa/aa");
//		byte[] buf=new byte[1024];
//		int len=0;
//		while((len=fileInputStream.read(buf))!=-1){
////			System.out.println(Arrays.toString(buf));
//			System.out.println(new String(buf,0,len));
//		}
//		System.out.println("----------------");
//		BufferedReader bReader=new BufferedReader(new FileReader("/Users/L/Downloads/aaa/aa"));
//		String string=null;
//		while((string=bReader.readLine())!=null){
//			System.out.println(string);
//		}
		
		ServletConfig config = this.getServletConfig();//不用自己维护config，父类已经维护并且已经维权赋值
		
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			System.out.println(name+"="+config.getInitParameter(name));
		}
		System.out.println("servletName="+config.getServletName());
		
	}
}
