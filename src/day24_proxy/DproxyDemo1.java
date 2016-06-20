package day24_proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import day24_proxy.demo1.KindMan;
import day24_proxy.demo1.KindWoman;
import day24_proxy.demo1.Pjl;
import day24_proxy.demo1.Wp;

//动态代理
public class DproxyDemo1 {
	public static void main(String[] args) {
		KindWoman woman=new Pjl();
		KindMan kindMan=new Cgx();
		
		//做一个pjl的代理
//		Wp wp=new Wp(woman);	//以前的代理
		
		//动态代理
		KindWoman pWoman = (KindWoman) Proxy.newProxyInstance(woman.getClass().getClassLoader(), woman.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						return method.invoke(woman, args);
					}
				});
		//动态代理
		KindMan pMan = (KindMan) Proxy.newProxyInstance(kindMan.getClass().getClassLoader(), kindMan.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						return method.invoke(kindMan, args);
					}
				});
		
		pWoman.throwEye();
		pMan.pz();
	}
}
