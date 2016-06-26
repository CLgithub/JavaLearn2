package day38_spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest1 {
	
	//传统方式
	@Test
	public void demo1(){
		HelloService helloService=new HelloServiceImpl();
		helloService.sayHello();
	}
	
	
	//spring开发
	@Test
	public void demo1_spring(){
		//创建了一个工厂类
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		HelloService helloService = (HelloService) applicationContext.getBean("HelloService");
		helloService.sayHello();
	}
}
