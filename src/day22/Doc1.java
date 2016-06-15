package day22;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

				核心api介绍	(Demo3)
					1.DiskFileItemFactory	
						作用：可以设置缓存大小以及临时文件保存位置
							默认缓存大小是10240（10k）
							临时文件默认存储在系统的临时文件目录下，
							1.new DiskFileItemFactory
								dfFactory.setSizeThreshold(sizeThreshold);		//设置缓存大小
								dfFactory.setRepository(repository);			//设置临时文件目录
							2.new DiskFileItemFactory(1024*100, new File("file"));
								
					2.ServletFileUpload
						1.创建一个上传工具，指定使用缓存区大小和临时文件存储目录
							ServletFileUpload sFileUpload=new ServletFileUpload(dfFactory);
						2.解析request对象，得到所有上传项，每一关fileitem就相当于一个上传项
							List<FileItem> list = sFileUpload.parseRequest(req);
						3.判断是否是上传
							boolean b = sFileUpload.isMultipartContent(req);	
							可以简单理解，就是判断encType=="multipart/form-data"
						4.设置上传文件大小
							sFileUpload.setFileSizeMax(fileSizeMax);	//设置单个文件上传最大上传大小
							sFileUpload.setSizeMax(sizeMax);		//设置总文件上传大小
						5.解决上传文件中文名称乱码问题
							sFileUpload.setHeaderEncoding("utf-8");
							
					3.FileItem
						1.判断是否是formFiled
							item.isFormField()
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
						6.删除临时文件
							item.delete();
								
					---------------------
					总结：文件上传时乱码问题
						1.上传名称乱码
							sFileUpload.setHeaderEncoding("utf-8");
						2.非上传组件内容乱码
							FileItem.getString("utf-8");
						3.思考：上传文件信息是否会乱码，需要解决吗
							不需要解决，因为上传时使用的是字节流进行复制
							
	-------------------------------------------------------------------
		多文件上传(demo4)
			服务器端和单文件一样
-------------------------------------------------------------------------
关于文件上传的注意事项：
	1.上传文件在服务器保存位置问题
		1.保存在可以被浏览器直接访问的位置
			例如：商城的商品图片
			保存在工程的webroot下，WEB-INF、META-INF目录及其子目录除外的目录
			FileOutputStream fOutputStream=new FileOutputStream(this.getServletContext().getRealPath("/uploadFile/")+name);
		2.保存的问题不允许浏览器直接访问
			例如：付费电影
			1.工程中	META-INF、WEB-INF目录及其子目录
			2.不在工程下
	2.上传文件在同一个目录重名问题：
		在开发中解决这个问题。可以给上传文件起随机名称。
			1.使用毫秒值
			2.使用uuid
	3.同一目录下，文件过多问题
		分目录
			1）按照上传时间进行目录分类（年月日）
			2）按照上传用户进行目录分类－－－－每个用户建立单独目录
			3）按照固定数量进行目录分类－－－－假设每个目录只能存放1000个文件，每当一个目录存放满1000个文件后，创建一个新的目录
			4）按照文件名的hashcode进行目录分离
				详情见FileUploadUtis.getRandomDirectory
				
			
			
*/
public class Doc1 {

}
