package day40_spring_tx.demo2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
声明式事务管理（原始方式）
使用原始的TransactionProxyFactoryBean完成事务
	之前的编程式完成事务相当于是增强，是增强的话就可以用代理对象来增强



*/
public class SpringTest2 {
	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext_day40_tx2.xml");
	}
	
	@Test
	public void test1(){
		//使用代理对象来操作
		AccountService accountService = (AccountService) applicationContext.getBean("accountServiceProxy");
		accountService.transfer("aaa", "bbb", 100.0);
	}
}
