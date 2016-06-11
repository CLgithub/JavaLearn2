package day19_2;

/*
分页查询
	将数据分成多页去展示
	分页的分类
		1.物理分页
			只从数据库中查询出当前页的数据
			优点：占用很多内存
			缺点：效率相对低
		2.逻辑分页
			将所有数据查询出来放内存中，显示当前页数据
			优点：效率高
			缺点：占用内存
		java中，较多使用物理分页
			物理分页的实现
				1.直接使用jdbc完成
					使用滚动结果集		优点：跨数据库，缺点：性能低
				2.使用数据库本身提供的分页操作
					使用各个数据库特定的分页函数，优点：性能高，缺点：不能跨数据库
					mysql：limit
					sqlserver：top
					oracle：rownum
					
		limit的使用
			分页查询总结：每页显示m条记录，查询第n页的记录	(day15Mysql.Demo3)
			  	select * from students limit (n-1)*m,m
			
			
*/
public class Demo5 {

}
