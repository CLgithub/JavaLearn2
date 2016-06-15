package day21;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager.NameMap;

public class Demo3Filter1 implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
		//直接设置，解决编码问题
//		req.setCharacterEncoding("utf-8");

		//通过增强request解决编码问题
		HttpServletRequest myRequest=new MyRequest(req);	//增强后的request
		
		
//		HttpServletRequest myRequest=(HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(),
//				new InvocationHandler() {
//					@Override
//					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//						if("setCharacterEncoding".equals(method.getName())){
//							System.out.println("Demo3Filter1.doFilter(...).new InvocationHandler() {...}.invoke()");
//							method.invoke(req, "utf-8");
//							return null;
//						}else {
//							return method.invoke(req, args);
//						}
//					}
//				}
//		);
//		
		filterChain.doFilter(myRequest, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

class MyRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	//重写关于获得请求参数的方法
	
	@Override
	public String getParameter(String name) {
		Map<String, String[]> map=this.getParameterMap();
		if(name==null){
			return null;
		}
		String[] st=map.get(name);
		if(st==null||st.length==0){
			return null;
		}
		return st[0];
	}
	
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map=this.getParameterMap();
		if(name==null){
			return null;
		}
		String[] st=map.get(name);
		return st;
	}
	
	
	private boolean filg=true;	//最后servlet中获得的request是同一个，获取第一个参数是就调用一遍这方法，
		//获取第二个参数的时候又调用这个方法，此时或的得的map = request.getParameterMap();是不乱的，
		//第二次就把不乱的转成乱的，所有做个开关，确保只转一次
	@Override
	public Map<String, String[]> getParameterMap() {
		//得到所有请求参数的map集合
		Map<String, String[]> map = request.getParameterMap();
		if(filg){
			//解决编码问题		变量map集合，entrySet或keySet
//			Set<Entry<String,String[]>> entrySet = map.entrySet();
			Set<String> keySet = map.keySet();
			for(String key:keySet){
				String[] values = map.get(key);
				for(int i=0;i<values.length;i++){
					try {
						values[i]=new String(values[i].getBytes("iso8859-1"), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		filg=false;
		return map;
	}
	
}