package day24_servlet3;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/*
servlet3特性（了解）
	在servlet3.0中可以使用注解来替代我们的配置文件
	简单说：在servlet3.0中可以没有web.xml文件
	
	servlet3.0
	servlet2.5
	怎样知道当前工程使用的是哪个版本
		web.xml中头文件version="3.1"，就是servlet版本
	版本对于关系
		servlet2.5		javaee5.0	tomcat6		jdk1.5
		serlvet3.0		javaee6.0	tomcat7		jdk1.6
		servlet3.1
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	关于servlet3.0特性：
	1.使用配置来替换配置文件(Demo1_servlet.java)
		@WebServlet({"/servlet3_1","/servlet3_2"})		servlet
		@WebFilter("/filter过滤地址")					filter
		@WebListener								listener
		
		关于这些注解细节：
			以@WebServlet("/servlet请求地址")为例
			注意：属性urlpatterns与values他们都是描述访问当前serlvet的路径，但是他们不能同时出现
			
			<servlet>
				<servlet-name></servlet-name>   	String name() default "";
				<servllet-class></servlet-class>
				<init-param>      				 WebInitParam[] initParams() default {};
					<param-name>
					<param-value>
				</init-param>
				<load-on-startup>    	int loadOnStartup() default -1;
			</servlet>
			<servlet-mapping>
				<servlet-name></servlet-name>
				<url-pattern></url-pattern>     	String[] urlPatterns() default {};   String[] value() default {};
			</servlet-mapping>
			
		注意：
			web.xml中的属性：metadata-complete="false"		false可以使用注解，true不能使用注解
	2.servlet3.0中的文件上传(Demo2_upload.jsp)（之前day22）
		浏览器端：
			1.method=post 只要post才可以携带大数据
			2.必须使用<input type='file' name='f'> 要有name属性
			3.form表单要带上  enctype="multipart/form-data"属性
				能把文件的内容上传到服务器
		服务器端：
			1.在servlet上添加注解	@MultipartConfig
			2.通过request对象获取part对象
			
			问题：1.关于上传文件中文名称乱码
					直接使用post乱码解决方法解决
				2.多文件上传这么处理
					request.getParts();
		
	3.servlet3.0中异步处理
	
	
*/
public class Doc1 {

}
