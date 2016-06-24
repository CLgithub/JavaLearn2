package day31_struts2;

/*
struts2中文件上传与下载
	1.上传
		浏览器端3件事：
			1.method=post
			2.<input type="file" name="xx">
			3.encType="multipart/form-data";
		服务器端：
			commons-fileupload组件	（详情见/JavaLearn2/src/day22/Demo4.java）
			1.DiskFileItemFactory
			2.ServletFileUpload
			3.FileItem
		
		struts2文件上传：
			默认情况下struts2框架使用的就是commons-fileupload组件
			struts2使用了一个interceptor帮助我们完成文件上传操作
			<interceptor name="fileUpload" class="org.apache.struts2.interceptor.FileUploadInterceptor"/>
		详情见Demo3UplocadFile
	
		
		
			

*/
public class Doc2 {

}
