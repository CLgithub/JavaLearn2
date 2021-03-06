package day72_mybatis.demo2_mybatisspring;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day72_mybatis.demo.dao.UserDao;
import day72_mybatis.demo.dao.UserDaoImpl;
import day72_mybatis.demo.dao.UserDaoImpl2;
import day72_mybatis.demo.eneity.Orders;
import day72_mybatis.demo.eneity.User;
import day72_mybatis.demo.mapper.OrdersMapper;
import day72_mybatis.demo.mapper.UserMapper;
import day72_mybatis.demo2_mybatisspring.entity.EntityTest1;
import day72_mybatis.demo2_mybatisspring.entity.EntityTest2;
import day72_mybatis.demo2_mybatisspring.mapper.EntityTest1Mapper;
import day72_mybatis.demo2_mybatisspring.mapper.EntityTest2Mapper;


/*
mybatis和spring整合
	mybaits和spring整合的思路
		1、让spring管理SqlSessionFactory
		2、让spring管理mapper对象和dao。
			使用spring和mybatis整合开发mapper代理及原始dao接口。
			自动开启事务，自动关闭 sqlsession.
		
		3、让spring管理数据源( 数据库连接池)
		
	导入jar包：
		mybatis-spring-1.2.3.jar
	配置文件
		log4j.properties
		SqlMapconfig.xml(day73_SqlMapConfig_spring.xml)
			mybatis配置文件：别名、settings，数据源不在这里配置
		applicationContext.xml
			1、数据源（连接池）
			2、SqlSessionFactory
			3、mapper或dao


		
		

 */
public class Doc3 {
	
	private static ApplicationContext applicationContext;
	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext_day72_mybatis.xml");
		//加载配置文件 创建工厂
				sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(Doc3.class.getResourceAsStream("/day72_SqlMapConfig.xml"));
	}
	
	//原始dao测试，不使用spring
	@Test
	public void test1() throws Exception{
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(10);
		System.out.println(user);
	}
	
	//原始dao测试，使用spring
	@Test
	public void test1_spring() throws Exception{
		UserDaoImpl2 userDao=(UserDaoImpl2) applicationContext.getBean("userDao");
		User user = userDao.findUserById(10);
		System.out.println(user);
	}
	
	//用spring管理mapper测试
	@Test
	public void test2_spirng() throws Exception{
		EntityTest1Mapper entityTest1Mapper = (EntityTest1Mapper) applicationContext.getBean("entityTest1Mapper");
		EntityTest1 test1 = entityTest1Mapper.findById(1);
		System.out.println(test1);
	}
	
	//用spring管理mapper测试
	@Test
	public void test3_spirng() throws Exception{
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		List<User> list = userMapper.findUserByName("小白");
		System.out.println(list);
	}
	
	//用spring管理mapper测试	逆向工程生成代码测试
	@Test
	public void test4_spirng() throws Exception{
		EntityTest2Mapper entityTest2Mapper = (EntityTest2Mapper) applicationContext.getBean("entityTest2Mapper");
//		System.out.println(entityTest2Mapper);
		EntityTest2 entityTest2 = entityTest2Mapper.selectByPrimaryKey(3);
		System.out.println(entityTest2);
	}
	
	
	
}
