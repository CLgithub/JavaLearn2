package day10_servlet_exercise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day7_sax.Contact;

public class UpdateC extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		String id = req.getParameter("id");
		Contact contact = Dao.findById(id);
		// 显示出来
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(
				"<form action='/JavaLearn2/addC' method='post'>"
				+ "<table border='1'>"
				+ "<input type='hidden' name='id' value='"+contact.getId()+"'>"
				+ "<tr><td>姓名</td><td><input type='text' name='name' value='"+contact.getName()+"' ></td></tr>"
				+ "<tr><td>年龄</td><td><input type='text' name='age' value='"+contact.getAge()+"' ></td></tr>"
				+ "<tr><td>电话</td><td><input type='text' name='phone' value='"+contact.getPhone()+"' ></td></tr>"
				+ "<tr><td>邮箱</td><td><input type='text' name='email' value='"+contact.getEmail()+"' ></td></tr>"
				+ "<tr><td>qq</td><td><input type='text' name='qq' value='"+contact.getQq()+"' ></td></tr>"
				+ "<tr><td><input type='submit' value='保存'></td></tr>"
				+ "</table></form>"
		);
		resp.getWriter().write(sBuffer.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
