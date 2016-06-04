package day19;

import java.util.Date;

public class User19 {
	private String userName;
	private String password;
	private int age;
	private Date date1;

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User19(String userName, String password, int age, Date date) {
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.date1 = date;
	}

	public User19() {
	}

	@Override
	public String toString() {
		return "User19 [userName=" + userName + ", password=" + password + ", age=" + age + ", date1=" + date1 + "]";
	}

}
