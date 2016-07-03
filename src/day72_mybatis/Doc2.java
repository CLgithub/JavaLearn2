package day72_mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import day72_mybatis.demo.eneity.OrderCustom;
import day72_mybatis.demo.eneity.Orders;
import day72_mybatis.demo.eneity.User;
import day72_mybatis.demo.mapper.OrdersMapper;
import day72_mybatis.demo.mapper.UserMapper;

/*
	用户表user：
		记录了购买商品的用户
	订单表orders：
		记录了用户所创建的订单信息
	订单明细表orderdetail：
		记录了用户创建订单的详细信息
	商品信息表items：
		记录了商家提供的商品信息

分析表与表之间的关系：
	用户user和订单orders：
		user---->orders：一个用户可以创建多个订单   一对多
		orders-->user：一个订单只能由一个用户创建  一(多)对一 
	订单orders和订单明细orderdetail：
		orders-->orderdetail：一个订单可以包括多个订单明细  一对多
		orderdetail-->orders：一个订单明细只属于一个订单  一（多）对一
	订单明细orderdetail和商品信息items：
		orderdetail-->items：一个订单明细对应一个商品信息 一（多）对一
		items--> orderdetail：一个商品对应多个订单明细  一对多
		
		
延时加载：
	延时加载意义：
		在进行数据查询时，为了提高数据库查询性能，尽量使用单表查询，因为单表查询比多表关联查询速度要快。
		如果查询单表就可以满足需求，一开始先查询单表，当需要关联信息时，再关联查询，当需要关联信息再查询这个叫延迟加载。
		mybatis中resultMap提供延迟加载功能，通过resultMap配置延迟加载
		
	配置延时加载：
		在总配置中
			打开延时加载开关：lazyLoadingEnabled
			关闭立即加载开关：aggressiveLazyLoading
			<settings>
				<setting name="lazyLoadingEnabled" value="true"/>
				<setting name="aggressiveLazyLoading" value="false"/>
			</settings>
			
	
mybatis缓存
		mapper通过sqlsession去操作数据库，
			一级缓存sqlSession级别，两次操作针对一个sqlSession，
			二级缓存mapper级别，只要是同一个mapper，不同的sqlSession查询都可以缓存
	
	一级缓存是一个SqlSession级别，sqlsession只能访问自己的一级缓存的数据，
	二级缓存是跨sqlSession，是mapper级别的缓存，对于mapper级别的缓存不同的sqlsession是可以共享的。（看图：一级缓存和二级缓存.png）
	
	一级缓存：
		mybatis默认支持一级缓存不需要配置
		注意：mybatis和spring整合后进行mapper代理开发，不支持一级缓存，因为mybatis和spring整合，spring按照mapper的模版生成mapper代理对象
		模版中在最后统一关闭sqlsession
		
	二级缓存：
		范围是mapper级别，（mapper同一个命名空间），mapper以命名空间为单位创建缓存数据结构，结构是map<key,value>
		配置二级缓存：
			1.开启二级缓存总开关
			2.在mapper映射文件上也配置开启
			3.查询结果的实体类要序列化（原因：二级缓存可以将内存数据写到磁盘）
			
		每次查询，先看是否开启二级缓存，如果开启二级缓存，就查询二级缓存，如果没有取到，再从一级缓存中查询，如果没找到，就查询数据库
		
			禁用二级缓存
				<select id="findUserById" parameterType="int" resultType="user" useCache="false">
				默认是true，
			刷新缓存
				设置该方法commit的时候是否刷新缓存
				<insert id="insertUser" parameterType="day72_mybatis.demo.eneity.User" flushCache="true" >
				默认是true
				

 */
public class Doc2 {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	// 创建工厂
	@Before
	public void Init() {
		//加载配置文件 创建工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(this.getClass().getResourceAsStream("/day72_SqlMapConfig.xml"));
	}
	
	//一(多)对一查询	查询订单信息管理查询用户信息
	//select orders.*,user.username,user.sex from orders left join user on orders.user_id=user.id;
	//先使用restulType实现
	@Test
	public void test1(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrderCustom> list= mapper.findOrderUserList();
		System.out.println(list);
	}
	
	//一(多)对一查询	查询订单信息管理查询用户信息
	//使用restulMap实现
	@Test
	public void test2(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> list= mapper.findOrderUserList2();
		for(Orders orders:list){
			System.out.println(orders);
		}
	}
	
	//一对多查询	查询所有订单信息及订单下的订单明显信息
	//select orders.*,orderdetail.id orderdetail_id,orderdetail.items_id,orderdetail.items_num from orders left join orderdetail on orders.id=orderdetail.orders_id;
	@Test
	public void test3(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> list= mapper.findOrderOrderdetailList();
		for(Orders orders:list){
			System.out.println(orders);
		}
	}
	
	//一对多复杂查询	查询所有用户信息，关联查询订单及订单明细，订单明细信息中关联商品信息
	//select user.*,orders.number,orders.createtime,orderdetail.items_num,items.name,items.price,items.detail
	//	from user left join orders on user.id=orders.user_id left join orderdetail on orders.id=orderdetail.orders_id 
	//left join items on orderdetail.items_id=items.id
	@Test
	public void test4(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<User> list= mapper.findUserOrderItems();
		for(User orders:list){
			System.out.println(orders);
		}
	}
	
	
	//一对一延时加载
	@Test
	public void test5(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> list= mapper.findOrderUserlazyLoading();
		for(Orders orders:list){
			System.out.println(orders);
		}
	}
	
	//一对多延时加载
	@Test
	public void test6(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> list= mapper.findOrderOrderdetailListlazyLoading();
		for(Orders orders:list){
			System.out.println(orders);
		}
	}
	
	
	//一级缓存测试
	@Test
	public void test7() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//第一次：查询id为1的用户
		User user1 = mapper.findUserById(1);
		System.out.println(user1);
		//中间有commit操作	，会情况缓存，目的是为了避免脏数据
//		user1.setUsername("aa");
//		mapper.updateUser(user1);
//		sqlSession.commit();
		
		//第二次：查询id为1的用户
		User user2 = mapper.findUserById(1);
		System.out.println(user2);
		
		sqlSession.close();
	}
	
	//二级缓存测试
	@Test
	public void test8() throws Exception{
		SqlSession sqlSession1=sqlSessionFactory.openSession();
		SqlSession sqlSession2=sqlSessionFactory.openSession();
		SqlSession sqlSession3=sqlSessionFactory.openSession();
//		System.out.println(sqlSession1==sqlSession2);	//false 两个不同的session
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
//		System.out.println(mapper1==mapper2);	//false	两个不同的mapper对象
		
		User user1 = mapper1.findUserById(1);
		System.out.println(user1);
		sqlSession1.close();
		
		//提交commit的时候就会刷新缓存
		user1.setUsername("aa");
		mapper3.updateUser(user1);
		sqlSession3.commit();
		
		
		User user2 = mapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();
	}
	 


	
	
}
