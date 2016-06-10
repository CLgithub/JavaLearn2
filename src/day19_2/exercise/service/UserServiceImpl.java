package day19_2.exercise.service;

import java.util.List;

import day19_2.exercise.base.BaseServiceImpl;
import day19_2.exercise.entity.Users;

public class UserServiceImpl extends BaseServiceImpl<Users> implements UserService {

	@Override
	public Users login(String name, String password) {
		String sql="select * from users where name=? and password=?";
		List<Users> list = this.findListT(Users.class, sql, name, password);
		if(list.isEmpty()){
			return null;
		}else {
			return list.get(0);
		}
	}

}
