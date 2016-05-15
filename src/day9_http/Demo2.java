package day9_http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
3.8 传递的请求参数如何获取		
	 GET方式： 参数放在URI后面
	 POST方式： 参数放在实体内容中

	获取GET方式参数：
			request.getQueryString();
	获取POST方式参数：
			request.getInputStream();
			
	问题：但是以上两种不通用，而且获取到的参数还需要进一步地解析。
	所以可以使用统一方便的获取参数的方式：
	 	核心的API：
		request.getParameter("参数名");  根据参数名获取参数值（注意，只能获取一个值的参数）
		request.getParameterNames();   获取所有参数名称列表  
		request.getParameterValue("参数名“)；根据参数名获取参数值（可以获取多个值的参数）

		
*/
public class Demo2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收git方式提交的参数
//		System.out.println("get方式："+req.getQueryString());
		
		method1(req);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收post方式提交的参数
//		ServletInputStream inputStream = req.getInputStream();
//		byte[] buf=new byte[1024];
//		int len=0;
//		while((len=inputStream.read(buf))!=-1){
//			System.out.println("post方式："+new String(buf,0,len));
//		}
		
		method1(req);
		
		//调用doGet方法
//		this.doGet(req, resp);
	}
	
	//统一方便的获取请求参数
	private void method1(HttpServletRequest req) throws UnsupportedEncodingException {
		//设置getParameter解码时查询的码表 
		//只设置了post的，因为该方法只能对请求实体内容的数据编码起作用，post的提交数据在实体内容里，而got的在uri后面
		req.setCharacterEncoding("utf-8");		//统一设置解决编码问题
		
		System.out.println("请求方式："+req.getMethod());
		//统一方便的获取请求参数
		String name = req.getParameter("name");			//根据参数名字查找	，但是只能获取一个值
//		name=new String(name.getBytes("iso-8859-1"),"utf-8");	手动解决编码问题
		String password=req.getParameter("password");
		System.out.println("name="+name);
		System.out.println("password="+password);
		
		System.out.println("---------------------------");
		Enumeration<String> enumeration = req.getParameterNames();
		while(enumeration.hasMoreElements()){
			String name1 = enumeration.nextElement();
			if(!"hobit".equals(name1)){
				System.out.println(name1+"="+req.getParameter(name1));
			}
		}
		
		String[] hobits = req.getParameterValues("hobit");		//获取同一名字的多个值
		System.out.println("hobit="+Arrays.toString(hobits));
		
	}
	
}
