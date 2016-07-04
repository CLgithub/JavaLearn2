package day72_mybatis.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import day72_mybatis.demo.eneity.User;

//@Repository("userDao")
public class UserDaoImpl /*extends SqlSessionDaoSupport*/ implements UserDao {

	 private SqlSessionFactory sqlSessionFactory;

//	 注入SqlSessionFactory
	 public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		 this.sqlSessionFactory=sqlSessionFactory;
	 }

//	private SqlSession sqlSession;

//	@Resource
//	public void setSqlSession(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//	}

	@Override
	public User findUserById(int id) throws Exception {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test1.findUserById", 10);
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
