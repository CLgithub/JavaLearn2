package day39_spring.demo5;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day39_spring.demo5.service.UserService;

/*

Spring的AspectJ的AOP
	AspectJ是一个面向切面的框架，它扩展了Java语言。
	AspectJ是一个基于Java语言的AOP框架
	Spring2.0以后新增了对AspectJ切点表达式支持
	@AspectJ 是AspectJ1.5新增功能，通过JDK5注解技术，允许直接在Bean类中定义切面
	新版本Spring框架，建议使用AspectJ方式来开发AOP
	
AspectJ表达式:
	语法:execution(表达式)
	execution(<访问修饰符>?<返回类型><方法名>(<参数>)<异常>)
	execution(public * *(..))						//匹配任意返回类型任意包任意类任意名的public方法，任意返回类型，方法参数类型任意，个数任意
	execution(* day39_spring.demo5.*(..))			//匹配day39_spring.demo5包下的任意类的任意方法，任意返回类型，方法参数类型任意，个数任意
	execution(* day39_spring.demo5..*(..))			//匹配day39_spring.demo5包及其子包内的任意类的任意方法，任意返回类型，方法参数类型任意，个数任意
	execution(* day39_spring.demo5.userDao+.*(..))	//匹配day39_spring.demo5包下userDao类及其子类的任意方法
	execution(* *..*Service.save*(..))				//匹配任意包及其子包任意类名以Service结尾的类的任意以save开头的方法，任意返回类型，方法参数类型任意，个数任意
	
	execution(修饰符|方法返回类型|包名|类名|方法名(参数))		
	//修饰符			*任意 	可以省略
	//返回类型		*任意返回类型
	//包				*任意包名		.当前包下		..当前包及其子包
	//方法			*任意方法名
	//参数			..参数类型任意，个数任意
	 
	  
AspectJ增强类型
	@Before 前置通知，相当于BeforeAdvice
	@AfterReturning 后置通知，相当于AfterReturningAdvice
	@Around 环绕通知，相当于MethodInterceptor
	@AfterThrowing抛出通知，相当于ThrowAdvice
	@After 最终final通知，不管是否异常，该通知都会执行
	@DeclareParents 引介通知，相当于IntroductionInterceptor (不要求掌握)
	
基于注解开发AspectJ的AOP
	步骤：
		1.引入jar包
			依赖aop环境，aspectjweaver-1.8.7.jar
		2.编写被增强的类
		3.使用AspectJ注解形式：
			编写day39_spring.demo5.MyAspect
		4.配置
			在application.xml文件中引入aop约束
			<!-- 配置自动生成代理 底层是AnnotationAwareAspectJAutoProxyCreator-->
			<aop:aspectj-autoproxy />
			<!-- 定义切面 -->
			<bean id="myAspect" class="day39_spring.demo5.MyAspect" />
		
		
*/
public class SpringTest5 {
	private static ApplicationContext applicationContext;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("applicationContext_day39_3.xml");
	}
	
	@Test
	public void test1() {
		UserService userService=(UserService) applicationContext.getBean("userService");
//		userService.add();
//		userService.update();
		userService.delete();
//		userService.query();
	}
}
