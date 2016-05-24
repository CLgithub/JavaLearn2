package day14;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
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
	
	
	
	//2覆盖doTage方法
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
	
	
}
