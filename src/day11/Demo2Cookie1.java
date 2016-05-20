package day11;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
会话引入：
	web中的一次会话：
		打开浏览器－－－》访问服务器内容－－－》关闭浏览器
		打开浏览器－－－》浏览登陆页面－－－》输入用户名密码－－－》访问到用户主页
		在此处登陆会话过程中，产生的数据（用户会话数据）如何保存下来呢？
		购物场景会话
		问题：在会话工程中，如何保存这些信息
		
	会话管理：管理浏览器客户端和服务器之间会话过程中产生的数据
		域对象：实现资源之间的数据共享
			现在学的	httpRequest、servletContext
			四大域对象		1.servletContext 2.ttpSession 3.httpResquest 4.PageContext
	可以使用session域对象来保存会话数据
	
会话技术：
	Cookie技术：会话数据保存在浏览器客户端
	Session技术：会话数据保存在服务器端
	
	1.1.Cookie技术
		特点：会话数据保存在浏览器客户端
		核心技术：cookie类，用于存储会话数据的类
			1)构造对象：
				Cookie(java.lang.String name, java.lang.String value)
			2）设置cookie
				void setPath(java.lang.String uri)			设置cookie的有效访问路径
				void setMaxAge(int expiry)					设置cookie的有效时间
				void setValue(java.lang.String newValue)	设置cookie的值
			3）要发送cookie到浏览器端保存
				void response.addCookie(Cookie cookie)		发送cookie
			4）服务器接收cookie
				Cookie[] request.getCookies()				接收cookie
			
	1.2，cookie原理
		1）服务器创建cookie对象，把会话保存到cookie对象中
			Cookie cookie1 = new Cookie("cookieName1", "test1");
		2）服务器发送cookie对象到浏览器
			resp.addCookie(cookie1);	响应头里
		3）浏览器收到服务器发送的cookie，然后保存到浏览器端
		4）浏览器下次访问服务器是，会带着cookie信息
			请求头里
		5）服务器接收到浏览器带来的cookie信息
			Cookie[] cookies = req.getCookies();
		
	1.3	cookie的细节
		1）void setPath(java.lang.String uri) ：设置cookie的有效路径。有效路径指的是cookie的有效路径设置在
			哪里，那么浏览器在访访问服务器该域（localhost）的有效路径（/JavaLearn2）时就才会带着cookie信息，否则则不带cookie信息
		2)void setMaxAge(int expiry) ： 设置cookie的有效时间。
			正整数：表示cookie数据保存在浏览器缓存目录（硬盘），数值表示保存的时间
			负数：表示cookie数据保存在浏览器内存中，浏览器退出cookie就丢失
			0；删除同名的cookie数据
		3)cookie数据类型只能时非字符串，可以保存多个cookie，
			但是浏览器一般只允许存放300个Cookie，每个站点最多存放20个Cookie，每个Cookie的大小限制为4KB。
		
*/
public class Demo2Cookie1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.创建cookie对象
		Cookie cookie1 = new Cookie("cookieName1", "test1");
		Cookie cookie2 = new Cookie("cookieName2", "test2");
		
		//设置cookie的有效路径。默认情况：有效路径在当前web应用下		 /JavaLearn2
//		cookie1.setPath("/JavaLearn2/Servlet13");
		cookie1.setPath("/JavaLearn2");
		cookie2.setPath("/pathTest");
		
		//设置cookie的有效时间
//		cookie1.setMaxAge(20);		//20s
		cookie1.setMaxAge(-1);		//保存在内存，直到浏览器退出	（会话cookie）	默认情况
		cookie1.setMaxAge(0);		//删除cookie1同名cookie
		
		//2.把cookie数据发送到浏览器(通过响应头发送：set-cookie名称)
//		resp.setHeader("Set-Cookie", cookie1.getName()+"="+cookie1.getValue());
		//推荐使用下面这种方式，不用手动拼接
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		
		//3.接收浏览器发送的cookie信息
//		String cookieInfo = req.getHeader("Cookie");
//		System.out.println(cookieInfo);
		Cookie[] cookies = req.getCookies();
		if(null!=cookies){
			for(Cookie cookie:cookies){
				System.out.println(cookie.getName()+"="+cookie.getValue());
			}
		}else{
			System.out.println("没有接收到cookie");
		}
	}
	
}
