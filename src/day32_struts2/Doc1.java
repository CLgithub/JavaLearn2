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
				
	问题5:如何向valuesStack中存储数据（主要是向root（list）中保存）（Demo4）
		主要有两个方法
			public void push(Object o);
				底层是奖数据存入root(list)的第0个位置,奖数据存入栈顶,下一个数据来时这个数据向下移动（ArraylistTest）		add(0, o);
			public void set(String key, Object o);	
				底层：将数据存储进一个HeshMap，将这个HeshMap又压入root的栈顶
				
		也就是说，push进去的数据，通过栈顶取，set进去的数据，通过栈顶去出来时一个map，
		
		在啊jsp页面通过<s:debug />可以调试查看
		
	问题6:在jsp页面如何获取valuesStack中存储的数据（Demo4）
		1.根据map的key依次查找数据
			<s:property value="#root"/><br>
			<s:property value="#root.userName"/><br><!-- #root不省略，相当于是取出context中的root，再从root中去取 -->
			<s:property value="userName"/><br><!-- #root省略,相当于时从root中去取  -->
		2.从某个位置开始查找数据，top只查找某个位置的数据
			<s:property value="[0]"/>	从0的位置向下查找所有
			<s:property value="[0].top"/>	只查找0位置上的数据
		
		如何获取context中的数据
			1.request数据	
			2.session数据	
			3.appliction数据		
			4.attr		从小到大依次查找request,session,application中查找
			4.parameters数据		获取请求参数
	
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
valueStack主流应用：解决将action中的数据携带到jsp页面的问题
	问题：action向jsp携带的数据，都是什么样的数据
		1.文本（字符串）
			1.fieldError	校验数据错误信息提示
			2.actionError	关于逻辑操作时的错误信息（例如登录失败）
			3.message		就是一个信息.
				
				this.addFieldError("msg", "字段错误信息");
				this.addActionError("Action全局错误信息");
				this.addActionMessage("Action的消息信息");

				* fieldError 针对某一个字段错误信息 （常用于表单校验）、actionError (普通错误信息，不针对某一个字段 登陆失败)、 actionMessage 通用消息 	

				在jsp中使用 struts2提供标签 显示消息信息
					<s:fielderror fieldName="msg"/>
					<s:actionerror/>
					<s:actionmessage/>
		2.复杂数据（demo5）
			可以使用valueStack存储(详细看demo5)
			
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
关于默认压入到valueStack中的数据
	1.访问的action对象会被压入valueStack中
		在com.opensymphony.xwork2.DefaultActionInvocation.class的初始化方法中压入的,(所有拦截器执行之前)
		action如果想传递数据给jsp，只要将数据保存到成员变量，并且提供get方法就可以了（demo5）
	2.ModelDriveInterceptor会执行下面操作
		ModelDriven modelDriven = (ModelDriven) action;
		ValueStack stack = invocation.getStack();
		Object model = modelDriven.getModel();
		if (model !=  null) {
			stack.push(model);
		}
		将实现了ModelDrive接口的action中getModel方法的返回值，也就是我们所说的model对象压入到了
		valueStack.
		
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	问题7：为什么el可以访问valueStack中数据（demo6）
		struts2框架中所使用的request对象，时增强后request对象
		${userName}--->request.getAttribute("userName");
		增强后的request，会首先在request域范围查找，如果查找不到，会在valuesStack中查找
		
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	ognl表达式常见使用（$ % #）
	   	1.#
	   		用法一  
	   			# 代表 ActionContext.getContext() 上下文
					<s:property value="#request.name" />  
					#request
					#session
					#application
					#attr
					#parameters 
		  	用法二
			  	不写#,默认在root中查找数据
			 		或写成#root在root中查找
	 		用法三 ：进行投影映射 （结合复杂对象遍历 ）(demo7)
				1）集合的投影(只输出部分属性)
		 			集合的投影(只输出部分属性)<br>
					<s:iterator value="users.{userName}" var="user">
						<s:property value="#user"/>	<br>
					</s:iterator>
				2）将年龄下于24岁的人得到<br>
					<s:iterator value="users.{?#this.age<24}" var="user">
						<s:property value="#user"/>
						<br>
					</s:iterator>
				3）将年龄下于24岁的人的名称得到<br>
					<s:iterator value="users.{?#this.age<24}.{userName}" var="un">
						<s:property value="#un"/>
						<br>
					</s:iterator>
				4)使用＃来构建map集合<br>
					<s:iterator value="#{'name':'tom','age':20}" var="entry">
						<s:property value="#entry.key"/>=<s:property value="#entry.value"/>
						<br>
					</s:iterator>
					构建list集合<br>
					<s:iterator value="{'aa','bb','cc'}" var="v">
						<s:property value="#v"/>
						<br>
					</s:iterator>
					手动构建集合，经常结合 struts2 标签用来生成 select、checkbox、radio
					<s:form>
						<s:radio list="{'男','女'}" name="gerden" /><br>
						<s:radio list="#{'male':'男','female':'女'}" name="gerden2" />
						<s:select list="{'aa','bb','cc'}" />
					</s:form>
	   	2.%
	   		作用：就是用于设定当前是否要解析其为 ognl表达式.(demo8)
	   			%{表达式}  当前表达式会被做为ognl解析.
				%{'表达式'} 当前表达式不会被做为ognl解析。
				
		   		<s:property value="表达式"> 对于s:property标签，它的value属性会被默认做为ognl.
				以后，所有表达式如果想要让其是ognl  %｛表达式｝
		3.$
			作用：就是在配置文件中使用ognl表达式来获取valueStack中数据.
			1.struts.xml（demo9）
				<result type="stream">
					<param name="contentType">${contentType}</param>(以前也使用过)
				</result>
			2.在校验文件中使用
				${min}  ${max}
				${minLength} ${maxLength}
			3.在国际化文件中使用
				在properties文件中
					username=${#request.username}
				在jsp页面
					<s:text name="username">
					
*/
public class Doc1 {

}
