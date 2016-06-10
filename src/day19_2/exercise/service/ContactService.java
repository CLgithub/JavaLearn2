package day19_2.exercise.service;

import java.util.List;

import day19_2.exercise.base.BaseService;
import day19_2.exercise.entity.Contact19_2;


public interface ContactService extends BaseService<Contact19_2> {
	
	/**
	 * 根据id查找联系人
	 * @author L
	 * @date 2016年6月6日
	 * @param valueOf
	 * @return
	 */
	Contact19_2 findCById(Integer valueOf);
	
	/**
	 * 新增或修改联系人
	 * @author L
	 * @date 2016年6月6日
	 * @param contact
	 */
	void addOrUpdateC(Contact19_2 contact);

	/**
	 * 删除联系人
	 * @author L
	 * @date 2016年6月6日
	 * @param id
	 */
	public void deleteC(String id);

	/**
	 * 查询所有联系人
	 * @author L
	 * @date 2016年6月6日
	 * @return
	 */
	List<Contact19_2> findAllC();

	/**
	 * 根据id批量删除联系人
	 * @param ids
	 * @author L
	 * @date 2016年6月10日
	 */
	void batchDeleteByIds(String ids);

	/**
	 * 根据条件查询联系人
	 * @param s	字段明
	 * @param msg	字段值
	 * @return
	 * @author L
	 * @date 2016年6月10日
	 */
	List<Contact19_2> selectC(String s, String msg);

	

	
}
