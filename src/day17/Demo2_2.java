package day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * 复习jdbc，编写jdbc基本连接操作数据库
 */
public class Demo2_2 {
	public static void main(String[] args) throws Exception {
		Connection connection = getConnection();
//		System.out.println(connection);
//		test2(connection);
		test3(connection);
	}
	
	//测试statement接口操作数据库，增删改
	public static void test1(Connection connection) throws SQLException{
		String sql="insert into user(id,name) values('U006','小黄')";
		Statement statement = connection.createStatement();
		int i = statement.executeUpdate(sql);
		System.out.println(i);
		close(connection, statement, null,null);
	}
	//测试statement接口操作数据库，查
	public static void test2(Connection connection) throws SQLException{
		String sql="select * from user";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			String name=resultSet.getString("name");
			System.out.println(name);
		}
		close(connection, statement, null, resultSet);
	}
	
	//测试preparedStatement接口操作数据库，增删改
	public static void test3(Connection connection) throws SQLException{
		String sql="insert into user(id,name) values(?,?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, "U007");
		pStatement.setString(2, "xxx");
		int i = pStatement.executeUpdate();
		System.out.println(i);
		close(connection, pStatement, pStatement, null);
	}
	
	
	//得到连接
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/test3";
		Properties properties=new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "123456");
//		properties.load(inStream);
		Connection connection = DriverManager.getConnection(url, properties);
		return connection;
	}
	
	//关闭资源
	public static void close(Connection connection,Statement statement,PreparedStatement pStatement,ResultSet resultSet){
		try{
			if(resultSet!=null){
				resultSet.close();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(pStatement!=null){
					pStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					if(statement!=null){
						statement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally{
					try {
						if(connection!=null){
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
