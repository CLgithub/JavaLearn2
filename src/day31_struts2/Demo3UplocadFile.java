package day31_struts2;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import day22.FileUploadUtis;

public class Demo3UplocadFile extends ActionSupport {
	private File upLoadFile;
	private String upLoadFileContentType;
	private String upLoadFileFileName;;

	public File getUpLoadFile() {
		return upLoadFile;
	}

	public void setUpLoadFile(File upLoadFile) {
		this.upLoadFile = upLoadFile;
	}

	public String getUpLoadFileContentType() {
		return upLoadFileContentType;
	}

	public void setUpLoadFileContentType(String upLoadFileContentType) {
		this.upLoadFileContentType = upLoadFileContentType;
	}

	public String getUpLoadFileFileName() {
		return upLoadFileFileName;
	}

	public void setUpLoadFileFileName(String upLoadFileFileName) {
		this.upLoadFileFileName = upLoadFileFileName;
	}

	public String execute() throws IOException {
//		System.out.println("上传的文件:" + upLoadFile);
//		System.out.println("文件类型:" + upLoadFileContentType);
//		System.out.println("文件名称:" + upLoadFileFileName);
		File dir=new File(ServletActionContext.getServletContext().getRealPath("/uploadFile/")+FileUploadUtis.getRandomDirectory(upLoadFileFileName));
		if(!dir.exists()){
			dir.mkdirs();
		}
		//得到文件
		FileUtils.copyFile(upLoadFile, new File(dir+"/"+System.currentTimeMillis()+"_"+upLoadFileFileName));
		
		return SUCCESS;
	}
}
