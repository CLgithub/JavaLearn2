package day19_2.exercise.service;

import java.util.List;
import day19_2.exercise.base.BaseServiceImpl;
import day19_2.exercise.dao.UserDao;
import day19_2.exercise.entity.Users;

public class UserServiceImpl extends BaseServiceImpl<Users> implements UserService {
	
	public UserServiceImpl() {
		setBaseDao(new UserDao());
	}
	
	@Override
	public Users login(String name, String password) {
		String sql="select * from users where name=? and password=?";
		List<Users> list = this.findListT(sql, name, password);
		if(list.isEmpty()){
			return null;
		}else {
			return list.get(0);
		}
	}

}
