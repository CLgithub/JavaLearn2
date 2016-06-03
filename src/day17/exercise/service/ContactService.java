package day17.exercise.service;

import java.util.List;

import day17.exercise.entity.Contact17;


public interface ContactService {
	/**
	 * 查询所用
	 * @author L
	 * @date 2016年5月25日
	 */
	List<Contact17> findAll();

	/**
	 * 根据id查找联系人
	 * @author L
	 * @date 2016年5月25日
	 * @param id
	 * @return
	 */
	Contact17 findById(String id);

	/**
	 * 新增或修改联系人
	 * @author L
	 * @date 2016年5月25日
	 * @param contact
	 */
	void addOrUpdate(Contact17 contact);

	/**
	 * 删除联系人
	 * @author L
	 * @date 2016年5月25日
	 * @param id
	 */
	void deleteC(String id);
}
