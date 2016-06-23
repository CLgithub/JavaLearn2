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


*/
public class Doc1 {

}
