package day40_spring_tx.demo4;

public interface AccountService {
	
	/**
	 * 转账
	 * @author L
	 * @date 2016年6月30日
	 * @param from 
	 * @param to
	 * @param money
	 */
	public void transfer(String from,String to,Double money);
}
