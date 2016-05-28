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
		     create table tab1( id int(11) auto_increment primary key, test varchar(80)   );
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
		
		
	表管理练习：
		1.创建一个员工表
			字段     属性
			id        整形(int)
			name     字符串(varchar)（长度为20）
			gender    字符串（长度为2）
			birthday  日期型(date)
			email	   字符串（长度为10）
			remark     字符串（长度为50）
			
		create table emp( id int, name varchar(20),gender varchar(2),birthday date,
			eamil varchar(10),remark varchar(50));
		
		2.修改表练习
			2.1 在员工表基础上增加age列
				alter table emp add column age int;
			2.2 修改email列长度为50
				alter table emp change eamil email varchar(50);
			2.3 删除remark列
				alter table emp drop reamak;
			2.4 列名name修改为username
				alter table emp change name username varchar(20);
				
	管理数据：
		增：
			插入所有字段，必须依次按序
				insert into 表名 values(各字段值，中间用“,”隔开);		按顺序
				例：insert into students values(2,"小红",22,"",'女');
			插入部分字段
				insert into 表名(字段名中间用“,”隔开) values(各字段对应值，中间用“,”隔开);	
				例：INSERT INTO students(id,name) values(3,'小白');
		删：
			delete from 表名 where 条件;
			例：delete from students where id=3;
			另一种方式		清空表
				truncate table 表名;
				truncate table students;
				
			delete 和 truncate 的区别
				delete：
					（1）delete可以带条件删除，		（2）delete只能删除表的数据，不能删除表的约束	（3）delete删除的数据是可以回滚的
				truncate：
					（1）truncate不能带条件删除，	（2）既可以删除表数据，也可以删除表的约束		（3）truncate删除的数据是不能回滚
		
		改：
			update 表名 set 字段名='字段值',字段名2='字段值2' where 条件;
			例：update students set gender='男' where id='1';
		
		查：Demo3.java
			
		
*/
public class Demo2 {

}
