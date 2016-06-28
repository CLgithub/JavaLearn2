package day39_spring.demo3;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day39_spring.demo2.CustomeService;

/*

	带有切点的切面:(针对目标对象的某些方法进行增强)
	编写增强类
		day39_spring.demo3.MyAroundAdvice
	生成代理
		
		
*/
public class SpringTest3 {
private static ApplicationContext applicationContext;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("applicationContext_day39_1.xml");
	}
	
	@Test
	public void test1(){
//		OrderService orderService = (OrderService) applicationContext.getBean("orderService");
//		orderService.add();
		OrderService orderService = (OrderService) applicationContext.getBean("orderServiceProxy");
		orderService.add();
		orderService.query();
		orderService.update();
	}
}
