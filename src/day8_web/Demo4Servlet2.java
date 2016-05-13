package day8_web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
8 工具开发动态资源
	……			
	http://localhost:8090/JavaLearn2/hello2
*/
public class Demo4Servlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决中文乱码问题
		resp.setContentType("text/html;charset=utf-8");
		//向浏览器输出内容
		resp.getWriter().write("第二个servlet程序,当前时间为："+new Date());
	}
}
