package day14;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4Tagwhen extends SimpleTagSupport{
	private boolean test;
	public void setTest(boolean test) {
		this.test = test;
	}
	@Override
	public void doTag() throws JspException, IOException {
		//获取父标签
		Demo4Tagchoose choose = (Demo4Tagchoose) this.getParent();
		choose.setTest(test);
		
		//如果条件成了，则输出标签体内容，并跳出父标签
		if(test){
			this.getJspBody().invoke(null);
			throw new SkipPageException();	//如果条件成立，就不再执行后面的内容
		}
	}
}
