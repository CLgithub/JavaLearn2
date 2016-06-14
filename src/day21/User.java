package day21;

public class User {
	private String loginName;
	private String password;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	public User(String loginName, String password) {
		this.loginName = loginName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [loginName=" + loginName + ", password=" + password + "]";
	}

}
