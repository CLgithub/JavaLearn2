package day24_servlet3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/servlet3_1","/servlet3_2"},
	initParams={@WebInitParam(name="name",value="aaa"),@WebInitParam(name="name2",value="bbb")})
public class Demo1_servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Demo1.doGet()");
		String value = this.getServletConfig().getInitParameter("name");
		String value2 = this.getServletConfig().getInitParameter("name2");
		System.out.println(value);
		System.out.println(value2);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
