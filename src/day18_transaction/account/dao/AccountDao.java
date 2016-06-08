package day18_transaction.account.dao;

import java.sql.SQLException;

public interface AccountDao {

	/**
	 * 从这个账户的钱减去money的金额
	 * @author L
	 * @date 2016年6月8日
	 * @param accountout 账户名称
	 * @param money
	 * @throws Exception	异常全部抛到service层，有异常必须要回滚
	 */
	void accountout(String accountout, double money) throws Exception;

	/**
	 * 从这个账户的钱加上money的金额
	 * @author L
	 * @date 2016年6月8日
	 * @param accountin 账户名称
	 * @param money
	 * @throws Exception
	 */
	void accountin(String accountin, double money) throws Exception;

}
