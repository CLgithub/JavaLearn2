package day39_spring_jdbc.demo2;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


/*
Spring框架中提供了对持久层技术支持的类:
JDBC			:org.springframework.jdbc.core.support.JdbcDaoSupport
Hibernate 3.0	:org.springframework.orm.hibernate3.support.HibernateDaoSupport
iBatis			:org.springframework.orm.ibatis.support.SqlMapClientDaoSupport

	更详细的封装查看BeasServiceImpl
*/

@Repository(value="userDao")
public class UserDao /*extends JdbcDaoSupport*/{
	
	@Resource(name="jdbcTemplate1")
	public JdbcTemplate jdbcTemplate;
	
	public void add(User user) {
		String sql="insert into user values(null,?)";
		int i = this.jdbcTemplate.update(sql, user.getName());
	}

	public void update(User user) {
		String sql="update user set name=? where id=?";
		int i = this.jdbcTemplate.update(sql, user.getName(),user.getId());
	}

	public void delete(User user) {
		String sql="delete from user where id=?";
		int i = this.jdbcTemplate.update(sql, user.getId());
	}
	
	public User findByID(Integer id) {
		String sql="select * from user where id=?";
//		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), id);
//		return list.get(0);
		User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
		return user;
	}
	
	public Integer findCount() {
		String sql="select count(1) as count from user";
		Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return integer;
	}

}
