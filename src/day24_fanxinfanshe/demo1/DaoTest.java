package day24_fanxinfanshe.demo1;

public class DaoTest {
	public static void main(String[] args) {
		BaseDao<User> dao=new UserDao();
		User user = dao.findById(1);
		
	}
}
