package day39_spring_jdbc;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringTest1 {
	private static ApplicationContext applicationContext;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("applicationContext_day39_5_jdbc1.xml");
	}
	@Test
	public void test1(){
		//创建连接池
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		//设置参数
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdb1");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		//创建jdbc模板
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		String sql="create table user(id int primary key auto_increment,name varchar(20))";
		jdbcTemplate.execute(sql);
	}
	
	@Test
	public void  test2() {
//		Object bean = applicationContext.getBean("dataSource1");
//		System.out.println(bean);
		JdbcTemplate jdbcTemplate1 = (JdbcTemplate) applicationContext.getBean("jdbcTemplate1");
		String sql="create table user1(id int primary key auto_increment,name varchar(20))";
		jdbcTemplate1.execute(sql);
	}
}
