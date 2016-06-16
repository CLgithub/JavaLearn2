package day22;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo5 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//得到要下载的文件名称
		String fileName = req.getParameter("fileName");
		//得到文件
//		File file=new File("D:/XX-Net-3.1.4.zip");
		File file=new File("D:/新建文本文档.txt");
		System.out.println(file);
		System.out.println(this.getServletContext().getMimeType(file.getName()));
		resp.reset(); // 清空response
		//设置mimeType类型，能解析的解析，不能解析的下载
//		resp.setContentType(this.getServletContext().getMimeType(file.getName()));
		//设置一个响应头，全是下载
		resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(file.getName(), "utf-8")); //设置响应头，下载文件名称
		
		
		if(file.exists()){
			String useragent=req.getHeader("user-agent");
			System.out.println(useragent);
			//下载，通过response得到输出流，把要下载的文件写到浏览器
			ServletOutputStream outputStream = resp.getOutputStream();
			FileInputStream fInputStream=new FileInputStream(file);
			byte[] buf=new byte[1024];
			int i=0;
			while((i=fInputStream.read(buf))!=-1){
				outputStream.write(buf, 0, i);
			}
			fInputStream.close();
			outputStream.close();
		}
		
	}
}
