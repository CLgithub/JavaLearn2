package day31_struts2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.DefaultActionInvocation;
import com.opensymphony.xwork2.config.entities.InterceptorMapping;
import com.opensymphony.xwork2.util.profiling.UtilTimerStack;

/*
拦截器interceptor
	介绍拦截器：
		struts2拦截器使用的AOP的思想
			AOP的底层实现是动态代理
			拦截器 采用 责任链 模式 
			在责任链模式里,很多对象由每一个对象对其下家的引用而连接起来形成一条链。
		struts2中在struts-default中声明了所有拦截器
		而struts2框架默认使用了default着个拦截器栈
		在这个拦截器栈中使用了18个拦截器，简单说，struts2在默认情况下加载了18个拦截器

	1.struts2中怎样使用拦截器
		问题：使用拦截器可以做什么？
			权限控制，
		怎样使用拦截器？
			1.定义一个类，实现com.opensymphony.xwork2.interceptor.Interceptor接口
				这个接口中有三个方法
					String intercept(ActionInvocation invocation) throws Exception 是真正的拦截方法
					在这方法中调用invocation.invoke();方法放行
			2.声明一个拦截器
				在struts-default.xml文件中
				<interceptors>
					<interceptor name="" class=""/>
				</interceptors>
				注意:我们要自己声明一个interceptor可以在struts.xml文件中声明。
			3.在action中，指定使用哪些拦截
				<!-- 这个action使用Demo1MyInterceptor拦截器 -->
				<interceptor-ref name="Demo1MyInterceptor" />
			注意：只要显示声明了一个拦截器，该包下继承的默认的拦截器就不再加载
	2.分析拦截器原理
		源代码执行流程：
			1.在StrutsPrepareAndExecuteFilter中查找
				在doFilter方法内有一句话 execute.executeAction (request, response, mapping) 执行Action操作.
			2.在executeAction执行过程中会访问Dispatcher类中的serviceAction，在这个方法中会创建一个
				ActionProxy proxy = config.getContainer().getInstance(ActionProxyFactory.class).createActionProxy(namespace, name, method, extraContext, true, false);
				这就是我们的Action的代理对象
				结合图来看，得到了代理对象，还差ActionInvocation对象
			3.查看ActionInvocation，查看其实现类 DefaultActionInvocation.(Invocation调用)
				这里的ActionInvocation就相当于动态代理时实现的那个匿名内部类(InvocationHandler)，
				在这个类的invoke方法中就可以控制是否访问真正的资源和访问资源后要做什么
				invoke方法中
					if (interceptors.hasNext()) {//判断是否有下一个拦截器
		                final InterceptorMapping interceptor = interceptors.next();//得到一个拦截器
		                String interceptorMsg = "interceptor: " + interceptor.getName();
		                UtilTimerStack.push(interceptorMsg);
		                try {
		                	//调用得到的拦截器的拦截方法intercept.将本类对象传递到了拦截器中。形成链，结合图“拦截器底层原理-拦截器链.png”来看
		                    resultCode = interceptor.getInterceptor().intercept(DefaultActionInvocation.this);
		                            }
		                finally {
		                    UtilTimerStack.pop(interceptorMsg);
		                }
		            }else {
		                resultCode = invokeActionOnly();
		            }
				通过源代码分析，发现在DefaultActionInvocation中就是通过递归完成所有的拦截调用操作.
				递归结束条件：没有下一个拦截器，得到结果视图invokeActionOnly
				
	3.案例
	
--------------------------------------------------------------
拦截器interceptor和过滤器filter的区别
	1.拦截器interceptor基于java反射机制，过滤器filter基于函数回调
	2.拦截器interceptor不依赖依赖servlet容器（是一种思想，不一定在web应用中用），过滤器filter依赖于servlet容器
	3.拦截器interceptor只能对action起作用，过滤器filter几乎可以对所有请求起作用。
	4.拦截器interceptor可以访问action上下文、值栈里的对象，而过滤器filter不行
	5.在action生命周期中，拦截器interceptor可以多次调用，而过滤器只能在容器初始化时被调用一次。


*/
public class Doc1 {

}
