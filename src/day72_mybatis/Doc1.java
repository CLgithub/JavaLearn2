package day72_mybatis;

/*
mybatis是一个java持久层框架，java中操作关系型 数据库用的是jdbc，mybatis是对jdbc的一个封装。

1、从一个jdbc程序开始，通过jdbc 程序找到使用原生态的jdbc开发程序，存在哪些问题？？
	通过学习mybatis，mybatis是如何解决这些问题。
2、mybatis的架构（重点）
3、mybatis入门程序（重点）
	实现用户的查询、添加、修改、删除
4、mybatis开发dao的两种方法（重点）
	原始的dao开发方式（dao接口和dao实现都需要编写）
	mapper代理开发（只需要写dao接口）
5、输入映射类型和蔬菜映射类型
6、动态sql

第二天：
	高级映射查询（一对一，一对多，多对多）
	查询缓存
	延时加载
	mybatis和spring整合（重点）
	mybatis逆向工程
	
项目驱动开发
	先导入sql_table.sql，再导入sql_data.sql(记录系统的初始化数据)
	通常需要提供初始化数据的数据库脚本。


1.jdbc编程中的问题
	在企业开发中，根据项目大小，特点进行技术选择，jdbc操作数据库时效率高，jdbc也是技术选择的参考
	
3	mybatis架构(重点)
	3.1	mybatis介绍
		MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁
		移到了google code，并且改名为MyBatis，实质上Mybatis对ibatis进行一些改进。
		 目前mybatis在github上托管。git（分布式版本控制，当前比较流程）
		MyBatis是一个优秀的持久层框架，它对jdbc的操作数据库的过程进行封装，使开发者只需要关注 SQL 本
		身，而不需要花费精力去处理例如注册驱动、创建connection、创建statement、手动设置参数、结果
		集检索等jdbc繁杂的过程代码。
		Mybatis通过xml或注解的方式将要执行的各种statement（statement、preparedStatemnt、Callabl
		eStatement）配置起来，并通过java对象和statement中的sql进行映射生成最终执行的sql语句，最
		后由mybatis框架执行sql并将结果映射成java对象并返回。
		
		
mybatis是什么？
	mybatis是一个持久层框架，是apache下的开源项目，前身是itbatis，是一个不完全的ORM框架，mybatis提供输入和输出的映射，需要程序员自己写sql语句，mybatis重点对 sql语句的灵活操作。
	适合用于：需求变化频繁， 数据模型不固定的项目，例如：互联网项目。

mybatis架构？
	SqlMapConfig.xml（名称不固定），配置内容：数据源、事务、properties、typeAliases、settings、mapper配置。

	SqlSessionFactory--会话工厂，作用是创建SqlSession，实际开发中以单例模式管理 SqlSessionFactory。
	
	SqlSession--会话，是一个面向用户（程序员）的接口，使用mapper代理方法开发是不需要程序员直接调用sqlSession的方法。是线程不安全，最佳适用场合方法体内。

mybatis开发dao的方法：
	1、原始dao开发方法，需要程序员编写dao接口和实现类，此方法在当前企业中还有使用，因为ibatis使用的就是原始dao开发方法。
	2、mapper代理方法，程序员只需要写mapper接口（相当于dao接口），mybatis自动根据mapper接口和mapper接口对应的statement自动生成代理对象（接口实现类对象）。
	开发需要遵循规则：
	 1）mapper.xml中namespace是mapper接口的全限定名
	 2）mapper.xml中statement的id为mapper接口方法名
	 3）mapper.xml中statement的输入映射类型（parameterType）和mapper接口方法输入参数类型一致
	 4) mapper.xml中statement的输出映射类型（resultType）和mapper接口方法返回结果类型一致

resultType和resultMap都可以完成输出映射：
	resultType映射要求sql查询的列名和输出映射pojo类型的属性名一致
	resultMap映射时对sql查询的列名和输出映射pojo类型的属性名作一个对应关系。

动态sql：
	#{}和${}完成输入参数的属性值获取，通过OGNL获取parameterType指定pojo的属性名。
    #{}：占位符号，好处防止sql注入
	${}：sql拼接符号
	if
	where 
	foreach

	
	
	
		


*/
public class Doc1 {

}
