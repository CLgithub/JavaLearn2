package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4Tagif2 extends SimpleTagSupport{
	private Boolean test;

	public void setTest(Boolean test) {
		this.test = test;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			this.getJspBody().invoke(this.getJspContext().getOut());
		}
	}
}
