package day14;

import java.io.IOException;

import javax.servlet.ServletResponse;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Dome1_2ShowIpTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = this.getJspContext();
		PageContext pageContext=(PageContext) context;
		pageContext.getOut().write(pageContext.getRequest().getRemoteHost());
	}
}
