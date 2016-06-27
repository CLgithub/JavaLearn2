package day38_spring.demo7;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
 * 注解的方式装配bean
 */
//@Component("userService")
@Service(value="userService")
public class UserService {
	public void sayHello() {
		System.out.println("UserService.sayHello()");
	}
}
