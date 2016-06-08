package day18_transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;



/*

开源连接池
	1.dbcp（了解）
		dbcp是apache的一个开源连接池。
		要想使用DBCP连接池，要下载jar包
			导入时要导入两个
				commons-dbcp2-2.1.1.jar
				commons-pool2-2.4.2.jar
			关于jdbc连接池的使用
				1.手动配置（手动编码）
				2.自动配置（配置文件）
	2.c3p0（必会）
		C3P0是一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展。
		目前使用它的开源项目有Hibernate，Spring等。
		c3p0与dbcp区别
			dbcp没有自动回收空闲连接的功能
			c3p0有自动回收空闲连接功能
		c3p0连接池使用
			1.导包
				c3p0-0.9.5.2.jar
				mchange-commons-java-0.2.11
			使用
				1.手动
				2.自动
					c3p0配置文件可以是properties，也可以是xml
					c3p0的配置文件如果名称叫做 c3p0.properties or c3p0-config.xml 并且放置在classpath路径下(对于web应用就是classes目录)
					那么c3p0会自动查找。
					注意：我们其时只需要将配置文件放置在src下就可以。
					
					使用：
						会在指定的目录下查找指定名称的配置文件，并将其中内容加载
					
					
*/
public class Demo4 {

	//手动配置dbcp
	@Test
	public void test1() throws Exception{
		//创建连接处对象
		BasicDataSource bds=new BasicDataSource();
		//设置连接数据库4个基本条件
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/jdbc1"
				+ "?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8"
				+ "&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true");
		bds.setUsername("L");
		bds.setPassword("123456");
		//得到连接对象
		Connection connection = bds.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while(resultSet.next()){
			System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("accountName")+"  "+resultSet.getDouble("money"));
		}
		resultSet.close();
		connection.close();//将connection对象重新装入连接池
	}
	
	//自动配置dbcp
	@Test
	public void test2() throws Exception{
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/day18_db.properties"));
		
		DataSource dataSource=BasicDataSourceFactory.createDataSource(properties);
		//得到连接对象
		Connection connection = dataSource.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while(resultSet.next()){
			System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("accountName")+"  "+resultSet.getDouble("money"));
		}
		resultSet.close();
		connection.close();//将connection对象重新装入连接池
	}
	
	//手动配置c3p0
	@Test
	public void test3() throws Exception{
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc1");
		cpds.setUser("L");
		cpds.setPassword("123456");
		
		Connection connection = cpds.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while(resultSet.next()){
			System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("accountName")+"  "+resultSet.getDouble("money"));
		}
		resultSet.close();
		connection.close();//将connection对象重新装入连接池
	}
	
	//自动配置c3p0
	@Test
	public void test4() throws Exception{
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		//放好c3p0-config.xml配置文件，会自动查找
//		cpds.setDriverClass("com.mysql.jdbc.Driver");
//		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc1");
//		cpds.setUser("L");
//		cpds.setPassword("123456");
		
		Connection connection = cpds.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while(resultSet.next()){
			System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("accountName")+"  "+resultSet.getDouble("money"));
		}
		resultSet.close();
		connection.close();//将connection对象重新装入连接池
	}
	
}
