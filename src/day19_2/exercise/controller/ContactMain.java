package day19_2.exercise.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day19_2.exercise.base.BaseController;
import day19_2.exercise.entity.Contact19_2;
import day19_2.exercise.entity.Users;
import day19_2.exercise.service.ContactService;
import day19_2.exercise.service.ContactServiceImpl;

public class ContactMain extends BaseController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		Users user= (Users) req.getSession().getAttribute("user");
		if(user==null){
			req.setAttribute("msg", "请重新登录");
			req.getRequestDispatcher("/page/day19_2/exercise/login.jsp").forward(req, resp);
		}else {
			ContactService contactService = new ContactServiceImpl();
			String mark = req.getParameter("mark");
			if ("toAddOrU".equals(mark)) {// 到达新增或修改页面
				Contact19_2 contact = null;
				String id = req.getParameter("id");
				if (null != id) {
					contact = contactService.findCById(Integer.valueOf(id));
				}
				req.setAttribute("contact", contact);
				req.getRequestDispatcher("/page/day19_2/exercise/addorUpdateC.jsp").forward(req, resp);
			} else if ("doAddOrU".equals(mark)) { // 新增或修改
				// 用BeanUtils封装
				Contact19_2 contact = this.copyToBean2(req, Contact19_2.class);
				contactService.addOrUpdateC(contact);
				resp.sendRedirect(req.getContextPath() + "/ContactMain4");
			} else if ("delete".equals(mark)) { // 删除
				String id = req.getParameter("id");
				contactService.deleteC(id);
				resp.sendRedirect(req.getContextPath() + "/ContactMain4");
			} else { // 查询所用
				List<Contact19_2> list = contactService.findAllC();
				// 存储数据到域对象
				req.setAttribute("list", list);
				// 跳转到目标页面
				req.getRequestDispatcher("/page/day19_2/exercise/contactList.jsp").forward(req, resp);
			}
		}
	}
	
	

}
