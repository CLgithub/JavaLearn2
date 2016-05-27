package day15Mysql;

/*
mysql数据库
数据库
	数据库就是一个文件系统，访问数据的时候需要通过标准的sql语言来完成
	
关系型的数据
	保存的实体与实体之间的关系（用户、商品、）
常见的数据库
	oracle 		公司oracle（甲骨文）数据库产品，收费的大型数据库
	mysql		开源的，被oracle收购了，小型的数据库，5.x版本免费，6.x收费
	sqlServer	微软的，收费的中型数据库
	DB2			ibm公司收费大型的数据库
	syBASE		powerDigener软件
	
mysql的简介
	windows下卸载：
		1.先找到安装目录，找到my.ini配置文件，找到
		basedir="C:/Program Files (x86)/MySQL/MySQL Server 5.5/"		安装的路径
		datadir="C:/ProgramData/MySQL/MySQL Server 5.5/Data/"			MySQL存储数据的路径
		
		通过控制面板卸载
		找到上面的两个路径，完全删除ok了
	
	windows下安装：
		MySQL默认端口是3306，不要修改。
		设置MySQL的编码集（采用UTF-8的编码）
		要把黑窗口的勾勾选上。
		设置用户名的密码：两行都是密码，第一行是密码，第二行是确认密码。
		安装完成。
		
进入数据库：
	windows，启动服务，电开mysql command Line Client,输入密码即可
	
	mac os：
		启动或停止服务：/usr/local/mysql-5.7.10-osx10.9-x86_64/support-files目录下，
			执行 sudo sh mysql.server (start/stop) 
		
		进入：/usr/local/mysql-5.7.10-osx10.9-x86_64/bin目录下
			执行sudo ./mysql -u L -p
			输入密码即可
	mac os下安装后有问题解决方案看印象笔记
		
mysql数据存储结构：
	数据库－－》表－－－》数据
	
		
		
*/
public class Demo1 {

}
