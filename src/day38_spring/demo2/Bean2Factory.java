package day38_spring.demo2;

public class Bean2Factory {
	public static Bean2 getBean2(){
		System.out.println("Bean2Factory.getBean2(),静态工厂方式来实例化bean2");
		return new Bean2();
	}
}
