package day9_http;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//2 Http协议入门
//	2.1 什么是http协议
//		http协议：对浏览器和服务器端之间数据传输的规范
//		
//		一个请求一定有且仅有一个响应
//		
//		2.2 查看http协议的工具
//				1）使用火狐的firebug插件（右键->firebug->网络）
//				2）使用谷歌的“审查元素”
//	
//3 Http请求
//		http协议内容
//		general		全体的
//			Request URL:http://127.0.0.1:8090/JavaLearn2/hello2
//			Request Method:GET
//			Status Code:200 
//			Remote Address:127.0.0.1:8087
//		请求
//			GET /day09/hello HTTP/1.1			－－请求行
//			Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8		--请求头（多个key-value对象）
//			Accept-Encoding:gzip, deflate, sdch
//			Accept-Language:zh-CN,zh;q=0.8
//			Cache-Control:max-age=0
//			Connection:keep-alive
//			Cookie:JSESSIONID=8F4B135677C87750F9261EE83B7A5F3B
//			Host:127.0.0.1:8090
//			Upgrade-Insecure-Requests:1
//			User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36
//													--一个空行
//			name=eric&password=123456             	--（可选）实体内容

//		响应	
//			Content-Length:69
//			Content-Type:text/html;charset=utf-8
//			Date:Sun, 15 May 2016 06:25:11 GMT
//			Server:Apache-Coyote/1.1

/*
		3.1 请求行
			GET /day09/hello HTTP/1.1   
			#http协议版本
				http1.0：当前浏览器客户端与服务器端建立连接之后，只能发送一次请求，一次请求之后连接关闭。
				http1.1：当前浏览器客户端与服务器端建立连接之后，可以在一次连接中发送多次请求。（基本都使用1.1）
			#请求资源
				URL:  统一资源定位符。http://localhost:8080/day09/testImg.html。只能定位互联网资源。是URI	的子集。
				URI： 统一资源标记符。/day09/hello。用于标记任何资源。可以是本地文件系统，局域网的资源（//192.168.14.10/myweb/index.html），可以是互联网。
			
			#请求方式
				常见的请求方式： GET 、 POST、 HEAD、 TRACE、 PUT、 CONNECT 、DELETE	
				常用的请求方式： GET  和 POST
				表单提交：
				<form action="提交地址" method="GET/POST">	
				<form>
				
				GET   vs  POST 区别
				1）GET方式提交 
					a）地址栏（URI）会跟上参数数据。以?开头，多个参数之间以&分割。
					b）GET提交参数数据有限制，不超过1KB。
					c）GET方式不适合提交敏感密码。
					d）注意： 浏览器直接访问的请求，默认提交方式是GET方式
				2）POST方式提交
					a）参数不会跟着URI后面。参数而是跟在请求的实体内容中。没有？开头，多个参数之间以&分割。
					b）POST提交的参数数据没有限制。
					c）POST方式提交敏感数据。
				
		3.2 请求头
			Accept: text/html,image/*      -- 浏览器接受的数据类型
			Accept-Charset: ISO-8859-1     -- 浏览器接受的编码格式
			Accept-Encoding: gzip,compress  --浏览器接受的数据压缩格式
			Accept-Language: en-us,zh-       --浏览器接受的语言
			Host: www.it315.org:80          --（必须的）当前请求访问的目标地址（主机:端口）
			If-Modified-Since: Tue, 11 Jul 2000 18:23:51 GMT  --浏览器最后的缓存时间
			Referer: http://www.it315.org/index.jsp      -- 当前请求来自于哪里
			User-Agent: Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)  --浏览器类型
			Cookie:name=eric                     -- 浏览器保存的cookie信息
			Connection: close/Keep-Alive            -- 浏览器跟服务器连接状态。close: 连接关闭  keep-alive：保存连接。
			Date: Tue, 11 Jul 2000 18:23:51 GMT      -- 请求发出的时间
			
		3.3 实体内容
			只有POST提交的参数会放到实体内容中
			
		3.4 HttpServletRequest对象
		HttpServletRequest对象作用是用于获取请求数据。
		   核心的API：
			请求行： 
				request.getMethod();   请求方式
				request.getRequetURI()   / request.getRequetURL()   请求资源
				request.getProtocol()   请求http协议版本
			请求头：
				request.getHeader("名称")   根据请求头获取请求值
				request.getHeaderNames()    获取所有的请求头名称 其实不全

			实体内容:
				request.getInputStream()   获取实体内容数据
				
				

*/
		


public class Deom1 extends HttpServlet{

	//1.tomcat服务器接收到浏览器发送的请求数据，任何封装到HttpServletRequest对象
	//2.tocmat服务器调用doGet方法，然后把request对象传入到servlet中
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("aaabbb");
		//3.从request对象取出请求数据。
		
		//3.1请求行 （GET /day09/hello HTTP/1.1）
//		t1(req);
		
		//3.2请求头
//		t2(req);

	}
	
	//接收post提交的请求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//3.3请求的实体内容
		ServletInputStream inputStream = req.getInputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=inputStream.read(buf))!=-1){
			System.out.println("实体内容："+new String(buf,0,len));
		}
	}

	/**
	 * 得到请求头
	 * @param req
	 * @author L
	 * @date 2016年5月15日
	 */
	private void t2(HttpServletRequest req) {
		System.out.println("Host："+req.getHeader("Host"));	//根据头名称得到头内容
		
		Enumeration<String> headerNames = req.getHeaderNames();		//得到所有的请求头名称列表	(得到个迭代器)
		System.out.println("客户端ip："+req.getRemoteHost());
		while(headerNames.hasMoreElements()){
			String name = headerNames.nextElement();
			System.out.println(name+":"+req.getHeader(name));
		}
	}

	/**
	 * 得到请求行
	 * @param req
	 * @author L
	 * @date 2016年5月15日
	 */
	private void t1(HttpServletRequest req) {
		System.out.println("请求方式："+req.getMethod());
		System.out.println("统一资源标记付URI："+req.getRequestURI());		//统一资源标记付
		System.out.println("统一资源定位付URL："+req.getRequestURL());		//统一资源定位付
		System.out.println("请求协议："+req.getProtocol());
	}
	
}
