package day23;

import java.util.Locale;
import java.util.ResourceBundle;

/*
国际化
	什么是国际化，国际化有什么作用
		软件的国际化：软件开发时，要使它能同时应对世界不同地区和国家的访问，并针对不同地区和国家的访问，
		提供相应的、符合来访者阅读习惯的页面或数据。
		国际化又称为 i18n：internationalization
		
		对于程序中固定使用的文本元素，例如菜单栏、导航条等中使用的文本元素、或错误提示信息，状态信息等，
		需要根据来访者的地区和国家，选择不同语言的文本为之服务。
		对于程序动态产生的数据，例如(日期，货币等)，软件应能根据当前所在的国家或地区的文化习惯进行显示。
		
		可以提供更友好的访问习惯。
	
	问题：怎样实现国际化
		真对于不同的国家与地区要显示的信息，都配置到文件中
		根据当前访问者的国家或语言来从不同的配置文件中获取信息
		展示在页面上
	问题：关于配置文件
		所谓配置文件就是一组properties文件，它们叫做资源包
		相关概念
			对于软件中的菜单栏、导航条、错误提示信息，状态信息等这些固定不变的文本信息，可以把它们写在一个properties文件中，
			并根据不同的国家编写不同的properties文件。这一组properties文件称之为一个资源包。

			ResourceBundler，它是用于从资源包中获取数据的。
			
			关于资源文件(properties)命名:
				基名_语言_国家.properties
				
				message_zh_CN.properties
				message_en_US.properteis
	-----------------------------------------------
	编码演示		properties文件操作以及通过ResourceBundler来获取资源包中的信息(Demo1)
		1.资源包文件一般都放在在classpath下（对于eclipse就是src）
		2.关于ResourceBundle使用
			创建：
				ResourceBundle bundle=ResourceBundle.getBundle("message");
				ResourceBundle bundle=ResourceBundle.getBundle("message",Locale.US);
			获取：
				String msg = bundle.getString("msg");
			扩展：关于properties文件中中文问题处理？
				在jdk中有一个命令native2ascii.exe。
				1.进行一次翻译
					native2ascii	回车
					中文		回车
				2.批量翻译
					native2ascii  源文件路径   目录文件路径
					例如: native2ascii d:/a.txt  d:/a.properties
	---------------------------------------------------------------
	国际化登录页面（Demo2.jsp）
	
	-----------------------------------------------
	关于日期国际化（Demo3）
		DateFormat类
		作用：
			1.将一个Date对象格式化成一个指定效果的String 	format方法
			2.将一个Sring解析成Date对象			parse方法
		
		1.DateFormat对象创建
			
	货币国际化
		NumberFormat类（Demo4）
			Format
				正向		format方法
				反向解析	parse方法
			--|DateFormat
			--|NumberFormat
				1.对数值进行格式化
				2.对数值进行百分比
				3.对数值进行以货币显示
		
		
			
*/
public class Doc1 {

}
