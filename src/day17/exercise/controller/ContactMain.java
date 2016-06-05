package day17.exercise.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import day17.exercise.entity.Contact17;
import day17.exercise.service.ContactService;
import day17.exercise.service.ContactServiceImpl;

public class ContactMain extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		ContactService contactService=new ContactServiceImpl();
		String mark=req.getParameter("mark");
		if("toAddOrU".equals(mark)){//到达新增或修改页面
			Contact17 contact=null;
			String id = req.getParameter("id");
			if(null!=id){
				contact = contactService.findById(id);
			}
			req.setAttribute("contact", contact);
			req.getRequestDispatcher("/page/day17/exercise/addorUpdateC.jsp").forward(req, resp);
		}else if("doAddOrU".equals(mark)){	//新增或修改
//			Contact17 contact = new Contact17();
			//使用getParameter得到表单提交数据，封装到对象
//			String id=req.getParameter("id");
//			if(!id.equals("")){
//				contact.setId(Integer.valueOf(id));
//			}
//			contact.setName(req.getParameter("name"));
//			String age = req.getParameter("age");
//			if(age.equals("")){
//				contact.setAge(null);
//			}
//			contact.setPhone(req.getParameter("phone"));
//			contact.setEmail(req.getParameter("email"));
//			contact.setQq(req.getParameter("qq"));
			
			//用BeanUtils封装
			Contact17 contact=ContactMain.copyToBean2(req,Contact17.class);
			
			
			contactService.addOrUpdate(contact);
			resp.sendRedirect(req.getContextPath()+"/ContactMain2");
		}else if("delete".equals(mark)){	//删除
			String id = req.getParameter("id");
			contactService.deleteC(id);
			resp.sendRedirect(req.getContextPath()+"/ContactMain2");
		}else {	//查询所用
			List<Contact17> list =contactService.findAll();
			//存储数据到域对象
			req.setAttribute("list", list);
			//跳转到目标页面
			req.getRequestDispatcher("/page/day17/exercise/contactList.jsp").forward(req, resp);
		}
		
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
	private static <T>T copyToBean(HttpServletRequest req,Class<T> clazz) {
		registerDateU(); //注册日期转换器工具类
		try {
			T t = clazz.newInstance();
			Enumeration<String> parameterNames = req.getParameterNames();	//获取所有参数名称列表，详情见day9_http.Demo2
			while(parameterNames.hasMoreElements()){
				String eName = parameterNames.nextElement();
				String parameter = req.getParameter(eName);
				if(clazz==Contact17.class){	//如果是封装Contact17，要特殊处理age
					if(eName.equals("age")){
						if(req.getParameter("age").equals("")){
							((Contact17)t).setAge(null);
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
	private static <T>T copyToBean2(HttpServletRequest req,Class<T> clazz) {
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
