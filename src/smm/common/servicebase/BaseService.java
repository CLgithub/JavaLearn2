package smm.common.servicebase;

import java.util.List;
import java.util.Map;

import smm.common.uitl.PageBean;

public interface BaseService<T> {

	/**
	 * 增
	 */
	int insert(T t);

	/**
	 * 增，参数可以不全
	 */
	int insertSelective(T t);

	/**
	 * 删
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 改,参数可以不全
	 */
	int updateByPrimaryKeySelective(T t);

	/**
	 * 改
	 */
	int updateByPrimaryKey(T t);

	/**
	 * 根据id查询单个实体
	 */
	T selectByPrimaryKey(Integer id);

}
