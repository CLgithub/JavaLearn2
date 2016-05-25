package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4Tagif extends SimpleTagSupport{
	private boolean test;
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jspBody = this.getJspBody();
		if(test){
			jspBody.invoke(null);
		}
	}
}
