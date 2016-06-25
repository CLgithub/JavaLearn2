package day32_struts2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo3Action extends ActionSupport{

	@Override
	public String execute() throws Exception {
		
		//获取valueStack
		
		//1.通过request获取
		HttpServletRequest request = ServletActionContext.getRequest();
		//org.apache.struts2.dispatcher.Dispatcher.class中， 
		//request.setAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY, proxy.getInvocation().getStack());
		ValueStack valueStack = (ValueStack) request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		
		
		//2.从ActionContext中获取
		ActionContext actionContext=ActionContext.getContext();
		ValueStack valueStack2 = actionContext.getValueStack();
		
		System.out.println(valueStack==valueStack2);	//true	同一个对象
		return NONE;
	}
}
