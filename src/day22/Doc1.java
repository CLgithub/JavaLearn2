package day22;

import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;

/*
servlet规范	Servlet Filter Listener
	servlet有初始化参数
	filter有初始化参数
	listener没有初始化参数，在开发中一般使用servletCentext中的（<context-param>）

1.文件上传
	问题：什么是文件上传？为什么使用文件上传
		将客户端资源，通过网络传递到服务器端
		因为数据比较到，我们必须通过文件上传才能完成将数据保存的到服务器端
		
		文件上传的本质：io流操作
		
	演示：文件上传应该怎样操作？（Demo1）
		浏览器端：
			1.method=post 只要post才可以携带大数据
			2.必须使用<input type='file' name='f'> 要有name属性
			3.form表单要带上  enctype="multipart/form-data"属性
				能把文件的内容上传到服务器
		服务器端：
			request对象是用于获取请求信息的
				getInputStream();	可以获取一个输入字节流，通过这个输入流，可以获取请求正文信息
		文件上传原理：
			浏览器端主页上述三件事，在服务器端通过流将数据读取到，再对数据进行解析
			将上传文件内容得到。保存在服务器端，就完成了文件上传
	在实际开发中，不需要我们进行数据解析来完成文件上传，我们将使用封装好的工具，只要调用工具api就可以完成文件上传
	
	我们使用的是commons-fileupload,它是apache提供的一套开源免费的文件上传工具
	
	使用commons-fileupload
	1.导入jar包
		commons-fileupload-1.3.2.jar	
		commons-io-2.5.jar
		介绍：commons-fileupload
			三个核心：
				1.DiskFileItmeFactory
				2.ServletFileUpload类
				3.FileItem
				
	2.快速入门（Demo2）
		1.创建jsp
		2.创建servlet
			1.创建一个DiskFileItemFactory对象
				DiskFileItemFactory dfFactory=new DiskFileItemFactory();
			2.创建ServletFileUpload对象
				resp
			3.解析所有上传数据
				List<FileItem> parseRequest = sFileUpload.parseRequest(req);
				遍历
					1.isFormField()判断是什么类型的组件
					2.fileItem.getFieldName()
						返回值string ，得到组件名称<input name="">
					3.fileItem.getName()
						得到上传文件名称
						注意:浏览器不同，它们得到的效果不一样
							1.包含全路径名称
							2.值包含上传文件名称
					4.getString()
						可以获得组件的内容，相当于getParameter方法，注意编码
						如果是上传组件，上传的文件是文本文件，可以用这方法，注意方法
					5.获取上传文件内容，保存到服务器端
						getInputStream(),方法可以获取上传文件内容的输入流
						可以自己将输入流接入将内容写到文件
						也可以：
							IOUtils.copy(fileItem.getInputStream(), fOutputStream);
						
						
*/
public class Doc1 {

}
