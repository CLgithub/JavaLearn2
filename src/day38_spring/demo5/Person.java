package day38_spring.demo5;

public class Person {
	private String name;
	private Car2 myCar2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car2 getMyCar2() {
		return myCar2;
	}

	public void setMyCar2(Car2 myCar2) {
		this.myCar2 = myCar2;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", myCar2=" + myCar2 + "]";
	}
}
