package day30_struts2;

import java.util.List;
import java.util.Map;

/*
struts2中获取请求参数
	在struts2中action是什么（mvc）
		V:jsp
		M:action
		C:action  StrutsPrepareAndExecuteFilter
		
	在struts2中获取请求参数：
		1.属性驱动
			1.直接将action作为一个model，就可以得到请求参数
				//属性驱动1：将action作为model
				private String name;
				private String password;
				get/set方法。。。
				问题1：action封装请求参数，会不会存在线程安全问题
					不会：因为每次请求都是一个新的action
					缺点：需要单独定义javaBean，将action中的属性copy到javabean中
					优点：简单
				底层：反射实现
			2.在action中声明一个javaBean（mode）
					private User user;
					get/set方法。。。
				在页面上使用ognl描述
					<input type='text' name='user.name' id='name'  />
				优点：简单
				缺点：在页面上使用了ognl表达式，页面不通用了
				
				问题：这种方式，数据是怎样封装的？
					通过struts中的一个拦截器interceptor
					<interceptor name="params" class="com.opensymphony.xwork2.interceptor.ParametersInterceptor"/>
					
		2.模型驱动（在开发中应用比较多）（Demo1LoginAction2）
			步骤：
				1.让action实现ModelDriven接口
				2.重写getModel方法
				3.在action中实例化一个model对象，让getModel方法返回这个对象
				private User user = new User();
				@Override
				public User getModel() {
					return user;
				}
			优点：解决了属性驱动存在的问题
			缺点：一次只能封装一个model对象
		struts2 有很多围绕模型驱动的特性 
			* <interceptor name="modelDriven" class="com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor"/> 为模型驱动提供了更多特性
--------------------------------------------------------------
	扩展：
		1.将数据封装到list集合
			jsp页面：
				<input type='text' name='users[0].name' />
				<input type='text' name='users[0].password' />
				<input type='text' name='users[1].name' />
				<input type='text' name='users[1].password' />
			action类：
				private List<User> users;
				get/set方法
				
		2.将数据封装到map集合
			jsp页面
				<input type='text' name="map['aaa'].name" />
				<input type='text' name="map['aaa'].password" />
				<input type='text' name="map['bbb'].name" />
				<input type='text' name="map['bbb'].password" />
			action类：
				private Map<String, User> map;
				get/set方法
----------------------------------------------------------------
struts中提供的类型转换
	在web中文名使用beanUtils直接将表单数据封装到javaBean中，---类型转换
	struts2中action得到请求参数，也可以直接封装到javaBean
		struts2 内部提供大量类型转换器，用来完成数据类型转换问题 
		boolean 和 Boolean
		char和 Character
		int 和 Integer
		long 和 Long
		float 和 Float
		double 和 Double
		Date 可以接收 yyyy-MM-dd格式字符串
		数组  可以将多个同名参数，转换到数组中
		集合  支持将数据保存到 List 或者 Map 集合
		
		例如:日期类型，我们传递  yyyy-MM-dd  yyyy年MM月dd日格式都可以，但是如果是yyyy/MM/dd
			就会出现问题.
		关于struts2中的类型转换器:
			struts2中的类型转换器根接口是：com.opensymphony.xwork2.conversion.TypeConverter。
-------------------------------------------------------
	自定义类型转换器:
		
		步骤:
			1.创建一个类实现TypeConverter接口.
			2.重写接口中方法，实现类型转换操作.
			3.注册类型转换器.
		详解说明:
			1.创建一个自定义类型转换器
				1.实现TypeConverter需要重写
					public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName, Object value, Class toType);
					如果实现接口，这个方法参数太多(6个)
					
				2.不推荐实现接口，可以继承 DefaultTypeConverter类
					优点:重写的方法参数没有那么多
					@Override
					public Object convertValue(Map<String, Object> context, Object value, Class toType) {
						return super.convertValue(context, value, toType);
					}
				3.继承DefaultTypeConverter类的一个子类，StrutsTypeConverter
					原因：在这个类中将从页面传递的数据怎样封装，以及在action中的数据怎样在页面上显示做类分离
						public abstract Object convertFromString(Map context, String[] values, Class toClass);
						public abstract String convertToString(Map context, Object o);
						
			2.怎样注册一个自定义类型转换器
				1.局部－－－针对action
					配置文件所在位置以及名称:  在Action类所在包 创建 Action类名-conversion.properties , 
					配置文件书写:    格式 ： 属性名称=类型转换器的全类名 
				2.局部－－－针对model
				 	配置文件所在位置以及名称:  在model类所在包 创建 model类名-conversion.properties , 
					配置文件书写:    格式 ： 属性名称=类型转换器的全类名 
				3.全局
					配置文件所在位置以及名称:在src下创建一个xwork-conversion.properties
					配置文件书写:  格式:  要转换的类型全名=类型转换器的全类名 
-----------------------------------------------------------------------------
				注意:
					对于struts2中类型转换器，如果表单数据提交时，将数据向model封装，出现了问题，会报错:
					No result defined for action cn.l.action.RegistAction and result input
					
					上面的意思是说，在RegistAction的配置中没有配置input结果视图.
					<action name="regist" class="cn.l.action.RegistAction">
						<result name="input">/success.jsp</result>
					</action>
					如果配置了，出现类型转换问题，就会跳转到input指定的视图。
				问题:为什么会向input视图跳转?
					是因为struts2中的拦截器(interceptor).
					在struts2中的
						<interceptor name="conversionError" class="org.apache.struts2.interceptor.StrutsConversionErrorInterceptor"/>
					用于记录类型转换问题
					在struts2中
						<interceptor name="workflow" class="com.opensymphony.xwork2.interceptor.DefaultWorkflowInterceptor"/>
					用于得到问题，向input视图跳转。
				关于错误信息展示:
					通过分析拦截器作用，得知当类型转换出错时，自动跳转input视图 ，在input视图页面中 <s:fieldError/> 显示错误信息	
					* 在Action所在包中，创建 ActionName.properties，在局部资源文件中配置提示信息 ： invalid.fieldvalue.属性名= 错误信息
					
					如果是自定义类型转换器，出现类型转换问题，要跳转到input视图，在类型转换器中，必须抛出异常才可以。
-------------------------------------------------------------------------
关于struts2提供的数据校验
		
	在开发中，请求参数是需要校验的。
		客户端校验---->js
		服务器校验---->java代码。
		
	struts2中提供的校验-----服务器端校验。
	
	分成两种:
		1.手动校验(编码校验)
		2.配置校验(annotation,xml) 我们讲的是xml。
		
	1.手动校验:(了解)
		要求:action类必须继承自ActionSupport。需要重写一个方法 validate
		
		通过测试发现在action中重写的validate方法执行了。并且是在请求处理方法(execute)之前执行的。
		
		
		对于struts2提供的校验，它也是通过拦截器实现的。
		
		问题:在validate方法中怎样存储校验错误信息?
		
			在validate方法中   this.addFieldError(Sting name,String value);
			
		问题:在页面上怎样获取错误信息?(在input视图上)
			<s:fielderror> 展示所有错误信息
			
			<s:fielderror fieldName="">展示特定名称的错误信息.
			
		------------------	
		问题:在同一个Action中有多个请求处理方法(login,regist)那么有些方法是需要校验的，有些是不需要的，怎样处理?
			解决方案:创建一个名称叫   validate+请求处理方法名   例如:请求处理方法叫  regist()  校验 的方法名 validateRegist().
			
	-------------------------------------------------------------------------------------------------------------
	2.配置校验(xml)
		struts2的校验框架。
		已经完成了校验操作(做了很多校验方法)。
		而我们在使用时，只需要将它们调用就可以(通过配置文件)
		
		要求:action类必须继承自ActionSupport。
		
		问题:配置文件怎样配置?
			
			位置:xml文件要与action类在同一个包下
			名称:action类名-validation.xml
			约束: xwork-core-2.3.7.jar 中 xwork-validator-1.0.3.dtd 下
				<!DOCTYPE validators PUBLIC
				"-//Apache Struts//XWork Validator 1.0.3//EN"
				"http://struts.apache.org/dtds/xwork-validator-1.0.3.dtd">
			书写：
				1.根元素
					<validators>
				2.子元素
					<field name="属性名称"></field> 	
			
				3.<field>子元素	
					<field-validator type="校验器"> 这个是指定校验器
					问题:校验器有哪些?
						xwork-core-2.3.7.jar 中 /com/opensymphony/xwork2/validator/validators/default.xml下
						
						<validator name="required" class="com.opensymphony.xwork2.validator.validators.RequiredFieldValidator"/>
						<validator name="requiredstring" class="com.opensymphony.xwork2.validator.validators.RequiredStringValidator"/>
						<validator name="int" class="com.opensymphony.xwork2.validator.validators.IntRangeFieldValidator"/>
						<validator name="long" class="com.opensymphony.xwork2.validator.validators.LongRangeFieldValidator"/>
						<validator name="short" class="com.opensymphony.xwork2.validator.validators.ShortRangeFieldValidator"/>
						<validator name="double" class="com.opensymphony.xwork2.validator.validators.DoubleRangeFieldValidator"/>
						<validator name="date" class="com.opensymphony.xwork2.validator.validators.DateRangeFieldValidator"/>
						<validator name="expression" class="com.opensymphony.xwork2.validator.validators.ExpressionValidator"/>
						<validator name="fieldexpression" class="com.opensymphony.xwork2.validator.validators.FieldExpressionValidator"/>
						<validator name="email" class="com.opensymphony.xwork2.validator.validators.EmailValidator"/>
						<validator name="url" class="com.opensymphony.xwork2.validator.validators.URLValidator"/>
						<validator name="visitor" class="com.opensymphony.xwork2.validator.validators.VisitorFieldValidator"/>
						<validator name="conversion" class="com.opensymphony.xwork2.validator.validators.ConversionErrorFieldValidator"/>
						<validator name="stringlength" class="com.opensymphony.xwork2.validator.validators.StringLengthFieldValidator"/>
						<validator name="regex" class="com.opensymphony.xwork2.validator.validators.RegexFieldValidator"/>
						<validator name="conditionalvisitor" class="com.opensymphony.xwork2.validator.validators.ConditionalVisitorFieldValidator"/>
						
				4.<field-validator>子元素  
					<message>错误信息</message>
					
				5.<field-validator>子元素
					<param name="">值</param>
					用于指定校验器中的参数.
		------------------------------------------------------------------------------------------------
		介绍:关于配置校验中的校验器:	
						
			* required (必填校验器,要求被校验的属性值不能为null)
			* requiredstring (必填字符串校验器,要求被校验的属性值不能为null，并且长度大于0,默认情况下会对字符串去前后空格)
			* stringlength (字符串长度校验器，要求被校验的属性值必须在指定的范围内，否则校验失败,minLength参数指定最小长度，maxLength参数指定最大长度，trim参数指定校验field之前是否去除字符串前后的空格)
			* regex (正则表达式校验器，检查被校验的属性值是否匹配一个正则表达式，expression参数指定正则表达式，caseSensitive参数指定进行正则表达式匹配时，是否区分大小写,默认值为true)
			* int(整数校验器，要求field的整数值必须在指定范围内，min指定最小值，max指定最大值)
			* double(双精度浮点数校验器,要求field的双精度浮点数必须在指定范围内,min指定最小值,max指定最大值)
			* fieldexpression (字段OGNL表达式校验器,要求field满足一个ognl表达式，expression参数指定ognl表达式,该逻辑表达式基于ValueStack进行求值,返回true时校验通过，否则不通过)
			* email(邮件地址校验器，要求如果被校验的属性值非空，则必须是合法的邮件地址)
			* url(网址校验器,要求如果被校验的属性值非空,则必须是合法的url地址)
			* date(日期校验器,要求field的日期值必须在指定范围内,min指定最小值,max指定最大值)
			
		-------------------------------------------------------------------------------------------	
		问题:通过配置校验，怎样处理在同一个action中存在多个请求处理方法校验问题?
		
			只需要将校验xml文件名称修改就可以。
			action类名-valication.xml 现在要对action类中某一个方法校验。
			
			action类名-action名称-validation.xml.
				
*/
public class Doc1 {

}
