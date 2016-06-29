package day39_spring.demo6;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;


/*
 * 自定义通知（增强Advice）类
 */
public class MyAspectXML {
	
	//自定义一个前置增强
	public void myBefore() {
		System.out.println("---xml前置增强");
	}
	
	//自定义一个后缀增强
	public void myAfterReturing(Object myReturnVal) {
		System.out.println("---xml后缀增强,返回值："+myReturnVal);
	}
	
	//自定义一个增强
	public Object myAround(ProceedingJoinPoint pJoinPoint) throws Throwable {
		System.out.println("---xml环绕增强前");
		Object object = pJoinPoint.proceed();
		System.out.println("---xml环绕增强前");
		return object;
	}
	
	//自定义一个增强
	public void myafterThrowing(Throwable e){
		System.out.println("---xml异常通知,异常信息："+e.getMessage());
	}
	
	//自定义一个增强
	public void myafter(){
		System.out.println("---xml增强");
	}
}
