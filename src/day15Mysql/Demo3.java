package day15Mysql;

/*
管理数据：
	查询：（单表） select
		1.查询所有列	
			select * from 表名;
			select * from students;
		2.查询指定列
			select 要查询的列，用","隔开 from students;
			select id,name from students;
		3.查询时指定别名
			select id as 编号,name as 姓名 from students as s;	在多表查询时，经常使用表的别名
		4.查询时添加常量列
			需求：在查询student表时，添加一个班级列grader，内容为“java班”
			select id,name,'java班' as grader from students
		5.查询时合并列
			需求：查询每个学生的servlet和jsp的总成绩
			select id,name,(servlet+jsp) as '总成绩'	from students;
				注意：合并列只能合并数值类型的字段
		6.查询时去除重复记录
			需求：查询学生的性别类型
			select distinct gender from students;
			另一种语法
			select distinct(gender) from students;
			需求：查询学生来自哪些地区
			select distinct address from students;
		7.条件查询	where
			逻辑条件		and(与)		or(或)
				需求：查询id为2，且姓名为小红的学生
				select * from students where id=2 and name='小红';
				需求：查询id为2,或者姓名为小白的学生
				select * from students where id=2 or name='小白';
			比较条件		>	<	>=	<=	<>(不等于)	between and
				需求：查询servlet成绩大于70的学生
				select * from students where servlet>70;
				需求：查询jsp的成绩大于等于70，且小于等于80的学生
				select * from students where servlet>=70 and servlet<=80;
				另一种语法
				select * from students where servlet between 70 and 80;	--(包前包后)
				需求：查询所有性别不等于男的学生
				select * from students where gender<>'男';
			判空条件		is null		is not null		=''	<>''
				null代表没有值，''代表空字符串
				需求：查询没有地址的学生(null或者空字符串)
				select * from students where address is null or address='';
				需求：查询有地址的学生
				select * from students where address<>'' and address is not null;
			模糊标记		like	%替换任意字符	_替换一个字符
				需求：查询姓张的学生
				select * from students where name like '张%';
				需求：查询姓李且姓名只有两个字的学生
				select * from students where name like '李_';
		8.聚合查询
		9.分页查询
		10.查询排序
		11.分组查询
		12.分组查询后筛选 
		
		
		
		
	练习一：查询操作练习(在学生表数据基础上：student.sql)
		查询表中所有学生的信息。
			select * from student;
		查询表中所有学生的姓名和对应的英语成绩。
			select name,english from student;
		过滤表中英语成绩的重复数据
			select distinct english from student;
		使用别名表示学生分数。
			select name,chinese as 语文,english as 英语,math as 数学 from student;
		查询姓名为李一的学生成绩
			select name,chinese as 语文,english as 英语,math as 数学 from student where name='李一';
		查询英语成绩大于等于90分的同学
			select * from student where english>='90';
		查询总分大于200分的所有同学
			select *,(chinese+english+math) as 总成绩 from student having 总成绩>200;
		查询所有姓李的学生英语成绩。
			select name,english from student where name like '李%';
		查询英语>80或者总分>200的同学
			select *,(chinese+english+math) as 总成绩 from student having english>80 OR 总成绩>200;
		统计每个学生的总分。
			select *,(chinese+english+math) as 总成绩 from student;
		在所有学生总分数上加10分特长分。
			select *,(chinese+english+math+10) as 总成绩 from student;

*/
public class Demo3 {

}
