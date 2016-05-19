package day11;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	web应用中路径问题
*/
public class Demo1Path extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//目标：target.html
		/*目标资源是给谁使用的：
		 * 		1.给服务器:	/	表示在当前web应用的根目录（webRoot下）
		 * 		2.给浏览器	/	表示在webapps的根目录
		 */
		
		//1.转发
//		req.getRequestDispatcher("/page/day11/target.html").forward(req, resp);
		
		//2.请求重定向
//		resp.sendRedirect(req.getContextPath()+"/page/day11/target.html");
//		
//		//3.html页面的超链接
//		resp.getWriter().write("<a href='"+req.getContextPath()+"/page/day11/target.html'>超链接</a>");
//		
//		//4.html页面中的form提交地址
//		resp.getWriter().write("<form action='"+req.getContextPath()+"/page/day11/target.html'><input type='submit'/></form>");
		
		//5.加载资源文件
		Properties properties=new Properties();
//		properties.load(this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties"));
//		properties.load(new FileInputStream(this.getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
		properties.load(this.getClass().getResourceAsStream("/db.properties"));	//类路径

		String user = properties.getProperty("userName");
		String password = properties.getProperty("password");
		
		System.out.println("user="+user);
		System.out.println("password="+password);
	}
}
