package day39_spring.demo5.service;

import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl implements UserService{

	public int add() {
		System.out.println("添加用户");
		return 1;
	}

	public void delete() {
		System.out.println("删除用户");
	}

	public void update() {
		System.out.println("修改用户");
	}

	public void query() {
		System.out.println("查询用户");
		int d=1/0;
	}

}
