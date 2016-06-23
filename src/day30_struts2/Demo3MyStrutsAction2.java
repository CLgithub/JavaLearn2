package day30_struts2;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Demo3MyStrutsAction2 implements ModelDriven<User> {

	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}

	public String say() {
		System.out.println(user);
		return "aa";
	}

	

}
