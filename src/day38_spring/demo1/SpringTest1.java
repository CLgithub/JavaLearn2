package day38_spring.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringTest1 {
	
	//传统方式
	@Test
	public void demo1(){
		HelloService helloService=new HelloServiceImpl();
		helloService.sayHello();
	}
	
	
	//spring开发
	@Test
	public void demo1_spring(){
		//创建了一个工厂类
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day38.xml");
		HelloService helloService = (HelloService) applicationContext.getBean("HelloService");
		helloService.sayHello();
	}
	
	//spring开发
	@Test
	public void demo1_spring_2(){
		//从文件系统里去加载配置文件
		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("applicationContext_day38.xml");
		HelloService helloService = (HelloService) applicationContext.getBean("HelloService");
		helloService.sayHello();
	}
	
	//BeanFactory
	@Test
	public void demo1_BeanFactory(){
		BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("applicationContext_day38.xml"));
//		BeanFactory beanFactory=new XmlBeanFactory(new FileSystemResource("applicationContext_day38.xml"));
		HelloService helloService = (HelloService) beanFactory.getBean("HelloService");
		helloService.sayHello();
	}
		
}
	
