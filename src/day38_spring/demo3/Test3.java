package day38_spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的作用范围
 * @author L
 * @date 2016年6月26日
 */
public class Test3 {
	
	@Test
	public void test1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		Customer customer1 = (Customer) applicationContext.getBean("customer");
		Customer customer2 = (Customer) applicationContext.getBean("customer");
		System.out.println(customer1==customer2);	
		//true说明是同一个对象，单例的
		//false说明不是同一个对象，原型的
	}
}
