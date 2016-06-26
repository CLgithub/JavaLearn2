package day38_spring.demo1;

public class HelloServiceImpl implements HelloService {

	private String info;

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public void sayHello() {
		System.out.println("HelloServiceImpl.sayHello() "+info);
	}

}
