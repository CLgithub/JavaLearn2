package day19_2.exercise.entity;


public class Users {
	private Integer id;
	private String name;
	private String Password;

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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Users(Integer id, String name, String password) {
		this.id = id;
		this.name = name;
		Password = password;
	}

	public Users() {
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", Password=" + Password + "]";
	}

}
