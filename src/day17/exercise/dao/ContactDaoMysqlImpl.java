package day17.exercise.dao;

import java.sql.Connection;
import java.util.List;

import day17.Demo2JdbcUtil;
import day17.exercise.entity.Contact17;

public class ContactDaoMysqlImpl implements ContactDao{
	
	
	@Override
	public List<Contact17> findAll() {
		String sql="select * from contact17";
		return DaoUtil.selectListBySql(sql);
	}

	@Override
	public void addOrUpdate(Contact17 contact) {
		Integer contactId = contact.getId();
		String sql="";
		if(contactId==null||contactId==0){	//新增
			sql="insert into contact17(name,age,phone,email,qq) values(?,?,?,?,?)";
			int i = DaoUtil.executeSql(sql, 
						contact.getName(),contact.getAge(),contact.getPhone(),contact.getEmail(),contact.getQq());
		}else {
			sql="update contact17 set name=?,age=?,phone=?,email=?,qq=? where id=?";
			int i = DaoUtil.executeSql(sql, 
					contact.getName(),contact.getAge(),contact.getPhone(),contact.getEmail(),contact.getQq(),contact.getId());
		}
	}

	@Override
	public Contact17 findById(String id) {
		String sql="select * from contact17 where id=?";
		List<Contact17> list=DaoUtil.selectListBySql(sql, id);
		if(list!=null){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteC(String id) {
		String sql="delete from contact17 where id=?";
		int i = DaoUtil.executeSql(sql, id);
	}
	
	
	

}
