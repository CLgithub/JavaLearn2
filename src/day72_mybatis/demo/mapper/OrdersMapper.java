package day72_mybatis.demo.mapper;

import java.util.List;

import day72_mybatis.demo.eneity.OrderCustom;
import day72_mybatis.demo.eneity.Orders;
import day72_mybatis.demo.eneity.User;

public interface OrdersMapper {

	//一(多)对一查询	查询订单信息管理查询用户信息	使用restulType实现
	public List<OrderCustom> findOrderUserList();
	
	
	//一(多)对一查询	查询订单信息管理查询用户信息	使用restulMap实现
	public List<Orders> findOrderUserList2();
	
	//一对多查询	查询所有订单信息及订单下的订单明显信息
	public List<Orders> findOrderOrderdetailList();
	
	//一对多复杂查询	查询所有用户信息，关联查询订单及订单明细，订单明细信息中关联商品信息
	public List<User> findUserOrderItems();
	
}
