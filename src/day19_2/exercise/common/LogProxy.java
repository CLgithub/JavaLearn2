package day19_2.exercise.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import day19_2.exercise.controller.LogAnnotation;
import day19_2.exercise.service.ContactService;
import day19_2.exercise.service.ContactServiceImpl;

public class LogProxy {
	private static ContactService service = new ContactServiceImpl();

	public static ContactService getInstance(){
		ContactService proxyS=(ContactService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(),
				new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(method.isAnnotationPresent(LogAnnotation.class)){
					System.out.println("日志记录："+method.getName());
				}
				return method.invoke(service, args);
			}
		});
		return proxyS;
	}
}
