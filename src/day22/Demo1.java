package day22;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream inputStream = req.getInputStream();
		byte[] buf=new byte[1024];
		int i=0;
		while((i=inputStream.read(buf))!=-1){
			String str=new String(buf,0,i);
			System.out.println(str);
		}
		
//		String fString = req.getParameter("f");
//		System.out.println(fString);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
