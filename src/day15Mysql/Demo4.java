package day15Mysql;

/*
sql分类：
	DDL：数据定义语言
		create/drop/alter
	DML:数据操作语言
		insert/delete/update/truncate
	DQL：数据查询语言
		select/show

1.数据约束
	什么时数据约束，对用户操作表的数据进行约束
	常见约束：
		默认值
			作用：当用户不插入值时，使用默认值
				创建一张表demo4，字段address有默认值'地球'
					create table student2(id int,name varchar(20),address varchar(20) default '地球');
			注意：对有默认值的字段插入null，结果就是null
		非空
			作用：某些字段不能为空
				修改性别字段为非空
					alter table demo4 change column gender gender varchar(2) not null;
			注意：
				1。非空字段必须要赋值，
				2.且不能插入null
		唯一
			作用：对字段的值不能重复
			修改id字段为唯一的
				alter table demo4 change column id id int unique;
			注意：约束为唯一的字段可以插入null，且可以插入多个null
			
			所以id应该非空且唯一
				alter table demo4 change column id id int not null unique;
		主键(非空＋唯一)
			作用：通常每张表都会有个主键的字段，用于标记每条数据的唯一性
			修改id为主键
				alter table demo4 change column id id int primary key;	--效果和非空＋唯一相同
			注意：
				设计表的时候，不要选择表的包含业务含义的字段作为主键
		自增长
			作用：让值自定的递增
			修改id为自增长的主键
				alter table demo4 change column id id int not null unique auto_increment;
				或删除后创建：alter table demo4 add column id int primary key auto_increment;
			修改id为自增长的主键,长度为4,0填充，如果不满4位，前面用0填充
				alter table demo4 add column id int(4) zerofill primary key auto_increment;
			注意：
				delete from demo4:不能影响自增长约束
				truncate teble demo4；会影响自增约束，从0开始
		外键	foreign	（此处只会了外键的添加，还不会删除外键和修改外键）
			作用：约束两种表的数据
			创建一个员工表
				create table demo4_2(id int primary key auto_increment,name varchar(20),deptName varchar(20));
			部门名字段存的直接时部门名称，现在单独将部门独立成一张表
			创建一个部门表(主表)
				create table dept(id int primary key auto_increment,deptName varchar(20));
			将demo4_2表的部门名称字段改成部门id
				alter table demo4_2 change column deptName deptId int;
				
			给员工表（从表／副表）表的deptId添加外键约束
				或者添加外键:
					alter table demo4_2 add constraint demo42_dept_fk foreign key(deptId) references dept(id);

				先删除表
					drop table demo4_2;
				重新创建：
					create table demo4_2(
						id int primary key auto_increment,
						name varchar(20),
						deptId int,
						constraint demo42_dept_fk foreign key(deptId) references dept(id)
						--约束			外键约束名称	对外的		外键				 参考表（参考字段）
					);
					
			注意：
				（1）被约束的表被称为从表，约束的表被称为主表，外键设置在从表
				（2）主表的参考字段通常为主键
				（3）当有了外键，添加数据时，先添加主表，后添加从表
				（4）当有了外键，修改数据时，先修改副表，后修改主表
				（5）当有了外键，删除数据时，先删除副表，后删除主表
			级联操作	
				问题：当有了外键约束的时候，必须先修改或删除副表种的所以关联数据，才能修改或删除主表，但是，我们希望直接修改或删除主表数据，从而影响副表数据
				
				级联修改：添加外键时，追加on update cascade
					alter table demo4_2 add constraint demo42_dept_fk foreign key(deptId) references dept(id) on update cascade;
				级联删除：添加外键时，追加on delete cascade
					alter table demo4_2 add constraint demo42_dept_fk foreign key(deptId) references dept(id) on delete cascade;
				级联删除和级联修改都加上
					alter table demo4_2 add constraint demo42_dept_fk foreign key(deptId) references dept(id) on update cascade on delete cascade;
					
			外键管理：
				添加外键
					alter table 表名 add constraint 外键名 foreign key(外键字段名) references 参考表(参考字段)
					alter table demo4_2 add constraint demo42_dept_fk foreign key(deptId) references dept(id)
						后面加上	on update cascade on delete cascade可以实现级联操作
				删除外键
					alter table 表名 drop foreign key 外键名;
					alter table demo4_2 drop foreign key demo42_dept_fk;
					
	
2.数据库设计
3.存储过程
4.触发器
5.mysql权限问题

*/
public class Demo4 {

}
