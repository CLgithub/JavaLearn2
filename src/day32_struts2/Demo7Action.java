package day32_struts2;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo7Action extends ActionSupport{
	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		ValueStack valueStack = actionContext.getValueStack();

		ArrayList<User> users=new ArrayList<>();
		users.add(new User("小明", "123", 23, "男"));
		users.add(new User("tom", "456", 25, "男"));
		users.add(new User("小红", "1251", 22, "女"));
		
		valueStack.set("users", users);
		return SUCCESS;
	}
}
