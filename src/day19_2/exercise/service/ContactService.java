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

	

	
}
