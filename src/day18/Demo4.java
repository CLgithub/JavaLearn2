package day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import day17.Demo2JdbcUtil;

/*
事务
	概念：事务是逻辑上的一组操作，
		组成这组操作的各个单元，要不全部成功，要不全部不成功
	ACID特性:
	原子性（Atomicity）
		原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。 
	一致性（Consistency）
		事务必须使数据库从一个一致性状态变换到另外一个一致性状态。
	隔离性（Isolation）
		事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
	持久性（Durability）
		持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响
	
	核心api：
		|- Connection
			void setAutoCommit(boolean autoCommit) ;  设置事务是否自动提交，true自动提交(默认)，false手动提交
			void commit();			手动提交事务
			void rollback();		回滚（出现异常的时候，所有已经执行成功的代码需要回退到事务开始前）
			Savepoint setSavepoint(String name) 	在当前事务中创建一个未命名的保存点 (savepoint)，并返回表示它的新 Savepoint 对象。
						如果在活动事务范围之外调用 setSavepoint，则将在新创建的保存点上启动事务。
			
			
*/
public class Demo4 {
	//案例：转账案例
	//创建帐户表：create table account(id int primary key auto_increment,accountName varchar(20),money DOUBLE);
	
	//转账，没有使用事务
	@Test
	public void test1(){
		String sql1="update account set money=money-1000 where accountName='小明'";
		String sql2="update1 account set money=money+1000 where accountName='小红'";
		Connection connection=null;
		PreparedStatement pStatement=null;
		try{
			connection = Demo2JdbcUtil.getConnect();	//默认开启了隐式事务 	connection.setAutoCommit(true);
			pStatement=connection.prepareStatement(sql1);
			pStatement.executeUpdate();
			pStatement=connection.prepareStatement(sql2);
			pStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, pStatement);
		}
	}
	
	//转账，使用事务
	@Test
	public void test2(){
		String sql1="update account set money=money-1000 where accountName='小明'";
		String sql2="update1 account set money=money+1000 where accountName='小红'";
		Connection connection=null;
		PreparedStatement pStatement=null;
		try{
			connection = Demo2JdbcUtil.getConnect();
			//1.设置事务为手动提交
			connection.setAutoCommit(false);
			pStatement=connection.prepareStatement(sql1);
			pStatement.executeUpdate();
			pStatement=connection.prepareStatement(sql2);
			pStatement.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			//出现异常，需要回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			//最终要提交
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Demo2JdbcUtil.closeC(connection, pStatement);
		}
	}
	
	//转账，使用事务，回滚到指定的代码
	@Test
	public void test3(){
		String sql1="update account set money=money-1000 where accountName='小明'";
		String sql2="update account set money=money+1000 where accountName='小红'";
		String sql3="update account set money=money-500 where accountName='小明'";
		String sql4="update1 account set money=money+500 where accountName='小红'";
		Connection connection=null;
		PreparedStatement pStatement=null;
		Savepoint savepoint=null;
		try{
			connection = Demo2JdbcUtil.getConnect();
			//1.设置事务为手动提交
			connection.setAutoCommit(false);
			//第一次转账
			pStatement=connection.prepareStatement(sql1);
			pStatement.executeUpdate();
			pStatement=connection.prepareStatement(sql2);
			pStatement.executeUpdate();
			
			//第二次转账
			savepoint = connection.setSavepoint("trans");//指定一个回滚点
			connection.setAutoCommit(false);
			pStatement=connection.prepareStatement(sql3);
			pStatement.executeUpdate();
			pStatement=connection.prepareStatement(sql4);
			pStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			//出现异常，需要回滚，回滚到指定位置
			try {
				connection.rollback(savepoint);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			//最终要提交
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Demo2JdbcUtil.closeC(connection, pStatement);
		}
	}
}
