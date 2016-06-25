package day32_struts2;

public class Dog {
	private String name;
	private Person myPerson;

	public Person getMyPerson() {
		return myPerson;
	}

	public void setMyPerson(Person myPerson) {
		this.myPerson = myPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog() {
	}

	public Dog(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", myPerson=" + myPerson + "]";
	}

}
