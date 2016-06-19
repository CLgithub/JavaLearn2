package day24_annotation.demo;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcTest {
	public static void main(String[] args) throws Exception {
		//读取配置文件方式得到连接
//		Connection content = JdbcUtil.getContent1();
		//使用注解得到连接
		Connection connect2=getContent2();
		
		String sql="select * from account";
		test1(connect2,sql);
	}

	private static void test1(Connection content,String sql) throws Exception, SQLException {
		PreparedStatement pStatement = content.prepareStatement(sql);
		ResultSet resultSet = pStatement.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getObject("accountName"));
		}
		resultSet.close();
		pStatement.close();
		content.close();
	}
	
	
	@GetConnection(url="jdbc:mysql://localhost:3306/jdbc1",user="L",password="123456",dirverClass="com.mysql.jdbc.Driver")
	public static Connection getContent2() throws Exception{
		Method method = JdbcTest.class.getDeclaredMethod("getContent2");
		if(method.isAnnotationPresent(GetConnection.class)){
			GetConnection getConnection = method.getAnnotation(GetConnection.class);
			String url = getConnection.url();
			String user = getConnection.user();
			String password = getConnection.password();
			String dirverClass = getConnection.dirverClass();
			Class.forName(dirverClass);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		}
		return null;
	}
}
