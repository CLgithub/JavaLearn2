package day31_struts2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo4Download extends ActionSupport {
	
	private String fileName = "2.合并切割mp3.wmv";
	
	//返回contentType
	public String getContentType() {
		return ServletActionContext.getServletContext().getMimeType(fileName);
	}
	
 	//返回downloadFileName
	public String getDownloadFileName() throws UnsupportedEncodingException{
		return URLEncoder.encode(fileName, "utf-8");
	}

	//返回文件流
	public InputStream getInputStream() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("/Users/L/Downloads/aaa/"+fileName);
		return fis;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("Demo4Download.execute()");
		return SUCCESS;
	}
	

}
