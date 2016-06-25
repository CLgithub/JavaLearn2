package day32_struts2;

/*

ognl与valueStack
	问题:ognl是什么，它有什么用?
		OGNL是Object-Graph Navigation Language的缩写，它是一种功能强大的表达式语言.
		比el表达式功能强大。
		struts2将ognl表达式语言，集成当sturts2框架中，做为它的默认表达式语言。
		
		OGNL 提供五大类功能 
		   1、支持对象方法调用，如xxx.doSomeSpecial()； 
		   2、支持类静态的方法调用和值访问
		   3、访问OGNL上下文（OGNL context）和ActionContext； （重点 操作ValueStack值栈 ）
		   4、支持赋值操作和表达式串联
		   5、操作集合对象。


	问题:valueStack是什么，它有什么用?
		值栈
		它是什么，从两个方面：
			1.技术方面，valuesStack就是一个接口
			2.使用角度	valuesStack是个容器
			
		我们使用valuesStack最大的作用就是讲action相关的数据以及web相关的对象，携带到页面上。
		简单说，我们在strtus2中通过valuesStack讲action中的数据携带到jsp页面上进行展示
		
	问题：ognl与valuesStack它们什么关系
		在页面上通过ognl表达式讲valuesStack中数据取出来
	
*/
public class Doc1 {

}
