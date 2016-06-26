package day32_struts2;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo5Action extends ActionSupport implements ModelDriven<User>{

	private User user=new User("小强modelDriver", "123", 23, "男");
	@Override
	public User getModel() {
		return user;
	}
	
	private List<User> users3;

	public List<User> getUsers3() {
		return users3;
	}

	public void setUsers3(List<User> users3) {
		this.users3 = users3;
	}

	@Override
	public String execute() throws Exception {
		List<User> users = new ArrayList<>();
		users.add(new User("小明", "123", 23, "男"));
		users.add(new User("tom", "456", 25, "男"));
		users.add(new User("小红", "1251", 22, "女"));

		List<User> users2 = new ArrayList<>();
		users2.add(new User("小张", "123", 23, "男"));
		users2.add(new User("jre", "456", 25, "男"));
		users2.add(new User("小白", "1251", 22, "女"));
		
		users3=new ArrayList<>();
		users3.add(new User("小黑", "123", 23, "男"));
		users3.add(new User("小黄", "456", 25, "男"));
		
		user=new User("小强modelDriver2", "123", 23, "男");

		ActionContext actionContext = ActionContext.getContext();
		ValueStack valueStack = actionContext.getValueStack();

		valueStack.push(users);
		valueStack.set("users2", users2);

		return SUCCESS;
	}

	

}
