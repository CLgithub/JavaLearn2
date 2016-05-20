package day11;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
session 技术
	4.1引入
		cookie的局限
			1）cookie只能存储字符串，不能存储对象
			2）只能存非中文
			3）1个cookie的容量不能超过4k
		
		如果要保存超过非字符串，超过4k内容，只能使用session技术

	session特点：
		会话数据保存在服务器端（内存）
	
	4.2session技术核心
		HttpSession类：用于保存会话信息
		1）创建或得到HttpSession对象
			HttpSession HttpServletRequest.getSession()  
			HttpSession HttpServletRequest.getSession(boolean create)  
		2）设置session对象
			void setMaxInactiveInterval(int interval) 		设置session有效时间
			void invalidate()								销毁session对象
			java.lang.String getId()						得到session编号
		3）保存会话数据到session对象
			void setAttribute(java.lang.String name, java.lang.Object value)	保存数据
			java.lang.Object getAttribute(java.lang.String name)			获取数据
			void removeAttribute(java.lang.String name)						清除数据
	
	4.3 session原理
		前提：在哪个session域对象存储数据，就应该在哪个域对象取出
		解读：HttpSession httpSession = req.getSession();
			1）会创建一个session对象，给session分配一个唯一的id，角叫JSESSIONID
				Set-Cookie:JSESSIONID=00AA0FC5951ECF24AF5805BBB189FB55; Path=/JavaLearn2/; HttpOnly
			2）把JSESSIONID作为cookie发送到浏览器保存
			3）第二次访问的时候，浏览器带着JSESSIONID的cookie来访问服务器
			4）服务器得到JSESSIONID，在服务器内存中找到是否有对应id的session对象
			5）如果有这个session对象，直接返回该session对象，如果找不到，就创建一个新的session对象，继续走1的流程
		结论：通过JSESSIONID在服务器找session对象
		
	4.4 session细节
		1）HttpSession.getId()	得到编号	其实就是JSESSIONID的值
		2)两个HttpServletRequest.getSession方法
			getSession(true)	等价与无参的，创建或得到session对象，没有匹配的session编号就创建，有匹配的session编号就返回
			getSession(false)	得到session对象，没有匹配的session编号，就返回null
		3） session销毁时间：
			（1）.默认时间：30分钟
			（2）.设置单个session的有效时间	httpSession.setMaxInactiveInterval(int inteval);	单位秒 s
			（3）.配置全局session有效时间	在web.xml中配置
				<session-config>
				  	<session-timeout>1</session-timeout>	单位分钟
				</session-config>
				
			（4）手动销毁session对象	session.invalidate();
			
	总结：
		会话管理：浏览器和服务器会话过程中产生的会话数据的管理
			cookie技术
			session技术
*/
public class Demo4Session1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//1.创建或得到session对象
		HttpSession httpSession = req.getSession();
		//得到sessionId
		System.out.println("JSESSIONID="+httpSession.getId());
		
		//设置session的有效时间
		httpSession.setMaxInactiveInterval(20);		//20s后过期
		
		//为了避免关掉浏览器后cookie失效，造成的不到session，可以手动发送一个cookie，设置有效时间
		Cookie cookie = new Cookie("JSESSIONID", httpSession.getId());
		cookie.setMaxAge(60*3);		//3分钟
		resp.addCookie(cookie);
		
		
		//2.保存数据到session对象中
		httpSession.setAttribute("name", "小明");
	}
	
}
