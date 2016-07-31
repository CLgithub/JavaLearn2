package day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/*
2.4 jdbc 核心的api
	java.sql.* 和javax.sql.*
	|- Driver接口：表示java驱动程序接口，所有的具体的数据库厂商要来实现这个接口
		|-	connect(url,properties):链接数据库的方法
				url:链接数据库的url
					url语法：jdbc协议:数据库子协议://主机:端口/具体数据库
					user：数据库的用户名
					pa
					ssword：数据库的用户密码
	|- DriverManager类：驱动管理器类。用于管理所有注册的驱动程序
		|- registerDriver(driver):注册驱动对象
		|- Connection getConnection(url,user,password):获取连接对象
	
	|- Connection接口：表示java程序和数据库的连接对象
		|- Statement createStatement(): 创建Statement对象	（Statement 声明）
		|- PreparedStatement prepareStatement(String sql) 创建prepareStatement对象（prepare 准备）
		|- CallableStatement prepareCall(String sql);创建一个CallableStatement对象（能够call）
		
	|- Statement接口：用于执行静态sql语句（父）
		  int executeUpdate(Sting sql);执行静态的更新sql语句（DDL,DML）
		  ResultSet executeQuery(String sql):执行静态的查询sql语句（DQL）
		
		|- PreparedStatement接口：用于执行预编译sql语句（子）
			  int executeUpdate()：执行预编译的更新sql语句（DDL,DML）
			  ResultSet executeQuery():执行预编译的查询sql语句（DQL）
			
			|- CallableStatement接口：用于执行存储过程的sql语句（call xxx）（孙）
				  ResultSet executeQuery():调用存储过程的方法
	
	|-ResultSet接口：结果集，用于封装查询出来的数据
		  boolean next():将光标移到到下一行
		  getXXX():获取列的值
		  
  
*/
public class Demo2 {
	
	//用Statement对象执行DDL语句和DML语句
	@Test
	public void test1(){
		//DDL
//		String sql="create table student(id int primary key auto_increment,name varchar(20),gender varchar(2))";
		
		//DML
		//新增
		String sql="insert into student(name,gender) values('小白','男');";
		//修改
//		String sql="update student set name='小黄' where id=4";
		//删除
//		String sql="delete from student where id=4";
		Connection connection=null;
		Statement statement=null;
		try{
			//连接数据库，得到链接对象
			connection = Demo2JdbcUtil.getConnect();
			//通过连接对象，创建Statement对象
			statement = connection.createStatement();
			//调用Statement对象的executeUpdate执行静态sql语句，得到影响行数
			int i = statement.executeUpdate(sql);		//DDL,DML
			System.out.println("影响的行数："+i);
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, statement);
		}
	}
	
	//用Statement对象执行DQL语句
	@Test
	public void test2(){
		//查询
		String sql="select * from student";
		Connection connection=null;
		Statement statement=null;
		try{
			connection = Demo2JdbcUtil.getConnect();
			statement = connection.createStatement();
			//调用Statement对象的executeQuery执行静态sql语句,得到结果集
			ResultSet resultSet = statement.executeQuery(sql);	//DQL
			//1resultSet最初光标被置于第一行之前，next方法将光标移到到下一行,并返回移到后指向的行是否有对象
			while(resultSet.next()){
				//2.resultSet提供用于获取当前行获取列值的获取方法（getXXX）
				//可以使用列的索引或列的名称获取值，一般索引较高效，从1开始,建议使用列名
				//3.用作获取方法的输入的列名不区分大小写
				
//				int id = resultSet.getInt(1);
//				String name=resultSet.getString(2);
//				String gender = resultSet.getString(3);
				
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String gender = resultSet.getString("gEnder");	//不区分大小写
				
				System.out.print(id+",");
				System.out.print(name+",");
				System.out.println(gender);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, statement);
		}
	}
	
}
