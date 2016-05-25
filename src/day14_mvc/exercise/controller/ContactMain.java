package day14_mvc.exercise.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import day14_mvc.exercise.entity.ContactMvc;
import day14_mvc.exercise.service.ContactService;
import day14_mvc.exercise.service.ContactServiceImpi;
public class ContactMain extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		ContactService contactService=new ContactServiceImpi();
		String mark=req.getParameter("mark");
		if("toAddOrU".equals(mark)){//到达新增或修改页面
			ContactMvc contact=null;
			String id = req.getParameter("id");
			if(null!=id){
				contact = contactService.findById(id);
			}
			req.setAttribute("contact", contact);
			req.getRequestDispatcher("/page/day14_mvc/exercise/addorUpdateC.jsp").forward(req, resp);
		}else if("doAddOrU".equals(mark)){	//新增或修改
			ContactMvc contact = new ContactMvc();
			contact.setId(req.getParameter("id"));
			contact.setName(req.getParameter("name"));
			contact.setAge(req.getParameter("age"));
			contact.setPhone(req.getParameter("phone"));
			contact.setEmail(req.getParameter("email"));
			contact.setQq(req.getParameter("qq"));
			contactService.addOrUpdate(contact);
			resp.sendRedirect(req.getContextPath()+"/ContactMain");
		}else if("delete".equals(mark)){	//删除
			String id = req.getParameter("id");
			contactService.deleteC(id);
			resp.sendRedirect(req.getContextPath()+"/ContactMain");
		}else {	//查询所用
			List<ContactMvc> list =contactService.findAll();
			//存储数据到域对象
			req.setAttribute("list", list);
			//跳转到目标页面
			req.getRequestDispatcher("/page/day14_mvc/exercise/contactList.jsp").forward(req, resp);
		}
		
	}
	
}
