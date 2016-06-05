package day17.exercise.dao;

import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * 更新
	 * @author L
	 * @date 2016年6月5日
	 * @param sql
	 * @param objects
	 */
	void updateBySql(String sql,Object... objects);
	
	/**
	 * 查询实体列表
	 * @author L
	 * @date 2016年6月5日
	 * @param sql
	 * @param objects
	 * @return
	 */
	List<T> findListT(String sql,Object... objects);
}
