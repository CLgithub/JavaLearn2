package day40_spring_tx.demo3;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="accountDao")
public class AccountDao {
	
	@Resource(name="jdbcTemplate1")
	private JdbcTemplate jdbcTemplate;
	
	public void out(String from,Double money) {
		String sql="update account set money=money-? where name=?";
		jdbcTemplate.update(sql,money,from);
	}
	
	public void in(String to,Double money) {
		String sql="update account set money=money+? where name=?";
		jdbcTemplate.update(sql,money,to);
	}
}
