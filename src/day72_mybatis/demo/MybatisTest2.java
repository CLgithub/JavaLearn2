package day72_mybatis.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.startup.UserConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import day72_mybatis.demo.dao.UserDao;
import day72_mybatis.demo.dao.UserDaoImpl;
import day72_mybatis.demo.eneity.User;
import day72_mybatis.demo.eneity.UserCustom;
import day72_mybatis.demo.eneity.UserQueryVo;
import day72_mybatis.demo.mapper.UserMapper;

/*

SqlSessionFactoryBuilder
	以工具类方式来使用
SqlSessionFactory
	开发时，用spring以单例方式来管理
SqlSession
	是一个接口，面向用户，调用这些接口方法操作数据库
	问题：SqlSession能否用单例方式来使用
		不能，因为线程不安全，应该将其定义在方法体内，定义为局部变量
	
原始dao开发方式存在代码重复问题，硬编码问题，
使用mapper代理开发来解决
	mapper代理开发：
		mapper接口的完整类名			==			mapper.xml的namespace
		mapper接口中的方法名			==			mapper.xml中的statement的id
		mapper接口中的方法的参数类型	==			对于id的mapper.xml中的statement的parameterType
		mapper接口中的返回值类型		==			对于id的mapper.xml中的statement的resultType
	

*/
public class MybatisTest2 {
	private static SqlSessionFactory sqlSessionFactory;
	
	// 创建工厂
	@Before
	public void Init() {
		//加载配置文件 创建工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(this.getClass().getResourceAsStream("/day72_SqlMapConfig.xml"));
	}
	
	@Test
	public void testFindByid() throws Exception{
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void testFindByName() throws Exception{
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		List<User> list = userDao.findListByName("小明");
		System.out.println(list);
	}
	
	@Test
	public void testMapperFindByid() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void testMapperfindUserByName() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByName("小明");
		System.out.println(list);
	}
	
	@Test
	public void insertUser() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setBirthday(new Date());
		user.setUsername("ooxx");
		userMapper.insertUser(user);
		sqlSession.commit();
	}
	
	@Test
	public void deleteUser() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser(36);
		sqlSession.commit();
	}
	
	@Test
	public void updateUser() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setBirthday(new Date());
		user.setUsername("ooxx");
		user.setId(1);
		userMapper.updateUser(user);
		sqlSession.commit();
	}
	
	//测试通过包装类型查询用户信息
	@Test
	public void testfindUserList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
//		userCustom.setUsername("小");
		userCustom.setSex("1");
		userQueryVo.setUserCustom(userCustom);
		List<Integer> ids=new ArrayList<>();
		ids.add(16);
		ids.add(22);
		userQueryVo.setIds(ids);
		
		List<User> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}
	
	//测试通过包装类型查询用户条数
	@Test
	public void testfindUserCount() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setUsername("小明");
		userCustom.setSex("1");
		userQueryVo.setUserCustom(userCustom);
		List<Integer> ids=new ArrayList<>();
		ids.add(16);
		ids.add(22);
		userQueryVo.setIds(ids);
		
		int i=userMapper.findUserCount(userQueryVo);
		System.out.println(i);
	}
	
	//测试输出到resultMap
	@Test
	public void testResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		
		List<User> list = userMapper.findUserListMap(userQueryVo);
		System.out.println(list);
	}
}
