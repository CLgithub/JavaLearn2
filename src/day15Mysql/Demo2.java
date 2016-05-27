package day15Mysql;

/*
	sql语言：和数据库交互的语言，进行数据库管理的语言（Structure Query Language 机构化查询语言）
	
	登陆mysql后：
		查看有哪些数据库		show databases;
		+--------------------+
		| Database           |
		+--------------------+
		| information_schema |		-mysql元数据，基础数据
		| mysql              |		－mysql配置数据库，其中包含用户信息
		| performance_schema |		－mysql数据库软件的运行数据，日志信息，性能数据
		| sys                |		
		+--------------------+
	
	数据库管理：
		创建数据库
			create database 数据库名;		(默认)
			create database 数据库名 default character set utf8	指定编码
		删除数据库
			drop database 数据库名;
		查看数据库字符集：
			show create database 数据库名;
		修改数据库字符集
			alter database 数据库名 default character set gbk;
	
	表管理；
		选择数据库
			use mysqlLearn1;
		
		创建表
		    create table student(sid int,sname varchar(20),sage int);
			表名tab1，主键id，自增长，……
		     create table tab1( id int(11) auto_ increment primary key, test varchar(80)   );
     	删除表
     		drop table 表名;
 		查看所有表
			show tables;
 		修改表字段		alter table 表名
			修改表名	rename to
				alter table 表名 rename to 新表名;
				例：alter table student rename to students;
			新增字段	add column
				alter table 表名 add column 字段名 字段类型;
				例：alter table student add column gender varchar(2);
			删除字段	drop column
				alert table 表名 drop 字段名
				例：alter table student drop column gender;
			修改字段	change column
				alter table 表名 change column 原字段名 新字段名 新字段类型;
				例：alter table student change column remark remark varchar(100);
				例：alter table student change column remark sremark varchar(100);
			查看表结构
	     		desc 表名;
		
		
		
*/
public class Demo2 {

}
