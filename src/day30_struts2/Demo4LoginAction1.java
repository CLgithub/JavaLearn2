package day30_struts2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Demo4LoginAction1 extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}
	
	public String doLogin() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println(user);
		if (serviceDoLogin(user)) {
			session.setAttribute("user", user);
			return SUCCESS;
		} else {
			return "uSuccess";
		}
	}
	
	public boolean serviceDoLogin(User user) {
		if ("aa".equals(user.getName()) && "123".equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
