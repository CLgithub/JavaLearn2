package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4Tagotherwise2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		Demo4Tagchoose2 parent = (Demo4Tagchoose2) this.getParent();
		if(!parent.isTest()){	//如果没有满足条件的
			//输出other
			this.getJspBody().invoke(null);
		}
	}
}
