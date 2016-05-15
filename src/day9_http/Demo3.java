package day9_http;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Text;

/*
4 Http响应
General
	Request URL:http://127.0.0.1:8090/JavaLearn2/Servlet3
	Request Method:GET
	Status Code:200 
	Remote Address:127.0.0.1:8087
响应：
	HTTP/1.1 200 OK 			--响应行
	Accept-Ranges:bytes			--响应头（key－value）
	Content-Length:300
	Content-Type:text/html
	Date:Sun, 15 May 2016 07:30:06 GMT
	Etag:W/"300-1463297405000"
	Last-Modified:Sun, 15 May 2016 07:30:05 GMT
	Server:Apache-Coyote/1.1
	
	aaabbb						--实体内容
	
4.1 响应行
	#http协议版本
	#状态码: 服务器处理请求的结果（状态）
	常见的状态：
		200 ：  表示请求处理完成并完美返回
		302：   表示请求需要进一步细化。
		404：   表示客户访问的资源找不到。
		500：   表示服务器的资源发送错误。（服务器内部错误）
		
4.2 常见的响应头
	Location: http://www.it315.org/index.jsp   -表示重定向的地址，该头和302的状态码一起使用。
	Server:apache tomcat                 ---表示服务器的类型
	Content-Encoding: gzip                 -- 表示服务器发送给浏览器的数据压缩类型
	Content-Length: 80                    --表示服务器发送给浏览器的数据长度
	Content-Language: zh-cn               --表示服务器支持的语言
	Content-Type: text/html; charset=GB2312   --表示服务器发送给浏览器的数据类型及内容编码
	Last-Modified: Tue, 11 Jul 2000 18:23:51 GMT  --表示服务器资源的最后修改时间
	Refresh: 1;url=http://www.it315.org     --表示定时刷新
	Content-Disposition: attachment; filename=aaa.zip --表示告诉浏览器以下载方式打开资源（下载文件时用到）
	Transfer-Encoding: chunked
	Set-Cookie:SS=Q0=5Lb_nQ; path=/search   --表示服务器发送给浏览器的cookie信息（会话管理用到）
	Expires: -1                           --表示通知浏览器不进行缓存
	Cache-Control: no-cache
	Pragma: no-cache
	Connection: close/Keep-Alive           --表示服务器和浏览器的连接状态。close：关闭连接 keep-alive:保存连接
	
	
4.3 HttpServletResponse对象
	HttpServletResponse对象修改响应信息：
		响应行： response.setStatus()  设置状态码
		响应头： response.setHeader("name","value")  设置响应头
		实体内容：
				response.getWriter().writer();   发送字符实体内容
				response.getOutputStream().writer()  发送字节实体内容 

*/
public class Demo3 extends HttpServlet{

	//1.tomcat服务器接收到浏览器发送的请求数据，且把响应信息封装到HttpServletResponse对象中
	//2.tocmat服务器调用doGet方法，然后把request和response对象传入到servlet中
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//完美解决编码问题
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		
//		method1(resp);
//		method2(resp);
//		method3(resp);
		method4(resp);
		//4.tomcat服务器把response对象的内容转换成响应格式内容，再发送给浏览器解析
	}
	
	/**
	 * content-Type的作用：告诉浏览器服务器饭送的数据类型及内容编码
	 * @param resp
	 * @author L
	 * @throws IOException 
	 * @date 2016年5月15日
	 */
	private void method4(HttpServletResponse resp) throws IOException {
		//设置响应的实体内容编码
//		resp.setCharacterEncoding("utf-8");
		
		
		
		
		//1.服务器发送给浏览器的数据类型
//		resp.setContentType("text/xml");	//发送xml
//		resp.setContentType("image/png");	//发送png图片
//		resp.setContentType("text/jpg");	//发送jpg图片
//		resp.setContentType("text/html");	//发送html
		
		//设置以下载的方式打开文件
//		resp.setHeader("content-Disposition", "attachment; filename=aaa.PNG");
		
		//2.发送内容
//		resp.getWriter().write("<script type='text/javascript'>alert('aacd');</script>");
		resp.getWriter().write("a有中文fdsaf");
//		resp.getOutputStream().write("有中文fdsa啊f".getBytes("gbk"));	//手动先将字符串转换为gbk的字节数组
		
		
//		ServletOutputStream outputStream = resp.getOutputStream();
//		FileInputStream fileInputStream=new FileInputStream("/Users/L/Downloads/aaa/img.PNG");
//		byte[] buf=new byte[1024];
//		int len=0;
//		while((len=fileInputStream.read(buf))!=-1){
//			outputStream.write(buf,0,len);
//		}
//		fileInputStream.close();
//		outputStream.close();
		///Users/L/Downloads/aaa
	}

	/**
	 * 需求：定时刷新
	 * @param resp
	 * @author L
	 * @date 2016年5月15日
	 */
	private void method3(HttpServletResponse resp) {
//		resp.setHeader("refresh", "1"); 	//每隔1秒刷新页面
		
		resp.setHeader("refresh", "5;/JavaLearn2／index.jsp");//隔5秒后跳转到某页
	}

	/**
	 * 需求：跳转主页index.html
	 * 使用请求重定向：发送一个302状态码＋location的响应头 
	 * @param resp
	 * @author L
	 * @throws IOException 
	 * @date 2016年5月15日
	 */
	private void method2(HttpServletResponse resp) throws IOException {
		//当浏览器收到302状态码时，会再次自带向服务器发送一个请求，请求的地址就是location的value的地址
//		resp.setStatus(302);
//		resp.setHeader("location", "/JavaLearn2／index.jsp");
		
		resp.sendRedirect("/JavaLearn2／index.jsp");		//发送重定向
		
	}
	

	
	private void method1(HttpServletResponse resp) throws IOException {
		//3.通过response对象改变响应信息
		//3.1响应行
//		resp.setStatus(404);		//修改状态码
//		resp.sendError(404);		//发送404错误页面
		//3.2响应头
		resp.setHeader("server", "JBoss");
		//3.3实体内容(浏览器直接能看到的内容)
//		resp.getWriter().write("aaabb"); 				//字符内容
		resp.getOutputStream().write("aaabbcc".getBytes());		//字节内容
	}
	
}
