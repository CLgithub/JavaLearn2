package day39_spring.demo2;

import org.springframework.stereotype.Service;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomeService{

	@Override
	public void add() {
		System.out.println("添加客户");
	}

	@Override
	public void delete() {
		System.out.println("删除客户");
	}

	@Override
	public void update() {
		System.out.println("修改客户");
	}

	@Override
	public void query() {
		System.out.println("查询客户");
	}

}
