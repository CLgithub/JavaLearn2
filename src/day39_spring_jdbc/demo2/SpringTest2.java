package day39_spring_jdbc.demo2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringTest2 {
	
	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext_day39_5_jdbc1.xml");
	}
	
	@Test
	public void test1(){
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		User user = new User();
		user.setName("小明1");
		user.setId(1);
		userDao.add(user);
//		userDao.update(user);
//		userDao.delete(user);
	}
	
	@Test
	public void test2(){
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		User user = userDao.findByID(2);
		System.out.println(user);
	}
	
	@Test
	public void test3(){
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		Integer i = userDao.findCount();
		System.out.println(i);
	}
}
