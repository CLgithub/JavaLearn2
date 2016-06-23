package day30_struts2;

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
					
		2.模型驱动（在开发中应用比较多）
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


*/
public class Doc1 {

}
