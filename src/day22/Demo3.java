package day22;

import java.io.File;
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

public class Demo3 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html; charset=utf-8");
		
		DiskFileItemFactory dfFactory=new DiskFileItemFactory();//使用默认的
		dfFactory.setRepository(new File(req.getServletContext().getRealPath("/tmp")));
		dfFactory.setSizeThreshold(1024*1000);
		
		//sizeThreshold		缓存大小
		//repository		临时文件存储位置
//		System.out.println(this.getClass().getResource("../../../tmp/"));	//	"/"代表classes目录
		//this.getClass().getResourceAsStream("/xxx")用于到classes目录取出指定文件输入流
		//req.getServletContext()获得tomcat目录下本项目根目录
//		System.out.println(req.getServletContext().getRealPath("/tmp"));	
//		File file=new File(req.getServletContext().getRealPath("/tmp/test.txt"));
		//1.DiskFileItemFactory
//		DiskFileItemFactory dfFactory=new DiskFileItemFactory(1024*100, new File("file"));
		
		//2.ServletFileUpload
		ServletFileUpload sFileUpload=new ServletFileUpload(dfFactory);
		boolean b = sFileUpload.isMultipartContent(req);		//用于判断是否是上传操作
		
//		sFileUpload.setFileSizeMax(fileSizeMax);	//设置单个文件上传最大上传大小
//		sFileUpload.setSizeMax(sizeMax);			//设置总文件上传大小
		
		sFileUpload.setHeaderEncoding("utf-8");		//解决上传文件中文名称乱码问题
		
		if(b){
			try {
				List<FileItem> list = sFileUpload.parseRequest(req);
				for(FileItem item:list){
					//3.FileItem
					if(item.isFormField()){
						System.out.println("内容："+item.getString());
						System.out.println("内容："+item.getString("utf-8"));	//解决乱码问题
					}else {
						InputStream inputStream = item.getInputStream();
						File file=new File(req.getServletContext().getRealPath("/uploadFile/"+item.getName()));
						FileOutputStream fileOutputStream=new FileOutputStream(file);
						IOUtils.copy(inputStream, fileOutputStream);
						item.delete();	//删除临时文件
						inputStream.close();
						fileOutputStream.close();
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
	}
	
}
