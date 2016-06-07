package day19.exercise.base;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
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
	void batchEntityBySQL(String sql, Object... objects);
	
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
	List<Map> getListBySQl(String sql, Object... objects);
}
