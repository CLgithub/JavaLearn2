package day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
day17~day19回顾：
	jdbc：
		Java 数据库连接，（Java Database Connectivity，简称JDBC）是Java语言中用来规范客户端程序如何来访问数据库的应用程序接口，
	jdbc核心api
		（/JavaLearn2/src/day17/Demo2.java）
	jdbc基础开发：
		如下method1(),method2(),method3()及/JavaLearn2/src/day17/Demo3.java
		jdbc调用存储过程
			day17.Demo5
		批处理
			day18.Demo2
	事务：逻辑上的一组操作，要么都成功，要么都不成功
		acid特性；
			原子性：事务是一个不可分隔的工作单位，要么都成功，要么都不成功
			隔离性：事务之间不能相互影响
			一致性：事务执行前后，数据库从一个一致性状态变换到另外一个一致性状态。
			持久性：如果事务提交了，将对数据产生持久性的影响
			day18.Demo4
		如果不考虑事务隔离性，会参数如下问题
			1.脏读：读取到其他事务未提交的数据
			2.虚读：两次读取的数据不一致（insert）
			3.不可重复读：两次读取的数据不一致（update）
			4.丢失更新：后提交的事务覆盖前提交的数据更新的数据
		事务隔离级别:	day18_transaction.Demo2
			read uncommitted	什么问题都解决不了
			read committed		可解决脏读	（oracle默认）
			repeatable read		可解决脏读，不可重复读，不能解决虚读（mysql默认）
			serializable		会锁表，可以解决所有问题
	连接池
		连接池是什么，有什么用？
			连接池：创建一个容器，用于装入Connection对象，使用连接对象时，从容器中获取一个Connection对象，
			使用完毕后，再将这个Connection重新装入到容器中，这个容器就是连接池（DataSource）,也叫数据源
		开源连接池		/JavaLearn2/src/day18_transaction/Demo4.java
			1.dbcp（了解）
			2.c3p0（必会）
		tomcat内置连接池管理	/JavaLearn2/src/day19_2/Demo1.java
		
	元数据：/JavaLearn2/src/day19_2/Demo2.java
	
	dbutils工具	/JavaLearn2/src/day19_2/Demo3.java
		ResultSetHandler接口的9个实现类	/JavaLearn2/src/day19_2/Demo4.java
	
		

*/
public class Doc1 {
	
	public static void main(String[] args) throws Exception {
		Connection connection = method1();
//		method2(connection);
		method3(connection);
	}


	//得到连接对象
	private static Connection method1() throws Exception {
		//读取配置文件
		Properties properties=new Properties();
		properties.load(Doc1.class.getResourceAsStream("/day17_db.properties"));
		String driverClass = properties.getProperty("driverClass");
		String url=properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		//注册驱动器	com.mysql.jdbc.Driver的静态代码已经把自己注册了，所有调用一下字节码文件就执行了静态代码块，就执行了注册驱动
		Class.forName(driverClass);

		//得到Connection 对象
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	//使用Statement执行
	private static void method2(Connection connection) throws SQLException {
		String sql="select * from users";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
//		boolean b = statement.execute(sql);		／／执行修改语句
		while(resultSet.next()){
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String password = resultSet.getString("password");
			
			System.out.print(id+",");
			System.out.print(name+",");
			System.out.println(password);
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	//使用PreparedStatement执行
	private static void method3(Connection connection) throws SQLException {
		String sql="select * from users where id=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setObject(1, 1);
		ResultSet resultSet = pStatement.executeQuery();
//		pStatement.executeUpdate();		//执行修改语句
		while(resultSet.next()){
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String password = resultSet.getString("password");
			System.out.print(id+",");
			System.out.print(name+",");
			System.out.println(password);
		}
		resultSet.close();
		pStatement.close();
		connection.close();
	}
}
