package day40_spring_tx.demo3;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
声明式事务管理（基于切面）
	步骤：
		1.导入jar包，引用头文件（aop，事务管理）
		2.注册事务管理器
		3.注册事务增强
		4. 配置切面和切点，利用aop，把增强和切点组合起来
		
*/
public class SpringTest3 {
	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext_day40_tx3.xml");
	}
	
	@Test
	public void test1(){
		//使用代理对象来操作
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.transfer("aaa", "bbb", 100.0);
	}
}
