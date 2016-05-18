package day10_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//重定向
public class Demo5Redirect extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//重定向前保存数据到HttpServletRequest对象
		req.setAttribute("data1", "abc");
		
//		resp.sendRedirect(this.getServletContext().getContextPath()+"/index.jsp");	//a,地址栏会改变
//		resp.sendRedirect("https://www.google.com.hk");								//b.可以跳转到当前web应用，其他web应用， 或外部域名
		
		resp.sendRedirect(this.getServletContext().getContextPath()+"/Servlet11");
	}
}
