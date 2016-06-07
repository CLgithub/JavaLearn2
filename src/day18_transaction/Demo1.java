package day18_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import day17.Demo2JdbcUtil;

/*
事务:
	问题:事务是什么，有什么用?
		事务就是一个事情，组成这个事情可能有多个单元，要求这些单元，要么全都成功，要么全都不成功。
		在开发中，有事务的存在，可以保证数据完整性。
	
	问题:事务怎样操作
		创建表:
		create table account(
		   id int primary key auto_increment,
		   name varchar(20),
		   money double
		);

		insert into account values(null,'aaa',1000);
		insert into account values(null,'bbb',1000);
		insert into account values(null,'ccc',1000);
		
		1.mysql下怎样操作
			方式1:
				start transaction  开启事务
				rollback 事务回滚
				commit 事务提交
			方式2:
				show variables like '%commit%'; 可以查看当前autocommit值
					在mysql数据库中，它autocommit的默认值是ON，代表自动事务 
					自动事务的意义就是：执行任意一条sql语句都会自动提交事务
					
					测试:将autocommit的值设置为off
						1.set autocommit=off 关闭自动事务。
						2.必须手动commit才可以将事务提交。
						注意:mysql默认autocommit=on  oracle默认的autocommit=off;
		2.jdbc下怎么操作
			java.sql.conection接口中有几个方法是可以操作事务
			|- Connection
				void setAutoCommit(boolean autoCommit) ;  设置事务是否自动提交，true自动提交(默认)，false手动提交
				void commit();			手动提交事务
				void rollback();		回滚（出现异常的时候，所有已经执行成功的代码需要回退到事务开始前）
				Savepoint setSavepoint(String name) 	在当前事务中创建一个未命名的保存点 (savepoint)，并返回表示它的新 Savepoint 对象。
						如果在活动事务范围之外调用 setSavepoint，则将在新创建的保存点上启动事务。
			
			

*/

public class Demo1 {
	@Test
	public void test1() {
		String sql1 = "update account set money=money-500 where id=1";
		String sql2 = "update account set money=money+500 where id=2";
		Connection connect = null;
		PreparedStatement pStatement1 = null;
		PreparedStatement pStatement2 = null;
		try {
			connect = Demo2JdbcUtil.getConnect();
			// 设置自动提交事务为false
			connect.setAutoCommit(false);
			pStatement1 = connect.prepareStatement(sql1);
			pStatement2 = connect.prepareStatement(sql2);
			int i1 = pStatement1.executeUpdate();
			int i2 = pStatement2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// 如果出现异常，则回滚
			try {
				connect.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 最终要提交
			try {
				connect.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Demo2JdbcUtil.closeC(connect, pStatement1);
			Demo2JdbcUtil.closeC(connect, pStatement2);
		}
	}
}
