package day72_mybatis.demo.eneity;

import java.util.List;

/**
 * User包装类 将在使用的时候，从页面传到controller，service，mapper
 * 
 * @author L
 * @date 2016年7月1日
 */
public class UserQueryVo {

	// 用户信息
	private User user;

	// 自定义user的扩展对象
	private UserCustom userCustom;

	// 用户ids集合
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

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
