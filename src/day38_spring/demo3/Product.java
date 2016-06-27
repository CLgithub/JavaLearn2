package day38_spring.demo3;

public class Product {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setup() {
		System.out.println("初始化方法");
	}

	public void teardown() {
		System.out.println("销毁方法");
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}
	
}
