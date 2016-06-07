package day19.exercise.controller;

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
import day19.exercise.base.BaseController;
import day19.exercise.entity.Contact19;
import day19.exercise.service.ContactService;
import day19.exercise.service.ContactServiceImpl;

public class ContactMain extends BaseController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		ContactService contactService = new ContactServiceImpl();
		String mark = req.getParameter("mark");
		if ("toAddOrU".equals(mark)) {// 到达新增或修改页面
			Contact19 contact = null;
			String id = req.getParameter("id");
			if (null != id) {
				contact = contactService.findCById(Integer.valueOf(id));
			}
			req.setAttribute("contact", contact);
			req.getRequestDispatcher("/page/day19/exercise/addorUpdateC.jsp").forward(req, resp);
		} else if ("doAddOrU".equals(mark)) { // 新增或修改
			// 用BeanUtils封装
			Contact19 contact = this.copyToBean2(req, Contact19.class);
			contactService.addOrUpdateC(contact);
			resp.sendRedirect(req.getContextPath() + "/ContactMain3");
		} else if ("delete".equals(mark)) { // 删除
			String id = req.getParameter("id");
			contactService.deleteC(id);
			resp.sendRedirect(req.getContextPath() + "/ContactMain3");
		} else { // 查询所用
			List<Contact19> list = contactService.findAllC();
			// 存储数据到域对象
			req.setAttribute("list", list);
			// 跳转到目标页面
			req.getRequestDispatcher("/page/day19/exercise/contactList.jsp").forward(req, resp);
		}

	}

}
