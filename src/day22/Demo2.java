package day22;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

public class Demo2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//1.创建一个DiskFileItemFactory对象
		DiskFileItemFactory dfFactory=new DiskFileItemFactory();
		//2.创建ServletFileUpload对象
		ServletFileUpload sFileUpload=new ServletFileUpload(dfFactory);
		try {
			//通过request获取数据，进行解析，将解析的数据封装到list集合,集合中的每一项就是一个上传数据
			List<FileItem> fileItems = sFileUpload.parseRequest(req);
			for(FileItem fileItem:fileItems){
				//判断fileitem是否是formfield，
				if(fileItem.isFormField()){	//如果是普通formField
					//得到了<input type="text" name="f">
//					System.out.println("text_fieldName:"+fileItem.getFieldName());
//					System.out.println("text_name:"+fileItem.getName());
//					System.out.println("text_string:"+fileItem.getString());
				}else {//否则
					//得到了<input type="file" name="f">上传的数据
//					System.out.println("file_fieldName:"+fileItem.getFieldName());
//					System.out.println("file_name:"+fileItem.getName());
//					System.out.println("file_string:"+fileItem.getString());
					//获取文件内容，完成文件上传操作
//					InputStream inputStream = fileItem.getInputStream();
					String name=fileItem.getName();
					if(name.contains("\\")){
						name=name.substring(name.lastIndexOf("\\")+1);
					}
//					System.out.println(this.getClass().getResource("/").getPath());
//					System.out.println(this.getClass().getResource(""));
					FileOutputStream fOutputStream=new FileOutputStream("d:/"+name);
//					byte[] buf=new byte[1024];
//					int i=0;
//					while((i=inputStream.read(buf))!=-1){
////						String str=new String(buf,0,i,"utf-8");
////						System.out.println(str);
//						fOutputStream.write(buf,0,i);
//					}
//					fOutputStream.flush();
//					fOutputStream.close();
//					inputStream.close();
					
					IOUtils.copy(fileItem.getInputStream(), fOutputStream);
					
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
