package day38_spring.demo7;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
 * 注解的方式装配bean
 */
//@Component("userService")
@Service(value="userService")
public class UserService {
	
	//普通属性
	@Value(value="aaaa")
	private String info;
	
	//对象属性	
//	//@Autowired:自动装配默认使用类型注入.
//	@Autowired(required=false)		//(required=false)忽略依次
//	@Qualifier("userDao")	//按名称注入
//	private UserDao userDao;
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void sayHello() {
		System.out.println("UserService.sayHello()"+",info:"+info);
	}

	@Override
	public String toString() {
		return "UserService [info=" + info + ", userDao=" + userDao + "]";
	}
	
}
