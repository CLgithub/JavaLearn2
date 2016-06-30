package day40_spring_tx;

/*
事务回顾：day18_transaction
事务：逻辑上一组操作，要么全部成功，要么全部失败
事务特性
	acid
	原子性：事务不可分割
	一致性：事务执行前后，数据保持一致
	隔离性：事务之间不能相互影响
	持久性：事务执行后，数据会发送持久性的改变
	
如果不考虑隔离性：
	脏读：一个事务读到了另一个事务未提交的数据
	不可重复读：一个事务读到了另一个事务已经提交的数据，前后两次读取数据不一致，（数据内容改变）
	虚读：个事务读到了另一个事务已经提交的数据，前后两次读取数据条数不一致
事务隔离级别：
	1 serializable：（串行的）可避免脏读、不可重复读、虚读情况的发生。（串行化）
	2 repeatable read：（再次 读）可避免脏读、不可重复读情况的发生。（可重复读）不可以避免虚读
	3 read committed：（已提交读）可避免脏读情况发生（读已提交）
	4 read uncommitted：（未提交读）最低级别，以上情况均无法保证。(读未提交)
	
spring中的事务管理
	分层开发：事务处于Service层
	spring提供的事务管理API：
	PlatformTransactionManager	平台事务管理器
		commit(TransactionStatus status)
		getTransaction(TransactionDefinition definition)
		rollback(TransactionStatus status)	
	TransactionDefinition		事务定义信息（交易描述）
		ISOLation_XXX:事务隔离级别
		PROPAGATION_XXX:事务的传播行为（不是jdbc中有的，为了解决时间开发的问题）
		过期时间：
	TransactionStatus			事务状态
		是否有保存点，
		是否是一个新的事务
		事务是否已经提交
		
	关系：PlatformTransactionManager通过TransactionDefinition设置事务相关信息来管理事务，管理过程中，产生一些事务状态：状态由
		TransactionStatus来记录
	
	API详细：
		PlatformTransactionManager:接口.
			Spring为不同的持久化框架提供了不同PlatformTransactionManager接口实现
		org.springframework.jdbc.datasource.DataSourceTransactionManager	:使用Spring JDBC或iBatis 进行持久化数据时使用（常用）
		org.springframework.orm.hibernate3.HibernateTransactionManager		:使用Hibernate3.0版本进行持久化数据时使用（常用）
		org.springframework.orm.jpa.JpaTransactionManager	使用JPA进行持久化时使用
		org.springframework.jdo.JdoTransactionManager	当持久化机制是Jdo时使用
		org.springframework.transaction.jta.JtaTransactionManager	使用一个JTA实现来管理事务，在一个事务跨越多个资源时必须使用
	
	TransactionDefinition
		ISOLATION_DEFAULT：				默认级别。mysql:repeatable_read		oracle:read_commited
		ISOLATION_READ_UNCOMMITTED
		ISOLATION_READ_COMMITTED
		ISOLATION_REPEATABLE_READ
		ISOLATION_SERIALIZABLE
		
	事务的传播行为:(不是JDBC事务管理，用来解决实际开发的问题.)传播行为：解决业务层之间的调用的事务的关系.
		PROPAGATION_REQUIRED：		支持当前事务，如果不存在 就新建一个
			A调用B	如果A有事务，B使用A的事务，如果A没有事务，B就开启一个新的事务.(A,B是在一个事务中。)
		PROPAGATION_SUPPORTS:		支持当前事务，如果不存在，就不使用事务
			A调用B	如果A有事务，B使用A的事务，如果A没有事务，B就不使用事务.
		PROPAGATION_MANDATORY：		支持当前事务，如果不存在，抛出异常
			A调用B	如果A有事务，B使用A的事务，如果A没有事务，抛出异常.
		PROPAGATION_REQUIRES_NEW：	如果有事务存在，挂起当前事务，创建一个新的事务
			A调用B	如果A有事务，B将A的事务挂起，重新创建一个新的事务.(A,B不在一个事务中.事务互不影响.)
		PROPAGATION_NOT_SUPPORTED：	以非事务方式运行，如果有事务存在，挂起当前事务
			A调用B	非事务的方式运行，A有事务，就会挂起当前的事务.
		PROPAGATION_NEVER：			以非事务方式运行，如果有事务存在，抛出异常
		PROPAGATION_NESTED：			如果当前事务存在，则嵌套事务执行
			基于SavePoint技术.
			A调用B	A有事务，A执行之后，将A事务执行之后的内容保存到SavePoint.B事务有异常的话，用户需要自己设置A事务提交还是回滚.
			
		常用：
			PROPAGATION_REQUIRED（传播_需求）
			PROPAGATION_REQUIRES_NEW
			PROPAGATION_NESTED（传播_嵌套）
		

*/
public class Doc1 {

}
