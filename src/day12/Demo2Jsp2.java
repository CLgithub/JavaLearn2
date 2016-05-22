package day12;

/*
5 jsp语法
	5.1 jsp模板
		jsp页面中的html代码就是jsp的模板
	5.2 jsp表达式
		语法：<%=变量或表达式%> 	
		作用：向浏览器输出变量的值或表达式计算的结果
		注意：
			1.表达式的原来就是翻译成out.print("内容" );通过该方法向浏览器写出内容
			2.表达式后不需要加;
	5.3 jsp脚本
		语法：<% java代码  %>		
		作用：java代码写在其中
		注意：
			1）原因就是把其中的java代码拷贝到service中去执行
	5.4 jsp的声明
		语法：<%!	变量或方法 %>		
		作用：声明jsp的一个变量或方法
		注意：
			1）如果是变量的话，会翻译成成员变量
			2）如果是方法，会翻译成成员方法
	5.5 jsp的注释
		语法：<%!-- --%>
		注意：html的注释会非翻译和执行，jsp的注释不会被翻译和执行
		
*/
public class Demo2Jsp2 {

}
