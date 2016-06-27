package day38_spring.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
	
	//bean的完整的生命周期
	@Test
	public void test1(){
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		CustomerService cService = (CustomerService) applicationContext.getBean("customerService");
//		cService.add();
		cService.find();
		applicationContext.close();
	}
}
