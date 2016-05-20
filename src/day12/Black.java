package day12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Black extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String Cookie = req.getHeader("Cookie");
//		req.setSession();	//
//		req.setCookie();	//伪装成已经登陆的用户的cookie Cookie:JSESSIONID=1D7400C69C28A4CB0779E43959A11C2B
		
		this.getServletContext().getRequestDispatcher("/session4").forward(req, resp);		//转发
	}
}
