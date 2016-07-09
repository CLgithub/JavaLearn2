package day74_spirngmvc.demo2.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
拦截器测试：
	<mvc:interceptor>
		<mvc:mapping path="/**"/>
		<bean id="myInterceptor1" class="day74_spirngmvc.demo2.interceptor.MyInterceptor1" />
	</mvc:interceptor>
	<mvc:interceptor>
		<mvc:mapping path="/**"/>
		<bean id="myInterceptor2" class="day74_spirngmvc.demo2.interceptor.MyInterceptor2" />
	</mvc:interceptor>
	
	1和2都放行
		MyInterceptor1.preHandle()
		MyInterceptor2.preHandle()
		handler执行。。
		MyInterceptor2.postHandle()
		MyInterceptor1.postHandle()
		MyInterceptor2.afterCompletion()
		MyInterceptor1.afterCompletion()
	1放行	2拦截
		MyInterceptor1.preHandle()
		MyInterceptor2.preHandle()
		MyInterceptor1.afterCompletion()
	1拦截	2放行
		MyInterceptor1.preHandle()
	
		
	
		
	

*/
public class MyInterceptor1 implements HandlerInterceptor{

	//在执行handler之前执行	可以用于权限校验
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor1.preHandle()");
		return true;
	}

	//在handler返回ModelAndView之前执行	可以向页面统一的视图或公用的信息
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor1.postHandle()");
	}

	//在执行handler之后执行	系统统一异常处理也可以在这做，还可以做方法性能监控，还可以实现系统统一日志
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor1.afterCompletion()");
	}

}
