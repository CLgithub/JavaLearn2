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

public class Demo4 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 DiskFileItemFactory dFactory=new DiskFileItemFactory();
		 dFactory.setRepository(new File(this.getServletContext().getRealPath("/tmp")));
		 
		 ServletFileUpload sFileUpload=new ServletFileUpload(dFactory);
		 
		 boolean b = sFileUpload.isMultipartContent(req);
		 if(b){
			 try {
				List<FileItem> list = sFileUpload.parseRequest(req);
				for(FileItem fTime:list){
					if(!fTime.isFormField()){
						String name = fTime.getName();
						InputStream inputStream = fTime.getInputStream();
						File dir=new File(this.getServletContext().getRealPath("/uploadFile/")+FileUploadUtis.getRandomDirectory(name));
						if(!dir.exists()){
							dir.mkdirs();
						}
						FileOutputStream fOutputStream=new FileOutputStream(dir+"/"+name);
						IOUtils.copy(inputStream, fOutputStream);
						fTime.delete();
						inputStream.close();
						fOutputStream.close();
					}
				}
			 } catch (FileUploadException e) {
				e.printStackTrace();
			}
			 
		 }
	}
	
}
