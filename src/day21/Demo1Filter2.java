package day21;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo1Filter2 implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("放行");
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//1.获取fiter名称
		System.out.println("filter名称："+filterConfig.getFilterName());
		//2.获取初始化配置参数
		Enumeration<String> parameterNames = filterConfig.getInitParameterNames();
		while(parameterNames.hasMoreElements()){
			String name = parameterNames.nextElement();
			System.out.println("filter初始化配置参数："
					+name+"="+filterConfig.getInitParameter(name));
		}
		//3.获取servletContext对象
		ServletContext servletContext = filterConfig.getServletContext();
	}

}
