package day74_spirngmvc.demo2.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor2 implements HandlerInterceptor{

	//在执行handler之前执行	可以用于权限校验
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor2.preHandle()");
		return true;
	}

	//在handler返回ModelAndView之前执行	可以向页面统一的视图或公用的信息
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor2.postHandle()");
	}

	//在执行handler之后执行	系统统一异常处理也可以在这做，还可以做方法性能监控，还可以实现系统统一日志
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor2.afterCompletion()");
	}

}
