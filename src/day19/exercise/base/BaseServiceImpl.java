package day19.exercise.base;

import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> implements BaseService<T>{

	BaseDao<T> baseDao=new BaseDaoImal<>();
	
	@Override
	public void saveEntity(T t) {
		baseDao.saveEntity(t);
	}

	@Override
	public void deleteEntity(T t) {
		baseDao.deleteEntity(t);
	}

	@Override
	public void addOrUpdate(T t) {
		baseDao.addOrUpdate(t);
	}

	@Override
	public T findById(Integer id) {
		return baseDao.findById(id);
	}

	@Override
	public List<T> findAllT() {
		return baseDao.findAllT();
	}

	@Override
	public void batchEntityBySQL(String sql, Object... objects) {
		baseDao.batchEntityBySQL(sql, objects);
	}

	@Override
	public void executeSql(String sql, Object... objects) {
		baseDao.executeSql(sql, objects);
	}

	@Override
	public List<T> findListT(Class<T> clazz,String sql, Object... objects) {
		return baseDao.findListT(clazz,sql, objects);
	}

	@Override
	public List<Map> getListBySQl(String sql, Object... objects) {
		return baseDao.getListBySQl(sql, objects);
	}

}
