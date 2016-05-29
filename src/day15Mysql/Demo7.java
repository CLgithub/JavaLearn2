package day15Mysql;
/*

*/

/*
存储过程
	存储过程；带有逻辑的sql语句，带上流程控制语句（相当于用sql编程）
	特点：
		1）执行效率非常快，存储过程是在数据库的服务器端去执行
		2）移植性差，不同数据库的存储过程是不能移植的
	语法：
		1创建存储过程语法：
			delimiter $							声明存储过程的结束符
			create procedure pro_test()			定义存储过程名(参数列表)
			begin								开始
				--多个sql语句						要执行流程控制sql，
				select * from demo6_dept;
			end $								结束，对应结束符号
			
		2调用存储过程：call pro_test();				call 存储过程(参数)
		
		删除存储过程：drop procedure pro_testOur;		drop procedure 存储过程名;
	
	
		3参数：
			in		表示输入参数，可以携带数据到存储过程中
			out		表示输出参数，可以从存储过程中返回结果
			inout	表示输入输出参数，既可以输入功能，也可以输出功能
			
			3.1 带有输入参数的存储过程
				需求：创建一个存储过程，功能：传入一个员工的id，查询员工信息
					delimiter $
					create procedure pro_findByid(in eid int)	输入/输出参数 参数名 参数类型
					begin
						select * from demo6_emp where id=eid;
					end $
				调用这个存储过程		call pro_findByid(3)
			
			3.2 带有输出参数的存储过程
				delimiter $
				create procedure pro_testOur(out str varchar(20))	
				begin
					set str='这是一个输出参数';
				end $
				
				调用时需要接收输出值，用一个变量去接收
					定义一个会话变量去接收
					call pro_testOur(@str);		1定义一个会话变量，2使用name会话变量接收存储过程的返回值
					select @str;		查看这个变量的值
				
			3.3 带有输入输出参数的存储过程
				delimiter $
				create procedure pro_testInOur(inout n int)	
				begin
					//查看变量
					select n;
					set n=500;
				end $
				
				set @n=10;					设置一个局部变量
				call pro_testInOur(@n);		把这个局部变量传入存储过程，并且用这个局部变量接收存储过程返回值
				select @n;					查看这个局部变量
			3.4 带有条件判断的存储过程
				需求：输入一个整数，如果1，则返回'星期一'，如果2，则返回'星期二',如果3，则返回'星期三',其他返回'输入错误'
				delimiter $
				create procedure pro_testIf(in num int,out str varchar(20))	
				begin
					if num=1 then
						set str='星期一';
					elseif num=2 then
						set str='星期二';
					elseif num=3 then
						set str='星期三';
					else
						set str='输入错误';
					end if;
				end $
				
				call pro_testIf(2,@xq);		
				select @xq;				查看返回值
				
			3.5 带有循环功能的存储过程
				需求：输入一个整数，求和，例如输入100，返回1～100的和
				delimiter $
				create procedure pro_testWhile(in num int,out sum int)	
				begin
					定义一个局部变量
					declare i int default 1;
					declare res int default 0;
					while i<=num do
						set res=res+i;
						set i=i+1;
					end while;
					set sum=res;
				end $
				call pro_testWhile(100,@sum);
				select @sum;
			
			3.6 使用查询的结果作为返回值
				delimiter $
				create procedure pro_retuNameByid(in eid int,out vname varchar(20))	输入/输出参数 参数名 参数类型
				begin
					select demo6_emp.name into vname from demo6_emp where id=eid;
				end $
				call pro_retuNameByid(2,@vname);
				select @vname;
				



mysql的的变量
	全局变量（内置变量）：mysql数据库内置变量	（所有的连接都起作用）
		查看mysql内置变量	show variables
			show variables like 'character_%';
		查看某个全局变量	select @@变量名
		修改某个全局变量	set 变量名=新值
		
		character_set_client	utf8	mysql服务器的接收数据的编码
		character_set_results   utf8	数据库返回的数据的编码
	会话变量：只存在于当前客户端于数据库服务器端的一次连接当中，如果连接断开，那么会话变量会全部丢失
		定义会话变量	set @变量＝值
		查看会话变量	select @变量
	局部变量：所有在存储过程中使用的变量，只要存储过程执行完毕，局部变量就丢失
	
	
	
	
*/
public class Demo7 {

}
