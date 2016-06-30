package day40_spring_tx.demo1;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service(value="accountService")
public class AccountServiceImpl implements AccountService{

	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	//注入事务管理的模板
	@Resource(name="transactionTemplate")
	public TransactionTemplate transactionTemplate;
	
	//手动编程完成事务管理
	@Override
	public void transfer(String from, String to, Double money) {
		//使用事务模板来执行业务逻辑
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				accountDao.out(from, money);
				int d=1/0;
				accountDao.in(to, money);
			}
		});
	
	}

}
