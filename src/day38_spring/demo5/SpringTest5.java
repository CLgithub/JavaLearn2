package day38_spring.demo5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest5 {
	
	@Test
	public void test1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car);
	}
	
	@Test
	public void test2(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		Car2 car2 = (Car2) applicationContext.getBean("car2");
		System.out.println(car2);
	}
	
	@Test
	public void test3(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
	}
	
}
