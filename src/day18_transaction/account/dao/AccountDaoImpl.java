package day18_transaction.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day17.Demo2JdbcUtil;

public class AccountDaoImpl implements AccountDao {

	private Connection connecttion;

	public AccountDaoImpl(Connection connecttion) {
		this.connecttion = connecttion;
	}
	public AccountDaoImpl() {
		this.connecttion=Demo2JdbcUtil.getConnect();	//已经存入了ThreadLocal中，和service中的是同一个
	}


	@Override
	public void accountout(String accountout, double money) throws Exception {
		String sql = "update account set money=money-? where accountName=?";
		PreparedStatement prepareStatement=null;
		prepareStatement= connecttion.prepareStatement(sql);
		prepareStatement.setDouble(1, money);
		prepareStatement.setString(2, accountout);
		int i = prepareStatement.executeUpdate();
		if(i==0){
			throw new Exception("转出失败");
		}
		prepareStatement.cancel();
	}

	@Override
	public void accountin(String accountin, double money) throws Exception {
		String sql = "update account set money=money+? where accountName=?";
		PreparedStatement prepareStatement=null;
		prepareStatement= connecttion.prepareStatement(sql);
		prepareStatement.setDouble(1, money);
		prepareStatement.setString(2, accountin);
		int i =prepareStatement.executeUpdate();
		if(i==0){
			throw new Exception("转入失败");
		}
		prepareStatement.cancel();
	}

}
