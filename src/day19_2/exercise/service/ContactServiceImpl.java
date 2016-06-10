package day19_2.exercise.service;

import java.util.List;

import day19_2.exercise.base.BaseServiceImpl;
import day19_2.exercise.entity.Contact19_2;


public class ContactServiceImpl extends BaseServiceImpl<Contact19_2> implements ContactService {

	@Override
	public Contact19_2 findCById(Integer id) {
		String sql="select * from contact17 where id=?";
		return this.findListT(Contact19_2.class,sql, id).get(0);
	}
	
	@Override
	public void addOrUpdateC(Contact19_2 contact) {
		Integer contactId = contact.getId();
		String sql="";
		if(contactId==null||contactId==0){	//新增
			sql="insert into contact17(name,age,phone,email,dateTest,gender) values(?,?,?,?,?,?)";
			this.executeSql(sql, 
						contact.getName(),contact.getAge(),contact.getPhone(),contact.getEmail(),contact.getDateTest(),contact.getGender());
		}else {
			sql="update contact17 set name=?,age=?,phone=?,email=?,dateTest=?,gender=? where id=?";
			this.executeSql(sql, 
					contact.getName(),contact.getAge(),contact.getPhone(),contact.getEmail(),contact.getDateTest(),contact.getGender(),contact.getId());
		}
	}

	@Override
	public void deleteC(String id) {
		String sql="delete from contact17 where id=?";
		this.executeSql(sql, id);
	}

	@Override
	public List<Contact19_2> findAllC() {
		String sql="select * from contact17";
		return this.findListT(Contact19_2.class,sql);
	}


}
