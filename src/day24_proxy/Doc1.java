package day24_proxy;

import java.lang.reflect.Method;

/*
3.动态代理
	1.代理模式(demo1)
		代理模式的作用
			屏蔽真实行为的访问，让程序更加安全
			可以让真实行为的调用进行控制
		通过一个案例：来说明代理的实现与代理的作用
		
			代理模式实现：
				1.代理类与被代理类要实现同一个接口
				2.在代理类中持有被代理对象
				3.代理类调用对于的被代理类的方法
		代理和装饰：
			代理是直接调用被代理类的方法，而装饰是调用被装饰方法前先对其增强
			
		AOP：面向切面的编程
			AOP的底层实现就通过动态代理来实现的
	2.动态代理(demo1)
		他就是在代理模式基础上发展的，他不再是对单一的类型进行代理，而是
		可以对任意的一个实现了接口的类的对象做代理
	3.动态代理实现
		有两种方式
			1.通过jdk中提供的Proxy类来实现
				这种方式要求，被代理类必须实现接口
				简单说，proxy只能为接口做代理
			2.通过cglib来实现
				他不要求被代理类实现接口
				
		代码实现：
			Proxy类中有一个方法newProxyInstance(ClassLoader loader,Class[] interfaces,
				InvocationHandler h);
			参数：
				loader
					要求传递的是被代理类的类加载器ClassLoader
					类加载器怎样获取
						得到其Class对象，用Class对象的getClassLoader()方法得到、
				interfaces
					要求得到被代理对象所实现的接口的所有Class对象
					怎样获取所有实现接口的Class对象？
						得到其Class对象，用Class对象的getInterfaces()方法得到
				h
					他的类型是InvocationHandler接口类型
					InvocationHandler 是代理实例的调用处理程序 实现的接口
					这个接口里有一个方法public Object invoke(Object proxy, Method method, Object[] args)
					通过这个方法就可以控制真实行为的访问，（反射来实现）
				
				InvocationHandler接口中有一个方法invoke;
					public Object invoke(Object proxy, Method method, Object[] args)
					proxy：代理对象，一般不使用
					method：被代理的方法
					args：被代理的方法的参数列表
					
---------------------------------------------------------------------
	动态代理案例1----实现编码过滤
		
				
*/
public class Doc1 {

}
