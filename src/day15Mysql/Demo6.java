package day15Mysql;

/*
--创建员工表
create table demo6_emp(
	id int primary key auto_increment,
	name varchar(20)
);
--创建部门表
create table demo6_dept(
id int primary key auto_increment,
name varchar(20)
);
--为员工表添加部门id外键
alter table demo6_emp add column deptId int;
alter table demo6_emp add constraint emp_dep_fk foreign key(deptId) references demo6_dept(id);


insert into demo6_dept(name) values ('研发部');
insert into demo6_dept(name) values ('运维部');
insert into demo6_dept(name) values ('行政部');
insert into demo6_dept(name) values ('营销部');

insert into demo6_emp(name,deptId) values ('小明',1);
insert into demo6_emp(name,deptId) values ('小红',3);
insert into demo6_emp(name,deptId) values ('小强',2);
insert into demo6_emp(name,deptId) values ('小张',1);

alter table demo6_emp add column bossId int;
*/

/*
多表查询（关联查询）：交叉，内连接，左右外连接，自己连接

	需求：查询员工及其部门
		交叉链接查询：
			select * from demo6_emp,demo6_dept	产生笛卡尔积（尝试4*4条数据）
		内连接查询：（只有满足条件的结果才会显示）
			步骤：1先确定要查询哪些表，2确定要查询哪些字段，3表与表的连接条件,（连接条件的数量通常是表的数量减1）
			select * 					--哪些字段
			from demo6_emp,demo6_dept 			--哪些表
			where demo6_emp.deptId=demo6_dept.id	--表与表的连接条件
			另一种语法		inner join(内连接)
				select * 
				from demo6_emp inner join demo6_dept
				on demo6_emp.deptId=demo6_dept.id;
			使用别别名
				select * 
				from demo6_emp as e inner join demo6_dept as d
				on e.deptId=d.id;

	需求：查询每个部门的员工
		左(外)连接查询：使用左边表(主表)的数据，去匹配右边表(从表)的数据，如果符合连接条件的结果者显示，如果不符合连接条件者显示null
			(注意：左外连接，左边的数据一定会完全显示) 	left join是left outer join的简写
			select * from demo6_dept left outer join demo6_emp on demo6_dept.id=demo6_emp.deptId order by demo6_dept.id
		
		右(外)连接查询：使用右边表(主表)的数据，去匹配左边表(从表)的数据，如果符合连接条件的结果者显示，如果不符合连接条件者显示null
			select * from demo6_emp right outer join demo6_dept on demo6_dept.id=demo6_emp.deptId order by demo6_dept.id;
	
	需求：查询出员工及其上司
		自连接查询：
			select e1.*,e2.name as 上司 from demo6_emp e1 left join demo6_emp e2 on e1.bossId=e2.id;
			(如果没有上司就不显示)
			select e1.*,e2.name as 上司 from demo6_emp e1 inner join demo6_emp e2 on e1.bossId=e2.id;
			
	
*/
public class Demo6 {

}
