package day24_annotation.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class JdbcUtil {
	
	private static String url;
	private static String user;
	private static String password;
	private static String driverClass;
	
	static{
		Properties properties=new Properties();
		try {
			properties.load(JdbcUtil.class.getResourceAsStream("/day17_db.properties"));
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
	
	
	public static Connection getContent1() throws Exception{
		return DriverManager.getConnection(url, user, password);
	}
	
}
