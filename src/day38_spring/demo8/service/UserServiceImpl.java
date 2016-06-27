package day38_spring.demo8.service;

import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl implements UserService{

	@Override
	public void sayHello() {
		System.out.println("UserServiceImpl.sayHello()");
	}

}
