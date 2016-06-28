package day39_spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
spring中的aop
	aop之前在day19_2.exercise有用，得到的对象其实是个代理对象，在真正做事之前可以添加其他功能，
		spring管理bean后,传过来的对象就是一个代理对象，day38_spring.demo4.MyBeanPostProcessor中就是横切面
	Spring的AOP代理:
		JDK动态代理:对实现了接口的类生成代理
			可以查看day19_2.exercise
		CGLib代理机制:对类生成代理
			CGLIB(Code Generation Library)是一个开源项目！是一个强大的，高性能，
			高质量的Code生成类库，它可以在运行期扩展Java类与实现Java接口。 
			Hibernate支持它来实现PO(Persistent Object 持久化对象)字节码的动态生成
				Hibernate生成持久化类的javassist.
				CGLIB生成代理机制:其实生成了一个真实对象的子类.
*/
public class SpringTest1 {
	@Test
	public void test1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_day39_1.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.add();
		userDao.update();
	}
}
