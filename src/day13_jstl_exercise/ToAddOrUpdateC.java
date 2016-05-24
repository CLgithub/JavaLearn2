package day13_jstl_exercise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day7_sax.Contact;

public class ToAddOrUpdateC extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		Contact contact=null;
		String id = req.getParameter("id");
		if(null!=id){
			contact = ContactDao.findById(id);
		}
		req.setAttribute("contact", contact);
		
//		resp.sendRedirect(req.getContextPath()+"/page/day13_jstl_exercise/addorUpdateC.jsp");
		req.getRequestDispatcher("/page/day13_jstl_exercise/addorUpdateC.jsp").forward(req, resp);
	}
}
