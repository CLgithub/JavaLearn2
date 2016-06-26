package day38_spring.demo2;

/*
 * 构造方法实例话来实例化bean
 */
public class Bean1 {

	public Bean1() {
		System.out.println("Bean1无参数的构造方法");
	}
	
	public Bean1(String name){
		System.out.println("Bean1带参数的构造方法");
	}

}
