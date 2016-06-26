package day32_struts2;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo5Action extends ActionSupport{

	@Override
	public String execute() throws Exception {
		List<User> users=new ArrayList<>();
		users.add(new User("小明","123", 23, "男"));
		users.add(new User("tom","456", 25, "男"));
		users.add(new User("小红","1251", 22, "女"));
		
		List<User> users2=new ArrayList<>();
		users2.add(new User("小张","123", 23, "男"));
		users2.add(new User("jre","456", 25, "男"));
		users2.add(new User("小白","1251", 22, "女"));
		
		ActionContext actionContext=ActionContext.getContext();
		ValueStack valueStack = actionContext.getValueStack();
		
		valueStack.push(users);
		valueStack.set("users2", users2);
		
		return SUCCESS;
	}
	
}
