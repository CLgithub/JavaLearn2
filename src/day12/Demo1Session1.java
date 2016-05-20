package day12;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
	session练习：
		用户登陆
*/
public class Demo1Session1 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//接收参数
		String userNmae = req.getParameter("userName");
		String password = req.getParameter("password");
		
		User user = new User("aa", "123456");
		//2.判断
		if(user.getUserName().equals(userNmae)&&user.getPassword().equals(password)){
			//登陆成功	将用户对象保存到session 并转发或重定向到
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
//			this.getServletContext().getRequestDispatcher("/session4").forward(req, resp);		//转发
			resp.sendRedirect(req.getContextPath()+"/session4");		//重定向
		}else {
			//登陆失败	用请求重定向到失败页面
			resp.sendRedirect(req.getContextPath()+"/page/day12/fail.html");
		}
	}
}

class User{
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
}
