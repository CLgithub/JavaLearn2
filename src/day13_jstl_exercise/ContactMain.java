package day13_jstl_exercise;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day7_sax.Contact;

public class ContactMain extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//业务处理
		List<Contact> list = ContactDao.findAll();
		//存储数据到域对象
		req.setAttribute("list", list);
		//跳转到目标页面
		req.getRequestDispatcher("/page/day13_jstl_exercise/contactList.jsp").forward(req, resp);
	}
	
}
