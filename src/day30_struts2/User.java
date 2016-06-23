package day30_struts2;

import java.util.Date;

public class User {
	private String name;
	private String password;
	private Date myDateB;

	public Date getMyDateB() {
		return myDateB;
	}

	public void setMyDateB(Date myDateB) {
		this.myDateB = myDateB;
	}

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

	public User() {
	}

	public User(String name, String password, Date myDateB) {
		this.name = name;
		this.password = password;
		this.myDateB = myDateB;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", myDateB=" + myDateB + "]";
	}

}
