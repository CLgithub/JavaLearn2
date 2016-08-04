package day21;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*

filter创建
	1.创建一个类，实现 javax.servlet.Filter接口
	2.重写接口中的方法
	3.在web.xml文件中配置
*/
public class Demo1Filter1 implements Filter{

	@Override
	public void destroy() {
		System.out.println("filter销毁");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fChain)
			throws IOException, ServletException {
		System.out.println("filter进行过滤操作");
		//放行
		fChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter初始化");
	}

}
