package day31_struts2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

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
	--------------------------------------------------------
	关于struts2中文件上传细节：
		1.关于控制文件上传大小
			在default.properties文件中定义了文件上传大小
			struts.multipart.maxSize=2097152 上传文件默认的总大小 2m(2097152/1024k)
			<!-- 设置上传文件大小 为20m-->
			<constant name="struts.multipart.maxSize" value="20971520" />
		2.在struts2中默认使用的是commons-fileupload进行文件上传。
			# struts.multipart.parser=cos
			# struts.multipart.parser=pell
			struts.multipart.parser=jakarta
			如果使用pell,cos进行文件上传，必须导入其jar包
		3.如果出现问题，需要配置input视图，在页面上可以通过<s:actionerror>展示错误信息.
			 问题:在页面上展示的信息，全是英文，要想展示中文，国际化
				struts-messages.properties 文件里预定义 上传错误信息，通过覆盖对应key 显示中文信息
				struts.messages.error.uploading=Error uploading: {0}
				struts.messages.error.file.too.large=The file is to large to be uploaded: {0} "{1}" "{2}" {3}
				struts.messages.error.content.type.not.allowed=Content-Type not allowed: {0} "{1}" "{2}" {3}
				struts.messages.error.file.extension.not.allowed=File extension not allowed: {0} "{1}" "{2}" {3}
	
				修改为
					struts.messages.error.uploading=上传错误: {0}
					struts.messages.error.file.too.large=上传文件太大: {0} "{1}" "{2}" {3}
					struts.messages.error.content.type.not.allowed=上传文件的类型不允许: {0} "{1}" "{2}" {3}
					struts.messages.error.file.extension.not.allowed=上传文件的后缀名不允许: {0} "{1}" "{2}" {3}
					
				{0}:<input type=“file” name=“uploadImage”>中name属性的值
				{1}:上传文件的真实名称
				{2}:上传文件保存到临时目录的名称
				{3}:上传文件的类型(对struts.messages.error.file.too.large是上传文件的大小)
	

		4.关于多文件上传时的每个上传文件大小控制以及上传文件类型控制.
			1.多文件上传
				服务器端:
					只需要将action属性声明成List集合或数组就可以。
					
					private List<File> upload;
					private List<String> uploadContentType;
					private List<String> uploadFileName;
					
			2.怎样控制每一个上传文件的大小以及上传文件的类型?
				在fileupload拦截器中，通过其属性进行控制.
				
				maximumSize---每一个上传文件大小
				allowedTypes--允许上传文件的mimeType类型.
				allowedExtensions--允许上传文件的后缀名.
			
				<action name="Demo3UpLoadFile_" class="day31_struts2.Demo3UplocadFile">
					<interceptor-ref name="defaultStack">
						<param name="fileUpload.allowedExtensions">txt,mp3,doc</param>
					</interceptor-ref>
					<result name="success">good_result.jsp</result>
				</action>
	2.下载
		文件下载方式：（以前，day22）
			1.超链接
			2.服务器编码，通过流向客户端写回
			
		struts2中文件下载
			通过<result type="stream"><result>完成
			
			 <result-type name="stream" class="org.apache.struts2.dispatcher.StreamResult"/>
			 在streamResult类中有三个属性需要设置：
			 	protected String contentType = "text/plain";	//设置下载文件的mimeType类型
			 	protected String contentDisposition = "inline";		//用于设置下载操作以及下载文件的名称
			 	protected InputStream inputStream;				//用于读取要下载的文件
			 	
		 	action中配置
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
				
			struts.xml中配置
				<!-- 文件下载 -->
				<action name="Demo4Download_" class="day31_struts2.Demo4Download">
					<result type="stream">
						<!-- 调用当前action中的getContentType()方法 -->
						<param name="contentType">${contentType}</param>
						<!-- 会调用action里的getDownloadFileName方法得到文件名 -->
						<param name="contentDisposition">attachment;filename=${downloadFileName}</param>
						<!-- 会调用action中的getInputStream方法 -->
						<param name="inputStream">${inputStream}</param>
					</result>
				</action>
			

*/
public class Doc2 {

}
