package day38_spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {
	
	//默认使用无参构造方法来实例化bean
	@Test
	public void test1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		Bean1 bean = (Bean1) applicationContext.getBean("bean1");
	}
	
	//使用静态工厂
	@Test
	public void test2(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
//		System.out.println(bean2);
	}
	
	//使用实例工厂
	@Test
	public void test3(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
	}
	
}
