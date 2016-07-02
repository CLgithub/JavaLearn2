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
		System.out.println(list);
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




	
	
}
