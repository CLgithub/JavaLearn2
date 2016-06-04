package day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import day17.Demo2JdbcUtil;
import day17.exercise.entity.Contact17;

/*
jdbc 批处理
	批量处理多个操作
	
	jdbc核心api
	|- Driver接口：表示java驱动程序接口
		  |- connect：链接数据库的方法
	|- DriverManager类：驱动管理器类，用于管理所有注册的驱动程序
		|- registerDriver(driver):注册驱动对象
		|- Connection getConnection(url,user,password):获取连接对象
	
	|- Connection接口：表示java程序和数据库的连接对象
		  |- Statement createStatement(): 创建Statement对象	（Statement 声明）
		  |- PreparedStatement prepareStatement(String sql) 创建prepareStatement对象（prepare 准备）
		  |- CallableStatement prepareCall(String sql);创建一个CallableStatement对象（能够call）
	
	|- Statement接口：用于执行静态sql语句（父）
		  int executeUpdate(Sting sql);执行静态的更新sql语句（DDL,DML）
		  ResultSet executeQuery(String sql):执行静态的查询sql语句（DQL）
		  void addBatch(String sql)
				将给定的 SQL 命令添加到此 Statement对象的当前命令列表中。通过调用方法 executeBatch 可以批量执行此列表中的命令。
		  void clearBatch()清空此 Statement 对象的当前 SQL 命令列表。
		  int[] executeBatch()，执行批处理
		
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
	//有100个对象，放在一个list集合中，需要将着100个对象都插入数据库
	//方法一：用循环插入100次；缺点：要平凡的打开关闭连接，效率低
	//方法二：批处理1,一次性全部插入，缺点：上万条记录时，可能会OutOfMemoryError
	@Test
	public void test1(){
		List<Contact17> list=new ArrayList<>();
		for(int i=0;i<10000;i++){
			Contact17 contact17=new Contact17();
			contact17.setName("第"+i+"个联系人");
			list.add(contact17);
		}
		
		Connection connection=null;
		PreparedStatement pStatement=null;
		String sql="insert into contact17(name,age,phone,email,qq) values(?,?,?,?,?)";
		try{
			connection=Demo2JdbcUtil.getConnect();
			pStatement = connection.prepareStatement(sql);
			final int batchSize = 10;
			int count = 0;
			for(Contact17 contact17:list){
				pStatement.setObject(1, contact17.getName());
				pStatement.setObject(2, contact17.getAge());
				pStatement.setObject(3, contact17.getPhone());
				pStatement.setObject(4, contact17.getPhone());
				pStatement.setObject(5, contact17.getEmail());
				pStatement.addBatch();
				if(++count % batchSize == 0) {//添加一个保护
					pStatement.executeBatch();
					pStatement.clearBatch();// 清空ps中积攒的sql
				}
			}
			pStatement.executeBatch();
			pStatement.clearBatch();
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, pStatement);
		}
	}
	
	
}
