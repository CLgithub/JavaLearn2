package day14;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Dem02Tag2 extends SimpleTagSupport{
	
	private Integer num;

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//1.用JspFragment对象的invoke()方法控制标签体内容是否输出,参数为指定想哪输出
		JspFragment jspBody = this.getJspBody();
//		jspBody.invoke(this.getJspContext().getOut());
		
		//2控制标签余下内容是否输出
		//默认是输出	抛出SkipPageException异常则不输出
//		throw new SkipPageException();
	
		//3控制重复输出标签体内容,多次执行jspBody.invoke(null);
//		for(int i=0;i<num;i++){
//			jspBody.invoke(this.getJspContext().getOut());
//		}
		
		//4.改变标签体内容，将标签体内容全部变成小写输出
		//思路：将标签体内容输出到一个临时容器，改变这个内容后输出到浏览器
		JspWriter out = this.getJspContext().getOut();
		StringWriter stringWriter = new StringWriter();		
		jspBody.invoke(stringWriter);		//将jspBody输出到stringWriter，
		out.write(stringWriter.toString().toLowerCase());	//向浏览器输出stringWriter的小写内容
	}
}
