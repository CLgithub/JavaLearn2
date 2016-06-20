package day24_proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StudenProxyTest {
	public static void main(String[] args) {
		//做person接口实现类student的动态代理
		
		//1.创建一个被代理
		Student student=new Student();
		//2.得到person的代理对象
		Person person=(Person) Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//proxy：代理对象，一般不使用
						//method：被访问的方法
						//args：被访问的方法的参数
						return method.invoke(student, args);
					}
				});
		
		String say = person.say("你好");
		System.out.println(say);
	}
}
