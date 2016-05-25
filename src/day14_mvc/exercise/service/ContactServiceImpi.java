package day14_mvc.exercise.service;

import java.util.List;
import day14_mvc.exercise.dao.ContactDao;
import day14_mvc.exercise.entity.ContactMvc;
import day7_sax.Contact;

public class ContactServiceImpi implements ContactService{

	@Override
	public List<ContactMvc> findAll() {
		return ContactDao.findAll();		
	}

	@Override
	public ContactMvc findById(String id) {
		return ContactDao.findById(id);
	}

	@Override
	public void addOrUpdate(ContactMvc contact) {
		ContactDao.addOrUpdate(contact);
	}

	@Override
	public void deleteC(String id) {
		ContactDao.deleteC(id);
	}

}
