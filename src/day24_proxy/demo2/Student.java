package day24_proxy.demo2;

public class Student implements Person{

	@Override
	public String say(String msg) {
		return "hello"+msg;
	}

}
