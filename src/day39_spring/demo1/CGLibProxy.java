package day39_spring.demo1;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibProxy  implements MethodInterceptor{
	private Object bean;

	public CGLibProxy(Object bean2) {
		this.bean = bean2;
	}

	public Object createProxy() {
		//使用cglib生产代理
		//创建核心类
		Enhancer enhancer=new Enhancer();
		//w为其设置父类
		enhancer.setSuperclass(bean.getClass());
		//设置回调
		enhancer.setCallback(this);
		//创建代理
		return enhancer.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if("add".equals(method.getName())){
			System.out.println("记录日志");
		}
		return method.invoke(bean, args);
//		return methodProxy.invokeSuper(proxy, args);
		
	}
	
}
