package day19_2.exercise.service;

import java.util.Arrays;
import java.util.List;

import day19_2.exercise.base.BaseDao;
import day19_2.exercise.base.BaseServiceImpl;
import day19_2.exercise.common.PageBean;
import day19_2.exercise.dao.ContactDao;
import day19_2.exercise.dao.UserDao;
import day19_2.exercise.entity.Contact19_2;


public class ContactServiceImpl extends BaseServiceImpl<Contact19_2> implements ContactService {

	public ContactServiceImpl() {
		setBaseDao(new ContactDao());
	}

	@Override
	public Contact19_2 findCById(Integer id) {
		String sql="select * from contact17 where id=?";
		return this.findListT(sql, id).get(0);
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
		return this.findListT(sql);
	}

	@Override
	public void batchDeleteByIds(String ids) {
		String sql="delete from contact17 where id=?";
		Integer[] ids1=StringTOArray(ids);
		Integer[][] ids2=new Integer[ids1.length][1];
		for(int i=0;i<ids1.length;i++){
			ids2[i][0]=ids1[i];
		}
		this.batchEntityBySQL(sql, ids2);
	}

	private Integer[] StringTOArray(String ids) {
		String[] strs = ids.split(",");
		Integer[] integers=new Integer[strs.length];
		for(int i=0;i<strs.length;i++){
			Integer j = Integer.parseInt(strs[i]);
			integers[i]=j;
		}
		return integers;
	}

	@Override
	public List<Contact19_2> selectC(String s, String msg) {
		String sql="select * from contact17 ";
		if(s!=null&&!"".equals(s)){
			sql+=" where "+s+" like ? ";
			return this.findListT(sql, "%"+msg+"%");
		}else {
			return this.findAllC();
		}
	}

	@Override
	public PageBean selectCBuPage(String s, String msg, Integer page, Integer pageSize) {
		String sql="select * from contact17 ";
		if(s!=null&&!"".equals(s)){
			sql+=" where "+s+" like ? ";
			return getPageBean(sql, page, pageSize, "%"+msg+"%");
		}else {
			return getPageBean(sql, page, pageSize);
		}
	}

	


}
