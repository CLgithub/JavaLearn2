package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.swing.text.html.HTML;

/*
开发一个含有[用户名]和[密码]的登录表格标签
   	 <form action="#" method="post"> 
  		<simple:login username="username(表单项名字)" 
						password="password(表单项名字)" />
  	 </form>
*/
public class Demo3Login extends SimpleTagSupport {
	private String action;
	private String method;
	private String userName;
	private String password;
	
	public void setAction(String action) {
		this.action = action;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public void doTag() throws JspException, IOException {
		
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("<form action="+action+" method="+method+">");
		sBuffer.append("<table cellpadding='5' cellspacing='1' border='0' align='center'>");
		sBuffer.append("<tr>");
		sBuffer.append("<td><b>用户名：</b></td><td><input type='text' name='"+userName+"' id='"+userName+"' style='width: 160px' /></td>");
		sBuffer.append("</tr>");
		sBuffer.append("<tr>");
		sBuffer.append("<td><b>密码：</b></td><td><input type='password' name='"+password+"' id='"+password+"' style='width: 160px' /></td>");
		sBuffer.append("</tr>");
		sBuffer.append("<tr>");
		sBuffer.append("<td colspan='2' align='right'><input type='submit' value='登录' /></td>");
		sBuffer.append("</tr>");
		sBuffer.append("</form>");
		this.getJspContext().getOut().write(sBuffer.toString());
	}
	
}
