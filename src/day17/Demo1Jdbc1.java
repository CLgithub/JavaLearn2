package day17;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.Test;
import sun.security.util.Password;

/*
	jdbc入门
		2.1之前要操作数据
		（1）通过mysql客户端登录数据库服务器端
		（2）编写sql语句，
		（3）发送sql语句到服务器端执行
		2.2什么是jdbc
			使用java代码（程序）发送sql语句的技术，就是jdbc技术
			Java 数据库连接，（Java Database Connectivity，简称JDBC）是Java语言中用来规范客户端程序如何来访问数据库的应用程序接口，
			提供了诸如查询和更新数据库中数据的方法。JDBC也是Sun Microsystems的商标[1]。JDBC是面向关系型数据库的。
		2.3使用jdbc发送sql前提
			登录数据库服务器（连接数据库服务器）
				数据库ip地址
				端口
				用户名
				密码
			
		Mon May 30 22:44:16 CST 2016 WARN: Establishing SSL connection without server's 
		identity verification is not recommended.
		 According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be 
		 established by default if explicit option isn't set. 
		 For compliance with existing applications not using SSL the verifyServerCertificate property 
		 is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, 
		 or set useSSL=true and provide truststore for server certificate verification.
			
*/
public class Demo1Jdbc1 {

	//连接数据库的url，jdbc协议
	//jdbc协议：数据库子协议://主机:端口/具体数据库
	private String url="jdbc:mysql://localhost:3306/myLearn2";	
	
	private String user="L";
	private String password="123456";
	
	//方法一：连接数据库
	@Test
	public void test1() throws SQLException {
		//1.创建一个驱动程序对象
		Driver driver=new com.mysql.jdbc.Driver();		//新版本
//		Driver driver=new org.gjt.mm.mysql.Driver();	//就版本
		
		//设置用户名和密码
		Properties properties=new Properties();
		properties.setProperty("user", user);
		properties.setProperty("password", password);
		
		//连接数据库,得到连接对象
		Connection connect = driver.connect(url,properties);
		
		System.out.println("连接对象："+connect);
	}
	
	//方法二：使用驱动管理器类连接数据库
	@Test
	public void test2() throws SQLException{
		Driver driver=new com.mysql.jdbc.Driver();
//		Driver driver2=new com.mysql.jdbc.Driver();
		//注册驱动程序	可以注册多个驱动程序		看源码，com.mysql.jdbc.Driver的静态代码已经把自己注册了
//		DriverManager.registerDriver(driver);
		
		//2.建立到具体的数据库
		Connection connect = DriverManager.getConnection(url,user,password);
		System.out.println("连接对象："+connect);
	}
	
	//方法三：使用驱动管理器类连接数据库
	@Test
	public void test3() throws SQLException, Exception{
		//通过得到字节码的方式，加载了com.mysql.jdbc.Driver里的静态代码快，从而注册了驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2.建立到具体的数据库
		Connection connect = DriverManager.getConnection(url,user,password);
		System.out.println("连接对象："+connect);
	}
}
