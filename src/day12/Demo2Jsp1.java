package day12;

/*
4.jsp基础：
	4.1 jsp技术
		servlet的作用：用java语言开发动态资源的技术
		jsp的作用：用java语言+html语言开发动态资源的技术
			jsp就是servlet
		
	4.2 jsp的特点
		1)jsp的运行必须交给tomcat服务器运行
			work目录：tomcat服务器存放jsp运行时的临时文件
		2)jsp页面即可以写html，又可以写java代码
	
	4.3 体验jsp页面作用
		需求1：显示当前时间到浏览器上
			可以把jsp页面当做html页面在服务器中访问
			
	4.4 jsp的执行过程
		问题：http://localhost:8090/JavaLearn2/page/day12/jspTest1.jsp 如何显示效果？？
		
		1) 访问到jspTest1.jsp页面：tomcat扫描到jsp文件，在%tomcat%/work目录把jsp文件翻译成java源文件
			jspTest1.jsp--->jspTest1_jsp.java				（翻译）
		2) tomcat服务器把java源文件编译成class字节码文件
			jspTest1_jsp.java---->jspTest1_jsp.class		（编译）
		3) tomcat服务器构造jspTest1_jsp类对象
		4) tomcat服务器调用jspTest1_jsp类对象的一下方法，返回内容显示到浏览器
	
	注意：
		第一次访问jsp
			走 	1) 2) 3) 4)
		第n次访问jsp
			走	4)
		jsp文件修改了或者jsp的临时文件（jspTest1_jsp.java，jspTest1_jsp.class）被删除了，要走翻译和编译的过程
		
	4.5 疑问：为什么jsp就是servlet
			jsp翻译java文件：
				public final class jspTest1_jsp extends org.apache.jasper.runtime.HttpJspBase
	    	implements org.apache.jasper.runtime.JspSourceDependent,
	                 org.apache.jasper.runtime.JspSourceImports {
	            HttpJspBase类：
	         	public abstract class org.apache.jasper.runtime.HttpJspBase extends javax.servlet.http.HttpServlet implements javax.servlet.jsp.HttpJspPage
	
		结论：jsp翻译成的jspTest1_jsp.java间接继承了HttpServlet，	jsp就是servlet程序
		
		servlet的生命周期：
			1）调用构造方法	（第一次访问才做）
			2）调研init()方法	（第一次访问才做）
			3）执行service方法
			4）销毁时执行destroy方法
		jsp的生命周期：
			1）翻译：jspTest1.jsp--->jspTest1_jsp.java
			2）编译：jspTest1_jsp.java---->jspTest1_jsp.class
			后面和servlet一样
			3）调用构造方法	（第一次访问才做）
			4）调研init()方法	（第一次访问才做）	_jspInit()
			5）执行service方法			_jspService()
			6）销毁时执行destroy方法		_jspDestroy()

		
*/
public class Demo2Jsp1 {

}
