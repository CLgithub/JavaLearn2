package day7_sax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	总结：
		DOM解析	与	SAX解析区别
		
		DOM解析	
			原理： 一次性加载xml文档，不适合大容量的文件读取
			DOM解析可以任意进行增删改成
			DOM解析任意读取任何位置的数据，甚至往回读
			DOM解析面向对象的编程方法（Node，Element，Attribute）,Java开发者编码比较简单。

		SAX解析
			原理： 加载一点，读取一点，处理一点。适合大容量文件的读取
			SAX解析只能读取
			SAX解析只能从上往下，按顺序读取，不能往回读
			SAX解析基于事件的编程方法。java开发编码相对复杂。



		1）Dom4j修改xml文档
			 new XMLWrier();
				......
		2）xPath技术： 快速查询xml节点
				selectNodes()
				selectSinglNode();
			xpath表达式语言		
		3)  SAX解析
				SAXParser parse
					parser（）
			DefaultHandler类：
					startElement();
					characters();
					endElement();
 
 作业：
	设计一个通讯录程序
			联系人： 编号  姓名  性别  年龄  电话  QQ 邮箱
			功能要求：
				添加联系人
				修改联系人
				删除联系人
				查询所有联系人
			
		要求： 
		1）交互使用console（控制台）	
		2）数据存储到xml文件（作为“数据库”）（使用dom4j）
		
		提示：
		启动程序
				================
				【1】添加联系人
				【2】修改联系人
				【3】删除联系人
				【4】查询所有联系人
				【Q】退出程序
				==================
		输入 1：
				请输入编号：
				请输入姓名：
				请输入年龄
			   。。。。
				添加成功！  -> 数据保存在xml中

	 	输入2
				。。。。。。
		输入4
				编号  姓名   年龄  。。。。
				001	  张三  30
				002   李四  20 。。。
				。。。。。
*/
public class Demo4 {
	
}
