package day30_struts2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo1LoginAction extends ActionSupport {
	//属性驱动1：将action作为model
//	private String name;
//	private String password;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
	//属性驱动2：在action中声明一个javaBean（mode）在页面上使用ognl描述
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String doLogin() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//0用request获取请求参数
		// String name = request.getParameter("name");
		// String password = request.getParameter("password");
		
		//属性驱动1：将action作为model
//		User user = this.serviceDoLogin(name, password);
//		if (user!=null) {
//			session.setAttribute("user", user);
//			return SUCCESS;
//		} else {
//			return "uSuccess";
//		}
		
		//属性驱动2：在action中声明一个javaBean（mode）在页面上使用ognl描述
		if (serviceDoLogin(user)) {
			session.setAttribute("user", user);
			return SUCCESS;
		} else {
			return "uSuccess";
		}
		
		
	}

	public User serviceDoLogin(String name, String password) {
		if ("aa".equals(name) && "123".equals(password)) {
			return new User(name, password);
		} else {
			return null;
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
