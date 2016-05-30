package day15Mysql;

/*
1. 需求：
	设计数据库表存储：（用户考试信息）
			用户信息、考试时间、考试科目与考试成绩，及所属年级！

2. 测试数据：
	U001, 张三，1985-09-09, 广州天河,  
java,80,基础班,  考试时间为2014-01-01  
jsp,90,就业班,  考试时间为2014-03-01
mysql,90, 就业班, 考试时间为2014-04-04 
	U002 ,李四，1995-09-09, 广州越秀, 
java,67,基础班,  考试时间为2014-01-01
mysql,90, 就业班, 考试时间为2014-04-04 
	……….(录入其他记录)

  提示： 最好是四个表（使用约束）


3. 查询需求：
	1. 查询学号是U001的学生参加2014-01-01 “java”课程考试的成绩，要求输出学生姓名和成绩
		select `user`.name,score from user join examination as e join `subject` as s 
			on e.Sid=s.id and `user`.id=e.Uid 
			where `user`.id='U001' and e.Edate='2014-04-01' 
			and s.name='java';
	2. 查询出通过考试（高于60分）的学员所在的姓名、、所属学学习阶段、考试科目名称、学员的成绩。
		select u.name,g.name,s.name,e.score from user u join examination e join grade g join subject s 
			on u.id=e.Uid and e.Gid=g.id and e.Sid=s.id
			where e.score>=60
			order by u.name asc,g.name asc;

	利用子查询语句，筛选出生日期比“李四”大的学生
		select u2.name from user u1 join user u2 
			where u1.name='李四' and u1.birth>u2.birth;
		
	查询“java”课程考试成绩为60-80分的学生名单
		select * from user u join examination e join subject s 
			on u.id=e.Uid and e.Sid=s.id
			where s.name='java' and e.score>=60 and e.score<=80
		或
			select * from user u join (
				select * from examination e
					where e.score>=60 and e.score<=80 and e.Sid=(select id from subject where name='java')
			) as exa on exa.Uid=u.id;
		
	查询参加最近一次“mysql”考试成绩最高分和最低分
		select MAX(score) as '最高',min(score) as '最低' from examination
			where edate=(select max(edate) from examination );
	查询出基础班考试的平均成绩；
		select avg(score) from examination 
			where Gid=(select id from grade where name='基础班')
	需求（存储过程）
	统计并显示2014-04-04的mysql考试平均分
	如果平均分在70以上，显示“考试成绩优秀”
	如果在70以下，显示“考试成绩较差”
	delimiter $
	create procedure pro_getAvg(out str varchar(20))	
	begin
		declare avg double;
		select avg(score) into avg from examination where Sid=(select id from subject where name='mysql');
		if avg>=70 then
			set str='优秀';
		elseif avg<70 then
			set str='较差';
		end if;
	end $
	
	call pro_getAvg(@str);
	select @str;


--创建数据库
	create database myLearn3 default character set utf8;
分析有哪些表，
	student	学生表
		id,name,birth,address
	grade	班级表
		id,name
	subject		学科表
		id,name
	examination		考试表
		id,Uid,Gid,Sid,Edate,Score

--创建学生表
	create table user(
		id varchar(10) primary key,
		name varchar(20) not null,
		birth date,
		address varchar(50)
	);
--创建班级表
	create table grade(id int primary key auto_increment,name varchar(20));
--创建学科表
	create table subject(id int primary key auto_increment,name varchar(20));
--创建考试表
	create table examination(
		id int primary key auto_increment,
		Edate date,
		score int,
		Uid varchar(10),
		Gid int,
		Sid int,
		constraint user_subject_fk foreign key(Uid) references user(id),
		constraint geade_subject_fk foreign key(Gid) references grade(id),
		constraint subject_subject_fk foreign key(Sid) references `subject`(id)
	);
	
插入数据
	insert into user(id,name,birth,address) values('U005','小白','1985-09-09','广州深圳');
	
	insert into grade(name) values('基础班');
	insert into grade(name) values('就业班');
	
	insert into subject(name) values('java');
	insert into subject(name) values('jsp');
	insert into subject(name) values('mysql');
	
	


*/
public class Demo9 {

}
