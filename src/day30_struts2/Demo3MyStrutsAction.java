package day30_struts2;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Demo3MyStrutsAction {

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String say() {
		System.out.println(name);
		System.out.println(password);
		return "aa";
	}

}
