package day39_spring.demo3;

import org.springframework.stereotype.Service;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService{

	public void add() {
		System.out.println("添加订单");
	}

	public void delete() {
		System.out.println("删除订单");
	}

	public void update() {
		System.out.println("修改订单");
	}

	public void query() {
		System.out.println("查询订单");
	}

}
