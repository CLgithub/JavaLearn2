package day17;

/*

day17~day19
	jdbc
		定义：java database Connectivity	Java 数据库连接
			是Java语言中用来规范客户端程序如何来访问数据库的应用程序接口，
				提供了诸如查询和更新数据库中数据的方法。JDBC也是Sun Microsystems的商标[1]。JDBC是面向关系型数据库的。
		
		核心api：
			|--- Driver接口：表示java驱动程序接口，所有的具体的数据库厂商要来实现这个接口
				|--- connect(url,properties):链接数据库的方法
					url：链接数据库的url
						url语法：jdbc协议:数据库子协议://主机:端口/具体数据库
						user：数据库的用户名
						password：数据库的用户密码
			|---DriverManager类：驱动管理器类。用于管理所有注册的驱动程序
				|- registerDriver(driver):注册驱动对象
					实现类的静态代码块里已经注册了，所以通常使用Class.forName("")注册
				|- Connection getConnection(url,user,password):获取连接对象
			
			|---Connection接口：
				|- Statement createStatement():	创建Statement对象	（Statement 声明）
				|- PreparedStatement prepareStatement(String sql);	创建prepareStatement对象（prepare 准备）
				|- CallableStatement prepareCall(String sql);创建一个CallableStatement对象（能够call）
				
			|---Statement接口：用于执行静态sql语句（父）
				int executeUpdate(Sting sql);执行静态的更新sql语句（DDL,DML）
				ResultSet executeQuery(String sql):执行静态的查询sql语句（DQL）
			
				|---PrepareStatement接口:用于执行预编译sql语句（子）
					int executeUpdate()：执行预编译的更新sql语句（DDL,DML）
					ResultSet executeQuery():执行预编译的查询sql语句（DQL）
					
					|---CallableStatement接口:用于执行存储过程的sql语句（call xxx）（孙）
						ResultSet executeQuery():调用存储过程的方法				
			
			|---ResultSet接口：结果集，用于封装查询出来的数据
				boolean next():将光标移到到下一行
				getXXX():获取列的值
		
		Statement与PreparedStatement的区别
			1 语法上的差异
			2 执行效率上，支持sql缓冲区的 数据库上PreparedStatement会更高，（支持oracle，sql server）（不支持，mysql）
			3 PreparedStatement能防止sql注入
	
		批处理：（day18.Demo2）
			Statement和PrepareStatement对象执行批处理区别?
				1.Statement它更适合执行不同sql的批处理。它没有提供预处理功能，性能比较低。		
				2.PreparedStatement它适合执行相同sql的批处理，它提供了预处理功能，性能比较高。
				
			注意;mysql默认情况下，批处理中的预处理功能没有开启，需要开启
				1.在 url下添加参数
					url=jdbc:mysql:///day17?useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true
				2.注意驱动版本
					Mysql驱动要使用mysql-connector-java-5.1.13以上
	
	
	
	事务：
		概念：事务是逻辑上的一组操作，要么全部成功，要么全部不成功
		4大特性（ACID）：
			原子性（Atomicity）：事务是一组不可分割的工作单位，要么都成功，要么都不发生
			隔离性（Isolation）：事务与事务之间相互隔离，互补影响
			一致性（Consistency）：事务执行前后数据的完整性保持一致
			持久性（Durability）：事务一旦执行，对数据将产生持久性的影响
		
			其中隔离性有4个隔离级别：
				读未提交（read uncommited）：能够读取到其他事务未提交的数据，即脏读
				读提交（read commited）：解决脏读问题，但是会有不可重复读问题，两次读取的数据不一致
				可重复读（repeatable read）：解决不可重复读问题，即使其他事务提交了，这个事务也要先提交，才能读取到其他事务提交的数据，
					但会有丢失更新问题，即后提交的事务将前提交的事务的数据覆盖了
				序列化（serializable）：能解决所有问题，通过锁来完成，但是效率低下
				
			解决丢失更新的方法：
				锁：
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
						
		jdbc中设置
			使用java.sql.Connection接口中提供的方法
				void setTransactionIsolation(int level) throws SQLException
				参数level可以取以下值:
					level - 以下 Connection 常量之一：
					Connection.TRANSACTION_READ_UNCOMMITTED、
					Connection.TRANSACTION_READ_COMMITTED、
					Connection.TRANSACTION_REPEATABLE_READ 
					Connection.TRANSACTION_SERIALIZABLE。
					（注意，不能使用 Connection.TRANSACTION_NONE，因为它指定了不受支持的事务。） 
	
	连接池：
		连接池是什么，有什么用？
			连接池：创建一个容器，用于装入Connection对象，使用连接对象时，从容器中获取一个Connection对象，
			使用完毕后，再将这个Connection重新装入到容器中，这个容器就是连接池（DataSource）,也叫数据源
		作用：我们可以通过连接池获取连接对象Connection
		优点：节省创建连接与释放连接 性能消耗 ---- 连接池中连接起到复用的作用 ，提高程序性能
		
		开源连接池：（详细day18_transaction.Demo4）
			1.dbcp（了解）
				dbcp是apache的一个开源连接池。
				核心api
					BasicDataSource类
			2.c3p0（必会）
				使用
					1.手动
					2.自动
				核心api
					ComboPooledDataSource类
		
			c3p0与dbcp区别
				dbcp没有自动回收空闲连接的功能
				c3p0有自动回收空闲连接功能
		
		tomcat内置连接池管理
			tomcat内置连接池使用的是dbcp
			问题1：tomcat怎么管理连接池
				要想将一个dbcp连接池让tomcat管理，只需要创建一个context.xml配置文件，在配置文件中配置相关信息
				<Context>
				  	<Resource name="jdbc/jdbc1" auth="Container"
							type="javax.sql.DataSource" username="L" password="123456"
							driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql:///jdbc1"
							maxActive="8" maxIdle="4"/>
				</Context>
				context.xml文件位置：
					1.放在tomcat/conf/context.xml		这时这个连接池是给整个服务器用
					2.放在tomcat/conf/Catalina/localhost		这时这个连接池只给localhost虚拟主机使用。
					3.放在web应用的META-INF目录下			只给这个应用用
					
					注意：如果是1，和2，我们需要将数据库驱动放在tomcat/lib目录下
			问题2:怎样从tomcat中获取连接池?
				在Servlet中获取连接池对象
				Context context = new InitialContext();
				Context envCtx = (Context) context.lookup("java:comp/env");	//固定路径
				DataSource dataSource=(DataSource) envCtx.lookup("jdbc/jdbc1");
				
			JNDI----->	JNDI(java naming and directory interface ,java命名和目录接口)是SUN公司提供的一种标准的Java命名系统接口，
							JNDI提供统一的客户端API，通过不同的访问提供者接口JNDI SPI的实现，由管理者将JNDI API映射为特定的命名服务
							和目录系统，使得Java应用程序可以和这些命名服务和目录服务之间进行交互。目录服务是一种命名服务，
							在这种服务里，对象不但有名称，还有属性。
	
	BenUtils
		
		
	元数据(day19_2.Demo2)
		什么是元数据。又什么作用
			元数据（metaData）指数据中 库、表、列的定义信息
		1.DataBaseMetaData		数据库元数据
			问题:怎样获取一个DataBaseMetaData?
				DatabaseMetaData dMetaData = connection.getMetaData();
			问题：常用api
				数据库驱动名：	dMetaData.getDriverName();
				数据库url：		dMetaData.getURL();
				数据库用户名：	dMetaData.getUerName();
				数据库产品名称：	dMetaData.getDatabaseProductName();
				数据库产品版本：	dMetaData.getDatabaseProductVersion();
				
				获取表中主键相关描述		每个主键列描述都有以下列：
					TABLE_CAT String 	=> 表类别（可为 null） 
					TABLE_SCHEM String	=> 表模式（可为 null） 
					TABLE_NAME String 	=> 表名称 
					COLUMN_NAME String 	=> 列名称 
					KEY_SEQ short 		=> 主键中的序列号（值 1 表示主键中的第一列，值 2 表示主键中的第二列）。 
					PK_NAME String 		=> 主键的名称（可为 null）
		2.ParameterMetaData		参数元数据
			参数元数据主要用于获取:sql语句中占位符的相关信息.
			问题:怎样获取ParameterMetaData?
				在PreparedStatement中有一个方法getParameterMetaData可以获取.
		3.ResultSetMetaData		结果集元数据
			问题:怎样获取结果集元数据?
				可以通过ResultSet的getMetaData()方法获取.
			利用结果集元数据可以做出通用的DAO，而DBUtils更方便
				
	DBUtils（day19_2.Demo3）
		DBUtils核心
			1.QueryRunner类
				用于执行sql语句的类
				1.query 用于执行select
				2.update 用于执行update delete insert
				3.batch 批处理
			2.ResultSetHandlerh接口
				用于定义结果集封装
				提供9个实现类，可以进行不同的封装
			3.Dbtuils类
				提供关于关闭资源以及事务rollback，commit操作


*/
public class Day17_Day19 {

}
