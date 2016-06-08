package day18_transaction.account.service;

public interface AccountService {

	/**
	 * 汇款
	 * @author L
	 * @date 2016年6月8日
	 * @param accountin 转入账户名称
	 * @param accountout 转出账号名称
	 * @param money 汇款金额
	 */
	void account(String accountin, String accountout, double money) throws Exception;

}
