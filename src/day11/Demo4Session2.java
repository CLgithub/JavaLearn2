package day11;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
	从域对象session中取出数据
*/
public class Demo4Session2 extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		HttpSession session = req.getSession(false);
		if(session==null){
			System.out.println("没有对应的session");
		}else {
			System.out.println("JSESSIONID="+session.getId()); 
			String name = (String)session.getAttribute("name");
			System.out.println(name);
//			session.invalidate();	//销毁session
		}
	}

}
