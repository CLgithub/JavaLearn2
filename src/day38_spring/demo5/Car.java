package day38_spring.demo5;

public class Car {
	private String name;
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}

	public Car() {
	}

	public Car(String name, Double price) {
		System.out.println("构造器方式注入属性");
		this.name = name;
		this.price = price;
	}
	
	
}
