package day38_spring.demo5;

public class Car2 {
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
		return "Car2 [name=" + name + ", price=" + price + "]";
	}
}
