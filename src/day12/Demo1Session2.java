package day12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
	用户主页
 */
public class Demo1Session2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
	
		HttpSession session = req.getSession();
		
		System.out.println(session.getId());
		User user = (User) session.getAttribute("user");
		if(user==null){
			//没有登陆	重定向到登陆页面
//			resp.sendRedirect(req.getContextPath()+"/page/day12/login.html");
			resp.getWriter().write("对不起，当前没有登陆,<br><a href='"+req.getContextPath()+"/page/day12/login.html'>到达登陆页面</a>");
		}else {
			PrintWriter writer = resp.getWriter();
			StringBuffer html=new StringBuffer();
			html.append("<html><body>欢迎回来，"+user.getUserName()+"，<a href='"+req.getContextPath()+"/session5'>退出</a></body></html>");
			
			writer.write(html.toString());
		}
		
	}
	
	
}
