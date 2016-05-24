package day14;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
自定义标签的作用：
	（1）控制标签体内容是否输出
	（2）控制标签余下内容是否输出
	（3）控制重复输出标签体内容
	（4）改变标签体内容
	（5）带属性的标签
*/
public class Demo2Tag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("Demo2Tag.doTag()");
		
		//1控制标签体内容是否输出
		JspFragment jspBody =this.getJspBody();
		//执行invoke方法会把标签体内容输出到指定的java.io.Writer里去，要输出就调用，不输出就不调用
//		jspBody.invoke(this.getJspContext().getOut());//其实就是向浏览器输出，
		//if out is null,如果传入的out是null，得到的Writer就是jspWriter，意味着可以省略
//		jspBody.invoke(null);
		
		//2控制标签余下内容是否输出
		//默认是输出	抛出SkipPageException异常着不输出
//		throw new SkipPageException();
		
		//3控制重复输出标签体内容,多次执行jspBody.invoke(null);
//		for(int i=0;i<5;i++){
//			jspBody.invoke(null);
//		}
		
		//4改变标签体内容,将标签体内容全部变成小写输出	,
		//思路：将标签体内容输出到一个临时容器，改变这个内容后输出到浏览器
		JspWriter out = this.getJspContext().getOut();
		StringWriter sWriter=new StringWriter();
		jspBody.invoke(sWriter);
		out.write(sWriter.toString().toLowerCase());
		
		//带属性的标签
		
	}
}
