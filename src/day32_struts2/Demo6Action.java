package day32_struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo6Action extends ActionSupport{
	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		ValueStack valueStack = actionContext.getValueStack();
		
		valueStack.set("userName", "小黄");
		return SUCCESS;
	}
}
