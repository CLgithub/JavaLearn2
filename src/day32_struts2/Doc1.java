package day32_struts2;

import java.util.Map;

import com.opensymphony.xwork2.util.CompoundRoot;

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
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	ognl中有一个ognlContext，它可以设置root 与非root，获取数据看Demo1Ongl
	
	重点：学习struts2中使用ognl时，最后要知道谁时ognlContext，谁是root，谁是非root
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
1.ognl介绍
		OGNL是Object Graphic Navigation Language（对象图导航语言）的缩写，它是一个开源项目。 Struts2框架使用OGNL作为默认的表达式语言。
			* xwork 提供 OGNL表达式 
			* ognl-3.0.5.jar
		OGNL 是一种比EL 强大很多倍的语言 

		OGNL 提供五大类功能 
		   1、支持对象方法调用，如xxx.doSomeSpecial()； 
		   2、支持类静态的方法调用和值访问
		   3、访问OGNL上下文（OGNL context）和ActionContext； （重点 操作ValueStack值栈 ）
		   4、支持赋值操作和表达式串联
		   5、操作集合对象。
   演示:在struts2中使用ognl表达式(Demo2.jsp)
		<s:property value="'aaa'.length()"  />	演示对象调用方法
		<s:property value="@java.lang.Math@max(10,20)"  />		演示静态成员访问
		
		<!-- 允许struts2使用ognl表达式是使用静态成员访问 -->
		<constant name="struts.ognl.allowStaticMethodAccess" value="true" />
		
2.ValueStack
	它是一个接口com.opensymphony.xwork2.util.ValueStack.class
	作为一个容器使用，用于携带action数据到jsp页面
	在页面上通过ognl表达式获取数据
	
   	问题1:上面是ValueStack
		1.ValueStack有一个实现类叫OgnlValueStack.
		2.每一个action都有一个ValueStack.（一个请求request，对应一个action，对应一个ValueStack）valueStack生命周期就是request生命周期
		3.valueStack中存储了当前action对象以及其它常用web对象(request,session,application.parameters)
		4.struts2框架将valueStack对象以“struts.valueStack”为名存储到request域中。
		
	问题2:valueStack内部结构（结合图“valueStack内部结构与ognlContext关系.png”来看）
		 public abstract Map<String, Object> getContext();		//得到OgnlContext对象
		 	Map<String, Object>里存储各种映射，重要的常见的web对象，（request,session,application.parameters）
		 	struts会吧下面这些映射压入ContextMap中
		 		parameters：请求参数封装，request，session，application，attr：该map按从小到大的顺序检索某个属性：request，session，application
		 public abstract CompoundRoot getRoot();				//得到CompoundRoot对象	//CompoundRoot是一个CopyOnWriteArrayList
		 	CompoundRoot里存储action相关信息
		 	
	 	ValueStack中 存在root属性 (CompoundRoot) 、 context 属性 （OgnlContext ）
			OgnlContext 就是 Map
			CompoundRoot 就是ArrayList
		map集合中存储的是相关映射信息，包含  paramters,request,session,application attr等。
		list集合中存储的是action相关信息
		
		我们想要从list(CompoundRoot)中获取数据，可以不使用#号.(它就是ognl的root)
		如果从map(OgnlContext)中获取数据，需要使用#. (其实在struts2中的map--context其实就是ognlContext)
		(CompoundRoot(root)在OgnlContext中也有一份，从ognlContext中获取数据都是用#xxx，#root就是得到root(list)对象，)
			
		CompoundRoot在OgnlContext中也有一份
		ognl表达式访问root中的数据是，不需要＃，访问request，session，application，attr，parameters对象数据必须写＃
		操作值栈默认指root元素

		结论：
			ValuesStack中有两部分 List Map		（在map中存有一份list）
			在struts2中List就是root	Map就是ognlContext
			在默认情况下struts2中的ValueStack获取数据从root中获取
	
	问题3:值栈对象的创建 ，ValueStack 和 ActionContext 是什么关系 ？
		ActionContext ctx = ActionContext.getContext();
            if (ctx != null) {
                stack = ctx.getValueStack();
            }
			
		valueStack是每一次请求时，都会创建.
		在ActionContext中持有了valueStack的引用。
		
	问题4:如何获取valueStack对象（Demo3Action.java）
		两种方式：
			1.从request中获取（问题1）
				ValueStack vs=(ValueStack) ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
			2.从ActionContext中获取（问题3）
				ValueStack vs=ActionContext.getContext().getValueStack();
	
	   	
	
*/
public class Doc1 {

}
