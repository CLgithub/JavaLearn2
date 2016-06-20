package day19_2.exercise.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day19_2.exercise.base.BaseController;
import day19_2.exercise.common.LogProxy;
import day19_2.exercise.common.PageBean;
import day19_2.exercise.entity.Contact19_2;
import day19_2.exercise.entity.Users;
import day19_2.exercise.service.ContactService;
import day19_2.exercise.service.ContactServiceImpl;

public class ContactMain extends BaseController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Users user= (Users) req.getSession().getAttribute("user");
		if(user==null){
			req.setAttribute("msg", "请重新登录");
			req.getRequestDispatcher("/page/day19_2/exercise/login.jsp").forward(req, resp);
		}else {
			ContactService contactService = LogProxy.getInstance();
			String mark = req.getParameter("mark");
			if ("toAddOrU".equals(mark)) {// 到达新增或修改页面
				toAddorU(req, resp, contactService);
			} else if ("doAddOrU".equals(mark)) { // 新增或修改
				doAddorU(req, resp, contactService);
			} else if ("delete".equals(mark)) { // 删除
				delete(req, resp, contactService);
			}else if("batchD".equals(mark)){	//批量删除选中
				batchD(req, resp, contactService);
			} else { // 主列表页
				toList(req, resp, contactService);
			}
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp, ContactService contactService)
			throws IOException {
		String id = req.getParameter("id");
		contactService.deleteC(id);
		resp.sendRedirect(req.getContextPath() + "/ContactMain4");
	}

	private void toList(HttpServletRequest req, HttpServletResponse resp, ContactService contactService)
			throws ServletException, IOException {
		String s = req.getParameter("s");
		String msg=req.getParameter("msg");
		Integer page=Integer.parseInt(req.getParameter("page")==null?"1":req.getParameter("page"));
		Integer pageSize=Integer.parseInt(req.getParameter("pageSize")==null?"5":req.getParameter("pageSize"));
//				List<Contact19_2> list = contactService.findAllC();
//				List<Contact19_2> list = contactService.selectC(s,msg);
		PageBean pageBean = contactService.selectCBuPage(s,msg,page,pageSize);
		// 存储数据到域对象
		req.setAttribute("pageBean", pageBean);
		// 跳转到目标页面
		req.getRequestDispatcher("/page/day19_2/exercise/contactList.jsp").forward(req, resp);
	}

	private void batchD(HttpServletRequest req, HttpServletResponse resp, ContactService contactService)
			throws IOException {
		String ids = req.getParameter("ids");
		if(ids.length()>0){
			ids=ids.substring(0, ids.length()-1);
			contactService.batchDeleteByIds(ids);
		}
		resp.sendRedirect(req.getContextPath() + "/ContactMain4");
	}

	private void doAddorU(HttpServletRequest req, HttpServletResponse resp, ContactService contactService)
			throws IOException {
		// 用BeanUtils封装
		Contact19_2 contact = this.copyToBean2(req, Contact19_2.class);
		contactService.addOrUpdateC(contact);
		resp.sendRedirect(req.getContextPath() + "/ContactMain4");
	}

	private void toAddorU(HttpServletRequest req, HttpServletResponse resp, ContactService contactService)
			throws ServletException, IOException {
		Contact19_2 contact = null;
		String id = req.getParameter("id");
		if (null != id) {
			contact = contactService.findCById(Integer.valueOf(id));
		}
		req.setAttribute("contact", contact);
		req.getRequestDispatcher("/page/day19_2/exercise/addorUpdateC.jsp").forward(req, resp);
	}
	
	

}
