package day21;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3Servlet1 extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");	//解决方案一：设置request编码集为utf－8
		
		String msg1 = req.getParameter("msg1");
		String msg2 = req.getParameter("msg2");
		System.out.println(msg1);
		System.out.println(msg2);

	}
}
