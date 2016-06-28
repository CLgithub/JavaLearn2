package day39_spring.demo1;

import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao{

	@Override
	public void add() {
		System.out.println("添加用户");
	}

	@Override
	public void update() {
		System.out.println("修改用户");
	}

}
