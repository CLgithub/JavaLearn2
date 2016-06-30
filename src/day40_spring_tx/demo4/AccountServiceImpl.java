package day40_spring_tx.demo4;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/*
@Transactional
	isolation		设置事务隔离级别
	propagation		传播特性
 */

@Service(value="accountService")
@Transactional(isolation=Isolation.DEFAULT)	//该类开启事务
public class AccountServiceImpl implements AccountService{

	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	@Override
	public void transfer(String from, String to, Double money) {
		accountDao.out(from, money);
		int d=1/0;
		accountDao.in(to, money);
	}

}
