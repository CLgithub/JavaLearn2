package day39_spring.demo6;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import day39_spring.demo6.service.RoleService;

/*
基于xml开发AspectJ的AOP
	步骤：
		1.编写被增强的类
			day39_spring.demo6.service.RoleService
		2.编写切面类
			day39_spring.demo6.MyAspectXML
		3.配置
			详情看/JavaLearn2/config/applicationContext_day39_4.xml
			
*/
public class SpringTest6 {
	private static ApplicationContext applicationContext;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("applicationContext_day39_4.xml");
	}
	
	@Test
	public void test1(){
		RoleService roleService = (RoleService) applicationContext.getBean("roleService");
		roleService.add();
		roleService.update();
	}
}
