package day10_servlet_exercise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day7_sax.Contact;

public class AddC extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		Contact contact = new Contact();
		contact.setId(req.getParameter("id"));
		contact.setName(req.getParameter("name"));
		contact.setAge(req.getParameter("age"));
		contact.setPhone(req.getParameter("phone"));
		contact.setEmail(req.getParameter("email"));
		contact.setQq(req.getParameter("qq"));
		Dao.addOrUpdate(contact);
		
		resp.sendRedirect(req.getContextPath()+"/mainContact");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
