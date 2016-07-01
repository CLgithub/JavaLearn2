package day72_mybatis.demo.mapper;

import java.util.List;

import day72_mybatis.demo.eneity.User;

public interface UserMapper {
	
	/**
	 * 根据id查询用户
	 * @author L
	 * @date 2016年7月1日
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findUserById(int id) throws Exception;
	
	/**
	 * 根据用户名名称模糊查询用户列表
	 * @author L
	 * @date 2016年7月1日
	 * @param userName
	 * @return
	 */
	public List<User> findUserByName(String userName) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	
}
