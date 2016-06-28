package day39_spring.demo5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

/*

AspectJ增强类型
	@Before 前置通知，相当于BeforeAdvice
		前置通知无法阻止方法执行
	@AfterReturning 后置通知，相当于AfterReturningAdvice
		后置通知可以获得方法的返回值
	@Around 环绕通知，相当于MethodInterceptor
		可以在方法执行之前和执行之后来执行，而且可以阻止方法的执行
	@AfterThrowing抛出通知，相当于ThrowAdvice
	@After 最终final通知，不管是否异常，该通知都会执行
	@DeclareParents 引介通知，相当于IntroductionInterceptor (不要求掌握)

*/

/*
 * 自定义切面类，切面＝切点＋通知（增强）
 */
@Aspect		//用这个标签来定义切面
public class MyAspect {
	
	//前置增强
	//用Aspect表达式来定义为哪些类哪些方法来添加这个增强（通知）
	//匹配day39_spring.demo5.service包下的任意类名的任意以Service结尾的类的add方法
	@Before("execution(* day39_spring.demo5.service.*Service.update(..))")
//	@Before(value="execution(* *..*Service.update*(..)")
	public void myBefore(JoinPoint joinPoint) {	
		System.out.println("前置增强,可以用于增强的点："+joinPoint);
	}
	
	//后置增强
	@AfterReturning(value="execution(* day39_spring.demo5.service.*Service.add(..))",returning="returnVal")
	public void myAfterReturning(Object returnVal){		//定义一个对象来接收方法的返回值
		System.out.println("后置增强,方法返回值："+returnVal);
	}
	
	//环绕增强
	@Around(value="execution(* day39_spring.demo5.service.*Service.query(..))")
	public Object myAround(ProceedingJoinPoint pJoinPoint) throws Throwable{
		System.out.println("环绕前增强");
		Object object = pJoinPoint.proceed();		//代表方法执行
		System.out.println("环绕后增强");
		return object;
	}
	
	//抛出异常增强
	@AfterThrowing(value="execution(* day39_spring.demo5.service.*Service.query(..))",throwing="e")
	public void myAfterThrowing(Throwable e){	//定义一个异常来接收出现的异常
		System.out.println("出异常了，异常信息："+e.getMessage());
	}
	
	//最终增强
	@After(value="execution(* day39_spring.demo5.service.*Service.query(..))")
	public void myDeclareParents(){
		System.out.println("最终增强");
	}
}
