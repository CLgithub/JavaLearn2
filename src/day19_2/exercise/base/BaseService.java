package day19_2.exercise.base;

import java.util.List;
import java.util.Map;

import day19_2.exercise.common.PageBean;

public interface BaseService<T> {
	
	/**
	 * 新增实体
	 * @author L
	 * @date 2016年6月6日
	 * @param t
	 * @return
	 */
	void saveEntity(T t);
	
	/**
	 * 删除实体
	 * @author L
	 * @date 2016年6月6日
	 * @param t
	 */
	void deleteEntity(T t);
	
	/**
	 * 存储或修改实体
	 * @author L
	 * @date 2016年6月6日
	 * @param t
	 */
	void addOrUpdate(T t);
	
	/**
	 * 根据id查询单个实体
	 * @author L
	 * @date 2016年6月6日
	 * @param id
	 * @return
	 */
	T findById(Integer id);
	
	/**
	 * 得到所有实体
	 * @author L
	 * @date 2016年6月6日
	 * @return
	 */
	List<T> findAllT();
	
	/**
	 * 批量处理
	 * @author L
	 * @date 2016年6月6日
	 * @param sql
	 * @param objects
	 */
	void batchEntityBySQL(String sql, Object[][] objects);
	
	/**
	 * 执行原始sql
	 * @author L
	 * @date 2016年6月5日
	 * @param sql
	 * @param objects
	 */
	void executeSql(String sql,Object... objects);
	
	/**
	 * 查询实体列表
	 * @author L
	 * @date 2016年6月5日
	 * @param sql
	 * @param objects
	 * @return
	 */
	List<T> findListT(Class<T> clazz,String sql,Object... objects);
	
	/**
	 * 查询listMap
	 * @author L
	 * @date 2016年6月6日
	 * @param sql
	 * @param objects
	 * @return
	 */
	Map<String,Object> getListBySQl(String sql, Object... objects);
	
	/**
	 * 根据sql封装的到pageBean
	 * @param sql 原sql
	 * @param page 第几页
	 * @param pageSize 每页显示多少条
	 * @return
	 * @author L
	 * @date 2016年6月11日
	 */
	PageBean getPageBean(Class<T> clazz,String sql, Integer page, Integer pageSize, Object...objects);
	
	/**
	 * 根据sql得到mysql的分页sql
	 * @param sql 原sql
	 * @param page 第几页
	 * @param pageSize 每页显示多少条
	 * @return	分页sql
	 * @author L
	 * @date 2016年6月11日
	 */
	String getMysqlPageSql(String sql, Integer page, Integer pageSize) ;
	
	
}
