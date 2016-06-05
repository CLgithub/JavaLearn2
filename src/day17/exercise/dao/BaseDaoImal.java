package day17.exercise.dao;

import java.util.List;

public class BaseDaoImal<T> implements BaseDao<T>{

	@Override
	public void updateBySql(String sql, Object... objects) {
		
	}

	@Override
	public List<T> findListT(String sql, Object... objects) {
		return null;
	}
	
}
