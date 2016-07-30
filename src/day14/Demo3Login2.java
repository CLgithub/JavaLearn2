package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo3Login2 extends SimpleTagSupport{
	private String action;
	private String method;
	private String loginName;
	private String password;
	
	public void setAction(String action) {
		this.action = action;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("<form action="+action+" method="+method+">");
		sBuffer.append("<table cellpadding='1' cellspacing='1' border='1'>");
		sBuffer.append("<tr>");
		sBuffer.append("<td>登录名：</td><td><input type='text' name="+loginName+" id="+loginName+"></td>");
		sBuffer.append("</tr>");
		sBuffer.append("<tr>");
		sBuffer.append("<td>密码：</td><td><input type='password' name="+password+" id="+password+"></td>");
		sBuffer.append("</tr>");
		sBuffer.append("<tr>");
		sBuffer.append("<td colspan='2' align='center'><input type='submit' value='登录'></td>");
		sBuffer.append("</tr>");
		sBuffer.append("</table>");
		sBuffer.append("</form>");
		out.write(sBuffer.toString());
	}
}
