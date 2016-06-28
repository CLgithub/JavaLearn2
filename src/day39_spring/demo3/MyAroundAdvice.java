package day39_spring.demo3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/*
 * 
 */
public class MyAroundAdvice implements MethodInterceptor{

	//可以控制之前或之后，有点像拦截器
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("环绕前增强");
		Object object = methodInvocation.proceed();	//执行目标对象的方法
		System.out.println("环绕后增强");
		return object;
	}


}
