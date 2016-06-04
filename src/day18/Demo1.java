package day18;

/*
第一部分xml
第二部分servlet
第三部分db
第四部分：jdbc
	jdbc技术：java数据库连接技术
	接口：
		connection：连接对象
		Statement：执行命令对象，把sql语句发送到数据库执行
						及其两个子接口
		resultSet：结果集接口，必须要保持与数据库的连接
		
	开发步骤：
		1.引入数据库驱动包
		2.加载驱动
			ClassforName
		3.过去连接对象
		4.创建执行sql的stmt对象，写sql
		5.执行sql
			a 更新	insert/delete/update
				executeUpdate();
			b 查询 	select
				executeQuery();
		6.关闭/异常

1.预编译sql处理
2.批量处理
3.插入数据，获取自增长值
4.事物
5.综合练习
		
*/
public class Demo1 {

}
