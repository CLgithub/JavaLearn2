package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4Tagwhen2 extends SimpleTagSupport {
	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Demo4Tagchoose2 tagchoose2 = (Demo4Tagchoose2) this.getParent();
		tagchoose2.setTest(test);
		if (test) {
			this.getJspBody().invoke(null);
			throw new SkipPageException();
		}
	}
}
