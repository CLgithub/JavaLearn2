package day39_spring.demo5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 自定义切面类，切面＝切点＋通知（增强）
 * 
 */
@Aspect		//用这个标签来定义切面
public class MyAspect {
	//用Aspect表达式来定义为哪些类哪些方法来添加这个增强（通知）
	//匹配day39_spring.demo5.service包下的任意类名的任意以Service结尾的类的add方法
	@Before("execution(* day39_spring.demo5.service.*Service.update(..))")
//	@Before(value="execution(* *..*Service.update*(..)")
	public void myBefore() {
		System.out.println("前置增强");
	}
}
