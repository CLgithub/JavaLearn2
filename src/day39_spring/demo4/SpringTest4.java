package day39_spring.demo4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day39_spring.demo2.CustomeService;
import day39_spring.demo2.CustomerServiceImpl;
import day39_spring.demo3.OrderService;
import day39_spring.demo3.OrderServiceImpl;

/*
自动代理:
	前面的案例中，每个代理都是通过ProxyFactoryBean织入切面代理，在实际开发中，
		非常多的Bean每个都配置ProxyFactoryBean开发维护量巨大

	自动创建代理(*****基于后处理Bean.在Bean创建的过程中完成的增强.生成Bean就是代理.)
		BeanNameAutoProxyCreator 根据Bean名称创建代理 
		DefaultAdvisorAutoProxyCreator 根据Advisor本身包含信息创建代理
			AnnotationAwareAspectJAutoProxyCreator 基于Bean中的AspectJ 注解进行自动代理
			
	
	基于proxyFattoryBean代理与自动代理的区别？
		proxyFattoryBean先有被代理对象，将被代理对象传入到代理类中生成代理
		自动代理基于后处理bean，在bean生成的过程中，就产生了代理对象，spring返回的就是已经是代理对象

*/
public class SpringTest4 {
	
	private static ApplicationContext applicationContext;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("applicationContext_day39_2.xml");
	}
	
	@Test
	public void test1(){
		OrderService orderService = (OrderService) applicationContext.getBean("orderService");
		CustomeService customeService = (CustomeService) applicationContext.getBean("customerService");
		orderService.add();
		orderService.delete();
		customeService.update();
		customeService.query();
		customeService.add();
	}
}
