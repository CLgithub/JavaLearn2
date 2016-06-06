package day18_transaction;

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

事务特性(重点) ACID
	1.原子性（Atomicity）原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。 
	2.一致性（Consistency）事务前后数据的完整性必须保持一致。
	3.隔离性（Isolation）事务的隔离性是指多个用户并发访问数据库时，一个用户的事务不能被其它用户的事务所干扰，多个并发事务之间数据要相互隔离。
	4.持久性（Durability）持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响
	
	如果不考虑事务隔离性，会出现什么问题？
		1.脏读 一个事务读取到另一个事务的未提交数据。
		2.不可重复读	两次读取的数据不一致(update)
		3.虚读(幻读)	两次读取的数据一一致(insert)
		4.丢失更新	两个事务对同一条记录进行操作，后提交的事务，将先提交的事务的修改覆盖了。
		
		

*/
public class Demo1 {

}
