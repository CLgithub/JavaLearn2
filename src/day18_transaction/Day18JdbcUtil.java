package day18_transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jsbc工具类
 * @author L
 * @date 2016年5月31日
 */
public class Day18JdbcUtil {
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String driverClass=null;
	
	//只加载一次
	static{
		//读取db.properties配置信息
		Properties properties=new Properties();
		try {
//			properties.load(Demo2JdbcUtil.class.getResourceAsStream("db.properties"));
			properties.load(Day18JdbcUtil.class.getResourceAsStream("/day17_db.properties"));	//	"/"web项目代表classpath根目录	java项目代表bin根目录，
			driverClass=properties.getProperty("driverClass");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
			//通过得到字节码文件，调用静态代码块注册驱动
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取配置失败");
		}
	}
	
	/**
	 * 得到连接
	 * @author L
	 * @date 2016年5月31日
	 * @return
	 */
	public static Connection getConnect(){
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭资源
	 * @author L
	 * @date 2016年5月31日
	 * @param connection
	 * @param statement
	 * @param resultSet 
	 */
	public static void closeC(Connection connection,Statement statement, ResultSet resultSet){
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
	public static void closeC(Connection connection,Statement statement){
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
