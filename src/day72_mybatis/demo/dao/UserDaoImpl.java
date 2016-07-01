package day72_mybatis.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day72_mybatis.demo.eneity.User;

public class UserDaoImpl implements UserDao{
	
	private SqlSessionFactory sqlSessionFactory;
	
	//注入SqlSessionFactory
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	

	@Override
	public User findUserById(int id) throws Exception {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user=sqlSession.selectOne("test1.findUserById", 10);
		sqlSession.close();
		return user;
	}


	@Override
	public List<User> findListByName(String userName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test1.findUserByName", userName);
		sqlSession.close();
		return list;
	}
	
	
	
	

}
