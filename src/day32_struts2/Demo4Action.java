package day32_struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo4Action extends ActionSupport{
	
	public String execute() throws Exception {
		//向valueStack中存储数据
		ActionContext actionContext=ActionContext.getContext();
		ValueStack valueStack = actionContext.getValueStack();
		
		valueStack.set("userName", "admin");
		valueStack.push("abcd");
		
		return SUCCESS;
	}
}
