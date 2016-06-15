package day21;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo5LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");

		String loginName = req.getParameter("loginName");
		String password = req.getParameter("password");
		if ("aaa".equals(loginName) && "123".equals(password)) {
			System.out.println("登录成功");
			User user = new User("aaa", "123");
			req.getSession().setAttribute("user", user);
			if(user!=null){
				Cookie name=new Cookie("userName", user.getLoginName());
				Cookie pass=new Cookie("pass", user.getPassword());

				String rememberMe = req.getParameter("rememberMe");
				boolean b = Boolean.parseBoolean(rememberMe);
				if(b){
					name.setMaxAge(60*60*24); 		//一周有效
					pass.setMaxAge(60*60*24); 		//一周有效
				}else{
					name.setMaxAge(0); 		//一周有效
					pass.setMaxAge(0); 		//一周有效
				}
				name.setPath("/JavaLearn2");
				pass.setPath("/JavaLearn2");
				resp.addCookie(name);
				resp.addCookie(pass);
			}
			
			resp.sendRedirect(req.getContextPath() + "/page/day21/mainPage.jsp");
		} else {
			System.out.println("登录失败");
			req.getSession().removeAttribute("user");
			resp.sendRedirect(req.getContextPath() + "/page/day21/Demo5AutoLogin.jsp");
		}

	}
	
	private void remeber(HttpServletResponse resp, User user) {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
