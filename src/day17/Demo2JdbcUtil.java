package day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jsbc工具类
 * @author L
 * @date 2016年5月31日
 */
public class Demo2JdbcUtil {
	private static String url="jdbc:mysql://localhost:3306/jdbc1?autoReconnect=true&useSSL=false";
	private static String user="root";
	private static String password="123456";
	//只加载一次
	static{
		try {
			//通过得到字节码文件，调用静态代码块注册驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动程序注册出错");
		}
	}
	
	/**
	 * 得到连接
	 * @author L
	 * @date 2016年5月31日
	 * @return
	 */
	public static Connection getConnect(){
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
