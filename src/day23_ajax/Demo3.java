package day23_ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		ArrayList<String> nameList=new ArrayList<>();
		nameList.add("admin");
		nameList.add("aaa");
		nameList.add("bbb");
		nameList.add("小明");
		
		String uName = req.getParameter("name");
//		System.out.println(uName);
		if(nameList.contains(uName)){
			resp.getWriter().write("<font color='red'>用户名已经存在</font>");
//			req.setAttribute("msg", "用户名已经存在");
		}else {
			resp.getWriter().write("<font color='green'>可以使用</font>");
//			req.setAttribute("msg", "可以使用");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
