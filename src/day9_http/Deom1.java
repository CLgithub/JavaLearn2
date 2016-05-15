package day9_http;



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
				
				
				

*/
		


public class Deom1 {

}
