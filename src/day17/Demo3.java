package day17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/*
用PreparedStatement执行预编译的sql语句

Statement与PreparedStatement的区别
	1 语法上的差异
	2 执行效率上，支持sql缓冲区的 数据库上PreparedStatement会更高，（支持oracle，sql server）（不支持，mysql）
	3 PreparedStatement能防止sql注入
*/
public class Demo3 {
	
	@Test
	public void test1(){
		//DDL
//		String sql="create table student(id int primary key auto_increment,name varchar(20),gender varchar(2))";
//		String sql="create table users(id int primary key auto_increment,name varchar(20),password varchar(32))";
		
		//DML
//		//新增	一个?（占位符）代表一个参数
//		String sql="insert into student(name,gender) values(?,?);";
		String sql="insert into users(name,password) values(?,?);";
//		//修改
//		String sql="update student set name=?,gender=? where id=?";
//		//删除
//		String sql="delete from student where id=?";
		Connection connection=null;
		Statement statement=null;
		try{
			//连接数据库，得到链接对象
			connection = Demo2JdbcUtil.getConnect();
			//对sql执行预编译，编译成中间（状态），检查语法是否正确
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			//设置参数的值	第一个参数代表占位符的位置，第二个参数是真正的实参
//			prepareStatement.setString(1, "小黄1");
//			prepareStatement.setString(2, "男");
			prepareStatement.setString(1, "aaa");
			prepareStatement.setString(2, "123456");
//			prepareStatement.setInt(1, 5);
			//发生参数执行sql
			int i = prepareStatement.executeUpdate();
			System.out.println("影响的行数："+i);
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, statement);
		}
	}
	
	@Test
	public void test2(){
		//查询
		String sql="select * from student";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try{
			connection = Demo2JdbcUtil.getConnect();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String gender = resultSet.getString("gender");
				
				System.out.print(id+",");
				System.out.print(name+",");
				System.out.println(gender);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, statement, resultSet);
		}
	}
}
