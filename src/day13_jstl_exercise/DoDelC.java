package day13_jstl_exercise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class DoDelC extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String id = req.getParameter("id");
		ContactDao.deleteC(id);
		
		resp.sendRedirect(req.getContextPath()+"/jstlServlet1");
	}
}
