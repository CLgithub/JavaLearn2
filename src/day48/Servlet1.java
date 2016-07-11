package day48;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/day48Servlet1")
public class Servlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		System.out.println("Servlet1.doGet()");
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("password"));
		
		Date date=new Date();
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataS = sDateFormat.format(date);
		PrintWriter pWriter = resp.getWriter();
		pWriter.write(dataS);
		pWriter.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		System.out.println("Servlet1.doPost()");
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("password"));
		
		Date date=new Date();
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataS = sDateFormat.format(date);
		PrintWriter pWriter = resp.getWriter();
		pWriter.write(dataS);
		pWriter.close();
	}
}
