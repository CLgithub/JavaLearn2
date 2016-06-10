package day19_2.exercise.service;

import day19_2.exercise.base.BaseService;
import day19_2.exercise.entity.Users;

public interface UserService extends BaseService<Users> {

	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 * @author L
	 * @date 2016年6月10日
	 */
	Users login(String name, String password);

}
