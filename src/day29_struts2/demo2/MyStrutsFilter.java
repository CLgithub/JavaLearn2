package day29_struts2.demo2;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class MyStrutsFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fChain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		try {
			//1.得到请求路径
			String uri = request.getRequestURI();
			String contextPath = request.getContextPath();
			String path = uri.substring(contextPath.length()+1);
			
//			System.out.println(path);	//struts2Demo2
			//2.使用path去struts.xml中去查找path的action
			SAXReader saxReader=new SAXReader();
			
			Document document = saxReader.read(this.getClass().getResourceAsStream("/struts.xml"));
			Element acitonE = (Element) document.selectSingleNode("//action[@name='"+path+"']");	//查找文件中name为path的的action标签
			if(acitonE!=null){
				//得到action标签上的class属性以及method属性
				String className = acitonE.attributeValue("class");
				String methodName = acitonE.attributeValue("method");
				//通过反射得到action类对象，调用其对应方法
				Class<?> clazz = Class.forName(className);
				Object object = clazz.newInstance();
				Method method = clazz.getMethod(methodName);
				//执行方法得到返回值
				String ret = (String) method.invoke(object);
//				System.out.println("方法返回值："+ret);
				//通过返回值得到要跳转的目标页面
				Element resultE = (Element) acitonE.selectSingleNode("//result[@name='"+ret+"']");
				String skipPage = resultE.getText();
//				System.out.println("目标页面"+rePage);
				//转发到目标页面
				request.getRequestDispatcher(skipPage).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
