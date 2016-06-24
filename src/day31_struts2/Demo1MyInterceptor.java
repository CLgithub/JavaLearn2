package day31_struts2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Demo1MyInterceptor implements Interceptor{

	//初始化
	@Override
	public void init() {
		System.out.println("自定义拦截器1初始化");
	}

	//拦截
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("自定义拦截器拦截");
		
		//放行
		String invoke = invocation.invoke();//invoke里执行的就是动态代理
		return null;
	}

	//销毁
	@Override
	public void destroy() {
		System.out.println("自定义拦截器1销毁");
	}
}
