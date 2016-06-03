package day17.exercise.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
			Contact17 contact = new Contact17();
			String id=req.getParameter("id");
			if(!id.equals("")){
				contact.setId(Integer.valueOf(id));
			}
			contact.setName(req.getParameter("name"));
			contact.setAge(req.getParameter("age"));
			contact.setPhone(req.getParameter("phone"));
			contact.setEmail(req.getParameter("email"));
			contact.setQq(req.getParameter("qq"));
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
	
}
