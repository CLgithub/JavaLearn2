package day38_spring.demo7;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day38_spring.demo1.HelloService;

public class SpringTest7 {
	@Test
	public void test1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38_2.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.sayHello();
	}
}
