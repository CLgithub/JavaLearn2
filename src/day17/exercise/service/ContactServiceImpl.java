package day17.exercise.service;

import java.util.List;
import day17.exercise.dao.ContactDao;
import day17.exercise.dao.ContactDaoMysqlImpl;
import day17.exercise.dao.ContactDaoxmlImpl;
import day17.exercise.entity.Contact17;

public class ContactServiceImpl implements ContactService{
//	ContactDao contactDao=new ContactDaoxmlImpl();
	ContactDao contactDao=new ContactDaoMysqlImpl();

	@Override
	public List<Contact17> findAll() {
		return contactDao.findAll();
	}

	@Override
	public Contact17 findById(String id) {
		return contactDao.findById(id);
	}

	@Override
	public void addOrUpdate(Contact17 contact) {
		contactDao.addOrUpdate(contact);
	}

	@Override
	public void deleteC(String id) {
		contactDao.deleteC(id);
	}

}
