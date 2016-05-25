package day14_mvc.exercise.service;

import java.util.List;
import day14_mvc.exercise.entity.ContactMvc;
import day7_sax.Contact;


public interface ContactService {

	/**
	 * 查询所用
	 * @author L
	 * @date 2016年5月25日
	 */
	List<ContactMvc> findAll();

	/**
	 * 根据id查找联系人
	 * @author L
	 * @date 2016年5月25日
	 * @param id
	 * @return
	 */
	ContactMvc findById(String id);

	/**
	 * 新增或修改联系人
	 * @author L
	 * @date 2016年5月25日
	 * @param contact
	 */
	void addOrUpdate(ContactMvc contact);

	/**
	 * 删除联系人
	 * @author L
	 * @date 2016年5月25日
	 * @param id
	 */
	void deleteC(String id);

}
