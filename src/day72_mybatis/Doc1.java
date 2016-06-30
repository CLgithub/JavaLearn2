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
4.mybatis入门程序
	4.1	需求
		实现用户查询：
			根据用户id（主键）查询用户信息（单条记录）
			根据用户名称模糊查询用户信息（多条记录）
		用户添加
		用户删除 
		用户修改
	4.2	导入jar包
		从mybatis管网下载（地址：https://github.com/mybatis/mybatis-3/releases）
		
	4.3	log4j.properties（公用文件）
	4.4	day72_SqlMapConfig.xml(公用文件)
		通过SqlMapConfig.xml加载mybatis运行环境。
	4.5	mapper.xml
		建议命名规则，表名+mapper.xml
		早期		表名.xml
	4.6 pojo(User.java)(entiey)
	
	
		


*/
public class Doc1 {

}
