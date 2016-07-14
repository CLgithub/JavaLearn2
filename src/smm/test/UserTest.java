package smm.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import smm.common.entity.User;
import smm.common.mapper.UserMapper;
import smm.day59esayui.service.UserService;

public class UserTest {
	
	
	@Test
	public void test1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("/day59_smm/applicationContext.xml");
		UserMapper userMapper=(UserMapper) applicationContext.getBean("userMapper");
		System.out.println(userMapper.selectByPrimaryKey(1));
	}
	
	@Test
	public void test2(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("/day59_smm/applicationContext.xml");
		UserService userService=(UserService) applicationContext.getBean("userService");
		System.out.println(userService.selectByPrimaryKey(1));
	}
	
}
