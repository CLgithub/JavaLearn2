package day19_2.exercise.entity;

import java.util.Date;

public class Contact19_2 {
	private Integer id;
	private String name;
	private Integer age;
	private String phone;
	private String email;
	private Date dateTest;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateTest() {
		return dateTest;
	}

	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}

	public Contact19_2() {
	}

	@Override
	public String toString() {
		return "Contact19_2 [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", email=" + email
				+ ", dateTest=" + dateTest + ", gender=" + gender + "]";
	}

	public Contact19_2(Integer id, String name, Integer age, String phone, String email, Date dateTest, String gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.dateTest = dateTest;
		this.gender = gender;
	}

	

}
