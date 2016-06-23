package day29_struts2;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;

public class Demo6 extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}


	@Override
	public String execute() throws Exception {
		System.out.println(request.getParameter("userName"));
		return null;
	}
}
