package day72_mybatis.demo.mapper;

import java.util.List;

import day72_mybatis.demo.eneity.User;
import day72_mybatis.demo.eneity.UserQueryVo;

public interface UserMapper {
	
	/**
	 * 根据id查询用户
	 */
	public User findUserById(int id) throws Exception;
	
	/**
	 * 根据用户名名称模糊查询用户列表
	 */
	public List<User> findUserByName(String userName) throws Exception;
	
	/**
	 * 新增用户
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * 删除用户
	 */
	public void deleteUser(int id) throws Exception;
	
	/**
	 * 修改用户
	 */
	public void updateUser(User user) throws Exception;
	
	/**
	 * 自定义查询调节查询用户列表
	 * @param userQueryVo user包装类型
	 */
	public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 查询输出用resultMap映射
	 */
	public List<User> findUserListMap(UserQueryVo userQueryVo) throws Exception;
	
	/**
	 * 自定义查询调节查询用户列表条数
	 * @param userQueryVo user包装类型
	 */
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	
	
	
	
}
