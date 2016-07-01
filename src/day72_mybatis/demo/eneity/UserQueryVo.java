package day72_mybatis.demo.eneity;

/**
 * User包装类
 * 将在使用的时候，从页面传到controller，service，mapper
 * @author L
 * @date 2016年7月1日
 */
public class UserQueryVo {

	// 用户信息
	private User user;

	// 自定义user的扩展对象
	private UserCustom userCustom;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

}
