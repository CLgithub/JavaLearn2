package day14;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 标签处理器类
 * @author L
 * @date 2016年5月24日
 */
//1继承SimpleTagSupport
public class Dome1ShowIpTag extends SimpleTagSupport{
	//以下代码SimpleTagSupport已经做了，直接使用getJspContext拿到jspContext就行
//	private JspContext jspContext;
//	//覆盖setJspContext，取得jspContext(其实就是pagContext)
//	@Override
//	public void setJspContext(JspContext pc) {
//		this.jspContext=pc;
//	}
	
	
	
	//2覆盖doTage方法,
	//(4)执行标签时调用的方法
	@Override
	public void doTag() throws JspException, IOException {
		//3.标签业务逻辑：向浏览器输出客户端ip地址
		
		JspContext jspContext = this.getJspContext();
		//jspContext其实就是pagContext
		PageContext pageContext=(PageContext) jspContext;
		//得到ServletRequest request
		ServletRequest request = pageContext.getRequest();
		//取得客户端ip
		String remoteHost = request.getRemoteHost();		
		
		//向浏览器输出ip地址
		pageContext.getOut().write(remoteHost);
	}
	
	//(1)设置pageContext对象，传入pageContext，之后就可以通过getJspContext()方法得到
	@Override
	public void setJspContext(JspContext pc) {
		super.setJspContext(pc);
	}
	
	//(2)设置父标签对象，如果没有父标签，则不调用该方法，如果有则调用传入JspTag父标签对象,之后可以通过getParent()得到
	@Override
	public void setParent(JspTag parent) {
		super.setParent(parent);
	}
	
	//(3)设置标签体内容，标签体内容封装到jspFragment对象中，然后传入JspFragment对象，通过getJspBody()方法得到,如果没有标签体内容，则不调用次方法
	@Override
	public void setJspBody(JspFragment jspBody) {
		super.setJspBody(jspBody);
	}
	
	
	
	
}
