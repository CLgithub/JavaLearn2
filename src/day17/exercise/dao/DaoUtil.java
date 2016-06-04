package day17.exercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import day17.Demo2JdbcUtil;
import day17.exercise.entity.Contact17;

public class DaoUtil {
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String driverClass=null;
	private static Connection connection=null;
	private static ResultSet resultSet=null;
	
	static{
		Properties properties=new Properties();
		try {
			properties.load(Demo2JdbcUtil.class.getResourceAsStream("/day17_db.properties"));	//	"/"web项目代表classpath根目录	java项目代表bin根目录，
			driverClass=properties.getProperty("driverClass");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
			Class.forName(driverClass);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取配置失败");
		}
	}
	
	/**
	 * 执行原生sql
	 * @param sql
	 * @param objects
	 * @return
	 * @author L
	 * @date 2016年6月3日
	 */
	public static int executeSql(String sql, Object... objects){
		connection=getConnect();
		int j=0;
		PreparedStatement prepareStatement=null;
		try {
			prepareStatement=connection.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				Object object = objects[i];
//				if(object instanceof Integer){
//					prepareStatement.setInt(i+1, (Integer) objects[i]);
//				}else if(object instanceof String){
//					prepareStatement.setString(i+1, (String) objects[i]);
//				}
				prepareStatement.setObject(i+1, object);
			}
			j=prepareStatement.executeUpdate();
			return j;
		} catch (SQLException e) {
			e.printStackTrace();
			return j;
		}finally {
			closeC(connection, prepareStatement);
		}
	}
	
	/**
	 * 根据sql查询得到list
	 * @param sql
	 * @param objects
	 * @return
	 * @author L
	 * @date 2016年6月3日
	 */
	public static List<Contact17> selectListBySql(String sql, Object... objects){
		connection=getConnect();
		List<Contact17> list=new ArrayList<>();
		PreparedStatement prepareStatement =null;
		try {
			prepareStatement=connection.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
//				prepareStatement.setString(i+1, (String) objects[i]);
				prepareStatement.setObject(i+1, objects[i]);
			}
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Contact17 contact17 = new Contact17();
				contact17.setId(resultSet.getInt("id"));
				contact17.setName(resultSet.getString("name"));
				contact17.setAge(resultSet.getString("age"));
				contact17.setPhone(resultSet.getString("phone"));
				contact17.setEmail(resultSet.getString("email"));
				contact17.setQq(resultSet.getString("qq"));
				list.add(contact17);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeC(connection, prepareStatement, resultSet);
		}
	}
	
	/**
	 * 得到连接
	 * @author L
	 * @date 2016年5月31日
	 * @return
	 */
	private static Connection getConnect(){
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 关闭资源
	 * @author L
	 * @date 2016年5月31日
	 * @param connection
	 * @param statement
	 * @param resultSet 
	 */
	private static void closeC(Connection connection,Statement statement, ResultSet resultSet){
		try {
			if(resultSet!=null){
				resultSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null){
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
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
	
	/**
	 * 关闭资源
	 * @author L
	 * @date 2016年5月31日
	 * @param connection
	 * @param statement
	 * @param resultSet 
	 */
	private static void closeC(Connection connection,Statement statement){
		try {
			if(statement!=null){
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
