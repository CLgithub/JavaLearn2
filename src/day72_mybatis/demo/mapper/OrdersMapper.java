package day72_mybatis.demo.mapper;

import java.util.List;

import day72_mybatis.demo.eneity.OrderCustom;
import day72_mybatis.demo.eneity.Orders;

public interface OrdersMapper {

	//一(多)对一查询	查询订单信息管理查询用户信息	使用restulType实现
	public List<OrderCustom> findOrderUserList();
	
	
	//一(多)对一查询	查询订单信息管理查询用户信息	使用restulMap实现
	public List<Orders> findOrderUserList2();
	
	//一对多查询	查询所有订单信息及订单下的订单明显信息
	public List<Orders> findOrderOrderdetailList();
	
}
