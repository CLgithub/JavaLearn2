package day19.exercise.service;

import java.util.List;

import day19.exercise.base.BaseService;
import day19.exercise.entity.Contact19;

public interface ContactService extends BaseService<Contact19> {
	
	/**
	 * 根据id查找联系人
	 * @author L
	 * @date 2016年6月6日
	 * @param valueOf
	 * @return
	 */
	Contact19 findCById(Integer valueOf);
	
	/**
	 * 新增或修改联系人
	 * @author L
	 * @date 2016年6月6日
	 * @param contact
	 */
	void addOrUpdateC(Contact19 contact);

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
	List<Contact19> findAllC();

	

	
}
