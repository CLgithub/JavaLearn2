package day72_mybatis.demo;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import day72_mybatis.demo.eneity.User;

/*
4.mybatis入门程序
	4.1	需求
		实现用户查询：
			根据用户id（主键）查询用户信息（单条记录）
			根据用户名称模糊查询用户信息（多条记录）
		用户添加
		用户删除 
		用户修改
	4.2	导入jar包
		从mybatis管网下载（地址：https://github.com/mybatis/mybatis-3/releases）
		或maven
	4.3	log4j.properties（公用文件）
	4.4	day72_SqlMapConfig.xml(公用文件)
		通过SqlMapConfig.xml加载mybatis运行环境。
				/JavaLearn2/config/day72_SqlMapConfig.xml
	4.5 pojo(User.java)(entiey)
				day72_mybatis.demo.eneity.User
	4.6	mapper.xml
		建议命名规则，表名+mapper.xml
		早期		表名.xml
				/JavaLearn2/config/day72sqlmap/user.xml
	
	4.7.测试


mybatis开发过程小结
	1.编写sqlMapConfig.xml
	2.编写mapper.xml
		定义了statement
	3.编程通过配置文件创建sqlSessionFactory
	4.通过SqlSessionFactory获取SqlSession
	5.通过SqlSession操作数据库
		如果执行添加，更新，删除需要调用SqlSession.commit();
	6.SqlSession使用完成要关闭
	
	
mybatis与hibernate适用场景
	mybatis：
		mybatis需要程序员自己编写sql语句，是一个不完全的orm框架，
			对sql的修改和优化非常容易实现
		适合开发需求变更频繁的系统，比如：互联网项目
	hibernate：
		不用写sql语句，使用一个orm框架
		需求固定，对象数据模型稳定，中小型项目，企业oa系统
		
sqlMapConfig.xml
是mybatis全局配置文件：只有一个，名称不固定，主要mapper.xml mypper.xml中配置sql语句
	mapper.xml
	mapper.xml是以sttement为单位进行配置，（把一个sql封装为一个statement），statement中配置sql语句，
	parameterType输入参数类型（完成输入映射），
	resultType输出参数类型（完成输出映射），
	parameterMap配置输入参数类型（过期）
	resultMap配置输出结果类型，（一对多，多对多）
	
	

 */
public class MybatisTest1 {

	private static SqlSessionFactory sqlSessionFactory;
	
	// 创建工厂
	@Before
	public void Init() {
		//加载配置文件 创建工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(this.getClass().getResourceAsStream("/day72_SqlMapConfig.xml"));
	}

	// 测试根据id查询用户（得到单条记录）
	@Test
	public void testFindUserById() {
		//通过sqlsessionFactory创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession操作数据库
		//selectOne查询一条记录	statement=namespace+"."+statement的id	parameter动态参数
		Object object = sqlSession.selectOne("test1.findUserById", 10);
		System.out.println(object);
		//关闭sqlSession
		sqlSession.close();
	}
	
	@Test
	public void testFindUserByName() {
		//通过sqlsessionFactory创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			//通过sqlSession操作数据库
			//selectOne查询一条记录	statement=namespace+"."+statement的id	parameter动态参数
			List<User> list = sqlSession.selectList("test1.findUserByName", "小明");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//关闭sqlSession
			sqlSession.close();
		}
	}
	
	//插入用户
	@Test
	public void testinsertUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		try {
			user.setUsername("小红");
			user.setBirthday(new Date());
			sqlSession.insert("test1.insertUser", user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//关闭sqlSession
			sqlSession.close();
		}
		System.out.println(user.getId());
	}
	
	//删除用户
	@Test
	public void deleteUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test1.deleteUser", 32);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//修改用户
	@Test
	public void updateUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(1);
		user.setUsername("abc");
		user.setAddress("xxoo");
		user.setBirthday(new Date());
		user.setSex("0");
		sqlSession.update("test1.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
}
