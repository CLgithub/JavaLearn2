package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4Tagchoose2 extends SimpleTagSupport {
	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	public boolean isTest() {
		return test;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		// 只用做输出标签体内容
		this.getJspBody().invoke(null);
	}
}
