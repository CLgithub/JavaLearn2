package day19_2_listener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import day19_2_listener.demo.User;

/*
演示监听属性变化
	演示监听session的属性变化（MySessionAttributeListener）
 */
public class MySessionAttributeListenerTestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		System.out.println("MySessionAttributeListenerTestServlet.doGet()");
		
		HttpSession session = req.getSession();

		//测试session属性变化监听器SessionAttributeListener
//		session.setAttribute("name", "aaa");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		session.setAttribute("name", "bbb");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		session.removeAttribute("name");
		
		//测试HttpSessionBindingListener
		User user = new User();
		user.setName("王小明");
		session.setAttribute("user", user);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
