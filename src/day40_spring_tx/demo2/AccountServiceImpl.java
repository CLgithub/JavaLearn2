package day40_spring_tx.demo2;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value="accountService")
public class AccountServiceImpl implements AccountService{

	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	@Override
	public void transfer(String from, String to, Double money) {
		accountDao.out(from, money);
//		int d=1/0;
		accountDao.in(to, money);
	}

}
