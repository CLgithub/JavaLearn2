package day19_2;

public class Account {
	private Integer id;
	private String accountName;
	private Double money;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Account() {
	}

	public Account(Integer id, String accountName, Double money) {
		this.id = id;
		this.accountName = accountName;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + ", money=" + money + "]";
	}

	
}
