package day18_transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import day17.Demo2JdbcUtil;

/*

事务特性(重点) ACID
	1.原子性（Atomicity）原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。 
	2.一致性（Consistency）事务前后数据的完整性必须保持一致。
	3.隔离性（Isolation）事务的隔离性是指多个用户并发访问数据库时，一个用户的事务不能被其它用户的事务所干扰，多个并发事务之间数据要相互隔离。
	4.持久性（Durability）持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响
	
	如果不考虑事务隔离性，会出现什么问题？
		1.脏读 一个事务读取到另一个事务的未提交数据。
		2.不可重复读	两次读取的数据不一致(update)
		3.虚读(幻读)	两次读取的数据不一致(insert)
		4.丢失更新	两个事务对同一条记录进行操作，后提交的事务，将先提交的事务的修改覆盖了。
		
	演示以上问题，已经问题的解决方案
		可以通过设置事务的隔离级别来解决
		1.事务的隔离级别有哪些
			1 serializable：可避免脏读、不可重复读、虚读情况的发生。（串行化）
			2 repeatable read：可避免脏读、不可重复读情况的发生。（可重复读）不可以避免虚读
			3 read committed：可避免脏读情况发生（读已提交）
			4 read uncommitted：最低级别，以上情况均无法保证。(读未提交)
		2.怎么设置事务的隔离级别
			1.mysql中设置
				a.查看事务隔离级别	select @@tx_isolation
					mysql中默认的事务隔离级别是：REPEATABLE-READ
					oracle默认：Read committed
				b.mysql中怎么设置事务隔离级别	
					set session transaction isolation level (serializable/repeatable read/read committed/read uncommitted)
					
					(1)演示脏读：一个事务读取到另一个事务的未提交数据
						设置a，b事务的隔离级别为read uncommitted	
							set session transaction isolation level read uncommitted;
						在a事务中
							start transaction;
							update account set money=money-500 where name='aaa';
							update account set money=money+500 where name='bbb';
						在不事务中
							start transaction;
							select * from account;
							
						这时，b事务读取时，会发现，钱已经汇完，会出现脏读
						当a事务回滚提交后，b事务再查询，会发现钱又恢复了，也出现了两次查询不一致问题，（不可重复读）
					(2)解决脏读问题
						设置a，b事务的隔离级别为read committed	
							set session transaction isolation level read committed;
						在a事务中
							start transaction;
							update account set money=money-500 where name='aaa';
							update account set money=money+500 where name='bbb';
						在不事务中
							start transaction;
							select * from account;
						这时，b事务中，读取信息，时不能读取到a事务未提交的数据的，已经解决了脏读问题
						让a事务，提交数据commit,这时，b再查询，这次查询与上一次查询结果不一样，存在不可重复读问题
					(3)解决不可重读
						设置a，b事务的隔离级别为repeatable read
							set session transaction isolation level repeatable read;
						在a事务中
							start transaction;
							update account set money=money-500 where name='aaa';
							update account set money=money+500 where name='bbb';
						在不事务中
							start transaction;
							select * from account;
						让a事务提交commit，b事务再查询，与上次查询结果一致，解决了不可重复读问题，必须妖b事务也commit后，才能读到
					(4)设置事务隔离级别为	serializable(序列化)，它可以解决所有问题
						设置a，b事务的隔离级别为serializable
							set session transaction isolation level serializable;
						如果设置成这种事务隔离级别，会出现锁表，也就是说，一个事务再对表进行操作时，其他事务操作不了，直到锁表的事务commit或timeout
					(5)丢失更新
						多个事务同时对一条记录进行了操作，后提交的事务将先提交的事务操作覆盖
						如果解决：
							悲观锁（认为丢失一直会产生，利用数据库底层的锁实现）
								提供两种锁机制：
									共享锁：
										select * from table lock in share mode（读锁、共享锁）
										被操作的数据被共享锁时，其他事务是不向这条记录添加排他锁的
									排他锁：
										select * from table for update （写锁、排它锁）
										被操作的数据被加上了排他锁，该数据是不能被其他事务查询的，从而避免了丢失更新
									update语句默认加排他锁
							乐观锁（认为丢失更新不一定会参数，利用在程序中添加版本字段实现）
								create table product (
								   id int,
								   name varchar(20),
								   updatetime timestamp
								);
								insert into product values(1,'冰箱',null);
								update product set name='洗衣机' where id = 1;
								
					事务隔离级别总结：
						脏读：一个事务读取到另一个事务未提交数据
						不可重复读：两次读取数据不一致（update）
						虚读：两次读取到的数据不一致（insert）
					事务隔离级别：
						read uncommitted 什么问题都解决不了
						read committed 可以积极脏读
						repeatable read 可以解决脏读，不可重复读，不能解决虚读
						serializable 它会锁表，可以解决所有问题，
						
					安全性：serializable > repeatable read > read committed > read uncommitted 
					性能 ：serializable < repeatable read < read committed < read uncommitted 
	
					结论： 实际开发中，通常不会选择 serializable 和 read uncommitted ，
					mysql默认隔离级别 repeatable read ，oracle默认隔离级别 read committed
						
			2.jdbc中设置
				使用java.sql.Connection接口中提供的方法
					void setTransactionIsolation(int level) throws SQLException
					参数level可以取以下值:
						level - 以下 Connection 常量之一：
						Connection.TRANSACTION_READ_UNCOMMITTED、
						Connection.TRANSACTION_READ_COMMITTED、
						Connection.TRANSACTION_REPEATABLE_READ 
						Connection.TRANSACTION_SERIALIZABLE。
						（注意，不能使用 Connection.TRANSACTION_NONE，因为它指定了不受支持的事务。） 
				
				
				
*/
public class Demo2 {
	
	//jdbc中设置事务隔离级别
	@Test
	public void test1() throws SQLException{
		Connection connect = Demo2JdbcUtil.getConnect();
		connect.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
	}
	
	
}
