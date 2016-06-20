package day19_2.exercise.base;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import day19_2.exercise.entity.Contact19_2;
import day19_2.exercise.entity.Users;

public class BaseController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	/**
	 * 将请求对象封装到指定的类型中，并返回封装好的对象
	 * @deprecated 还有跟简单的copyToBean2()
	 * @author L
	 * @date 2016年6月5日
	 * @param req
	 * @param object
	 * @return 
	 */
	@Deprecated
	public static <T>T copyToBean(HttpServletRequest req,Class<T> clazz) {
		registerDateU(); //注册日期转换器工具类
		try {
			T t = clazz.newInstance();
			Enumeration<String> parameterNames = req.getParameterNames();	//获取所有参数名称列表，详情见day9_http.Demo2
			while(parameterNames.hasMoreElements()){
				String eName = parameterNames.nextElement();
				String parameter = req.getParameter(eName);
				if(clazz==Contact19_2.class){	//如果是封装Contact17，要特殊处理age
					if(eName.equals("age")){
						if(req.getParameter("age").equals("")){
							((Contact19_2)t).setAge(null);
							continue;
						}
					}
				}
				BeanUtils.setProperty(t, eName, parameter);
			}
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将请求对象封装到指定的类型中，并返回封装好的对象
	 * @author L
	 * @date 2016年6月5日
	 * @param req
	 * @param object
	 * @return 
	 */
	public static <T>T copyToBean2(HttpServletRequest req,Class<T> clazz) {
		registerDateU(); //注册日期转换器工具类
		try {
			T t=clazz.newInstance();
			BeanUtils.populate(t, req.getParameterMap());	//getParameterMap以map形式防护得到请求参数
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void registerDateU() {
		ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class type, Object value) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				try {
					return 	sdf.parse(value.toString());
				} catch (ParseException e) {
					new RuntimeException(e);
					return null;
				}
			}
		},Date.class);
	}
	
}
