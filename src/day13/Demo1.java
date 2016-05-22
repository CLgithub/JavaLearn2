package day13;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day10_servlet_exercise.Dao;
import day7_sax.Contact;

/*
 jsp最佳实践
	servlet技术，开发动态资源，是一个java类，擅长写java代码
	jsp技术，开发动态资源，通过java代码，擅长输出html代码
	
	各取所长
	在web项目中涉及到逻辑
		1）接收参数					servlet
		2）处理业务逻辑，返回结果		servlet
		3）显示数据到浏览器			html
		4）跳转到其他页面			servlet
		
	servlet+jsp模式
		servlet
			1接收参数，
			2处理业务逻辑，
			3把结果保存到域对象
			4跳转页面
		jsp
			1从域对象中取出数据
			2显示数据到浏览器
			
	servlet的数据----》jsp页面	使用域对象
	

*/
public class Demo1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//处理业务逻辑，
		List<Contact> contacts = Dao.findAll();
		
		//2.把结果保存到域对象中		当多个域都可以时，建议使用最小范围的
		req.setAttribute("contacts", contacts);
		
		//3.跳转到显示jsp页面
		req.getRequestDispatcher("/page/day13/listContact.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
