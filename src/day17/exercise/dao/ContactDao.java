package day17.exercise.dao;

import java.util.List;

import day17.exercise.entity.Contact17;

public interface ContactDao {
	
	/**
	 * 查询所有联系人
	 * @return
	 * @author L
	 * @date 2016年6月3日
	 */
	public List<Contact17> findAll();
	
	/**
	 * 新增或修改联系人,当id为空，是新增，否则就是修改
	 * @param contact17
	 * @author L
	 * @date 2016年6月3日
	 */
	public void addOrUpdate(Contact17 contact17);
	
	/**
	 * 根据id查询联系人
	 * @param id
	 * @return
	 * @author L
	 * @date 2016年6月3日
	 */
	public Contact17 findById(String id);
	
	/**
	 * 根据id删除联系人
	 * @param id
	 * @author L
	 * @date 2016年6月3日
	 */
	public void deleteC(String id);
}
