package day15Mysql;

/*
触发器：当操作了某张表时，希望同时除法一些动作／行为，可以使用触发器
	需求：当向员工表插入一条记录的时候，希望mysql自动同时往日志表插入数据
	
	创建添加触发器			当往员工表插入一条数据之后，就会插入一条数据到Demo8_log日志表
	create trigger tri_empAdd after insert on demo6_emp for each row
		insert into Demo8_log(content) values('员工表插入了一条记录');
		
	创建修改触发器		当员工表修改一条数据之后，就会插入一条数据到Demo8_log日志表
	create trigger tri_empUpd after update on demo6_emp for each row
		insert into Demo8_log(content) values('员工表修改了一条记录');

	创建删除触发器		当员工表删除一条数据之后，就会插入一条数据到Demo8_log日志表
	create trigger tri_empDel after delete on demo6_emp for each row
		insert into Demo8_log(content) values('员工表删除了一条记录');
		
		
mysql权限问题：
	mysql数据库权限问题：
		root账号：拥有所有权限
		权限账号：只拥有部分权限，例如只能操作某个数据库的某张表
		
		如何修改mysql用户密码？	修改为123456
			password函数，md5加密函数
			mysql 5.6之前	修改表记录
				update user set password=password('123456') where user='root';
			mysql 5.7之后	修改变量
				set password=password('123456');
		分配权限：
			grant 权限(多个权限之间用,隔开) on 数据库.表 to '账号名'@'账户类型' identified by '密码';
			权限：
				select insert delete update drop create/ 或,all
				
			分配一个用户user1，密码456123，可以任意地点登陆，只只能查询，删除 mytest1.sys_log_2016_2
				grant select,delete on mytest1.sys_log_2016_2 to 'user1'@'%' identified by '456123';
			给他追加一个可以插入的权限
				grant insert on mytest1.sys_log_2016_2 to 'user1'@'%' identified by '456123';
			给root用户，分配密码123456，任意地点登陆，all权限，任意库，任意表
			例如：grant all on *.* to 'root'@'%' identified by '123456';
			
mysql 备份和还原
	在命令行下操作，到达mysql安装目录bin下，不登陆数据库,
	备份：
		windows：
			mysqldump -u root -p day17 > d:/bak.sql
			mysqldump -u root -p --databases mytest1 > d:/abcd.sql
		mac osx：
			sudo ./mysqldump -u L -p mysqlLearn1>/Users/L/Desktop/bak1.sql
	还原：
		sudo ./mysql -u L -p mysqlLearn1</Users/L/Desktop/bak1.sql 
	
	
*/
public class Demo8 {

}
