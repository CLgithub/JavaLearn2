package day38_spring.demo2;

public class Bean3Factory {
	public Bean3 getBean3(){
		System.out.println("Bean3Factory.getBean3(),实例工厂实例化来实例化bean3");
		return new Bean3();
	}
}
