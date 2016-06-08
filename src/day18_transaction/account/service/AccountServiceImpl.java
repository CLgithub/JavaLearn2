package day18_transaction.account.service;

import java.sql.Connection;
import java.sql.SQLException;

import day17.Demo2JdbcUtil;
import day18_transaction.account.dao.AccountDao;
import day18_transaction.account.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService{
	private Connection connection;
	
	public AccountServiceImpl() {
		this.connection=Demo2JdbcUtil.getConnect();
	}
	
	@Override
	public void account(String accountin, String accountout, double money) throws Exception {
//		AccountDao dao=new AccountDaoImpl(connection);
		AccountDao dao=new AccountDaoImpl();
		
		try {
			//开启事务	设置自动提交为false
			connection.setAutoCommit(false);
			dao.accountout(accountout,money);
			dao.accountin(accountin,money);
			
		} catch (Exception e) {
			e.printStackTrace();
			//如果出现异常，则回滚
			try {
				if(connection!=null){
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;
		} finally{
			//提交事务，关闭连接
			try {
				if(connection!=null){
					connection.commit();
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
