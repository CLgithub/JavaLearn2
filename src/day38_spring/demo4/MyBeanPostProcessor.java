package day38_spring.demo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.mchange.v2.c3p0.impl.NewProxyConnection;

public class MyBeanPostProcessor implements BeanPostProcessor{

	/**
	 * bean：实例对象
	 * beanName：在配置文件中配置的类的标识
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第五步：在类初始化之前执行");
		//可以在这里面增强bean
		return bean;
	}
	
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第八步：在初始化后执行");
		//可以用动态代理增强bean
		Proxy proxy=(Proxy) Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(method.getName().equals("add")){
					System.out.println("记录日志");
				}
				return method.invoke(bean,args);
			}
		});
		return proxy;
	}

	


}
