package day39_spring.demo2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
Spring的传统AOP :
	AOP:不是由Spring定义.AOP联盟的组织定义.
	Spring中的通知:(增强代码)
	前置通知 org.springframework.aop.MethodBeforeAdvice
	* 在目标方法执行前实施增强
	后置通知 org.springframework.aop.AfterReturningAdvice
	* 在目标方法执行后实施增强
	环绕通知 org.aopalliance.intercept.MethodInterceptor
	* 在目标方法执行前后实施增强
	异常抛出通知 org.springframework.aop.ThrowsAdvice
	* 在方法抛出异常后实施增强
	引介通知 org.springframework.aop.IntroductionInterceptor(课程不讲.)
	* 在目标类中添加一些新的方法和属性

Spring中的切面类型:
	Advisor : Spring中传统切面.
	* Advisor:都是有一个切点和一个通知组合.
	* Aspect:多个切点和多个通知组合.
	
	Advisor : 代表一般切面，Advice本身就是一个切面，对目标类所有方法进行拦截(* 不带有切点的切面.针对所有方法进行拦截)
		事务就应该用这种切面
	PointcutAdvisor : 代表具有切点的切面，可以指定拦截目标类哪些方法(带有切点的切面,针对某个方法进行拦截)
		日志应该用这种切面
	IntroductionAdvisor : 代表引介切面，针对引介通知而使用切面（不要求掌握）

Spring的AOP的开发:
	针对所有方法进行增强(不带切点的切面)
	第一步:导入相应jar包.
		spring-aop-3.2.0.RELEASE.jar
		com.springsource.org.aopalliance-1.0.0.jar
	第二步骤：编写被代理的对象
		CustomeService
		CustomerServiceImpl
	第三步：增强
		MyBeoreAdvice
	第四步：生成代理
		生成代理Spring基于ProxyFactoryBean类.底层自动选择使用JDK的动态代理还是CGLIB的代理.
		属性:
			target : 代理的目标对象
			proxyInterfaces : 代理要实现的接口
			如果多个接口可以使用以下格式赋值
			<list>
			    <value></value>
			    ....
			</list>
			proxyTargetClass : 是否对类代理而不是接口，设置为true时，使用CGLib代理
			interceptorNames : 需要织入目标的Advice
			singleton : 返回代理是否为单实例，默认为单例
			optimize : 当设置为true时，强制使用CGLib



*/
public class SpringTest2 {
	
	private static ApplicationContext applicationContext;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext=new ClassPathXmlApplicationContext("applicationContext_day39_1.xml");
	}
	
	@Test
	public void test1(){
//		CustomeService customeService = (CustomeService) applicationContext.getBean("customerService");
//		customeService.add();
		CustomeService customeService = (CustomeService) applicationContext.getBean("customerDaoProxy");
		customeService.add();
	}
}
