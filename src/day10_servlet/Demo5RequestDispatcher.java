package day10_servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
10.3.4	RequestDispatcher getRequestDispatcher(java.lang.String path)   --转发（类似于重定向）
	
	转发和重定向的区别。
		1）转发
			a.地址栏不会变
			b.只转发到当前 web应用内的资源
			c.能将数据保存到HttpServletRequest中
		2）重定向
			a.地址栏会改变，变成了重定向的地址
			b.可以跳转到当前web应用，其他web应用， 或外部域名
			c.不能将数据保存HttpServletRequest中
			
		转发其实是将这次（请求\响应）交给另外的其他资源去处理，地址栏不变
		而重定向相当于重新在地址栏输入地址访问（响应个302，然后重新请求）
		
		如果要使用request域对象进行数据共享，只能用转发技术
*/
//转发
public class Demo5RequestDispatcher extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//转发前保存数据到HttpServletRequest对象
		req.setAttribute("data1", "abc");
		
//		RequestDispatcher rDispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");	//a 地址栏不变
//		rDispatcher.forward(req, resp);
//																										//b.只转发到当前 web应用内的资源
		
		RequestDispatcher rDispatcher = this.getServletContext().getRequestDispatcher("/Servlet11");	
//		rDispatcher.include(req, resp);
		rDispatcher.forward(req, resp);
	}
	
}
