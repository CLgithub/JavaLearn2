package day19_2.exercise.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import day19_2.exercise.common.PageBean;
import day19_2.exercise.dao.UserDao;
import day19_2.exercise.entity.Contact19_2;

public class BaseServiceImpl<T> implements BaseService<T>{
	
	private BaseDao<T> baseDao;

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

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
	public void batchEntityBySQL(String sql, Object[][] objects) {
		baseDao.batchEntityBySQL(sql, objects);
	}

	@Override
	public void executeSql(String sql, Object... objects) {
		baseDao.executeSql(sql, objects);
	}

	@Override
	public List<T> findListT(String sql, Object... objects) {
		return baseDao.findListT(sql, objects);
	}

	@Override
	public List<Map<String,Object>> getListBySQl(String sql, Object... objects) {
		return baseDao.getListBySQl(sql, objects);
	}
	
	@Override
	public PageBean getPageBean(String sql, Integer page, Integer pageSize, Object...objects) {
		String pageSql=this.getMysqlPageSql(sql, page, pageSize);
		List<T> list = this.findListT(pageSql, objects);
		Integer allRow = this.getTotlaBySql(sql, objects);// 得到总的记录长度
		PageBean pageBean = new PageBean();
		pageBean.setTotal(allRow);
		pageBean.setRows(list);
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		return pageBean;
	}

	private Integer getTotlaBySql(String sql, Object... objects) {
		int index = sql.toLowerCase().indexOf("from");
		String subString = sql.substring(index);
		String newSql = "select count(*) as count " + subString;
		List<Map<String,Object>> list = this.getListBySQl(newSql, objects);
		Object count =  list.get(0).get("count");
		return Integer.valueOf(count.toString());
	}

	@Override
	public String getMysqlPageSql(String sql, Integer page, Integer pageSize) {
		return sql+=" limit "+(page-1)*pageSize+","+pageSize;
	}

	

}
