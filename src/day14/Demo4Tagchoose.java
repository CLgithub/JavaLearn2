package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4Tagchoose extends SimpleTagSupport {
	//临时变量
	private boolean test;
	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// 只用做输出标签体内容
		this.getJspBody().invoke(null);
	}
}
