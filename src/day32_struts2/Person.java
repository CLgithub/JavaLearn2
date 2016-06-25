package day32_struts2;

public class Person {
	private String name;
	private Dog myDog;

	public Dog getMyDog() {
		return myDog;
	}

	public void setMyDog(Dog myDog) {
		this.myDog = myDog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", myDog=" + myDog + "]";
	}

}
