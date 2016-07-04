package day72_mybatis.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import day72_mybatis.demo.eneity.User;

@Repository("userDao")
public class UserDaoImpl2 extends SqlSessionDaoSupport implements UserDao {

	
	@Resource(name="sqlSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}



	@Override
	public User findUserById(int id) throws Exception {
		// 创建SqlSession
		User user = getSqlSession().selectOne("test1.findUserById", 10);
		return user;
	}

	@Override
	public List<User> findListByName(String userName) {
		List<User> list = getSqlSession().selectList("test1.findUserByName", userName);
		return list;
	}

}
