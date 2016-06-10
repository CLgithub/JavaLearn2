package day19_2.exercise.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import day19_2.exercise.base.BaseController;
import day19_2.exercise.entity.Users;
import day19_2.exercise.service.UserService;
import day19_2.exercise.service.UserServiceImpl;

public class UserController extends BaseController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		
		UserService userService=new UserServiceImpl();
		
		String mark = req.getParameter("mark");
		if("login".equals(mark)){
			
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			
			Users user=userService.login(name,password);
			if(user!=null){		//登录成功
				req.getSession().setAttribute("user", user);
				//重定向到主框架页
				resp.sendRedirect(req.getContextPath()+"/page/day19_2/exercise/main.jsp");
			}else {			//登录失败
				//转发到登录页面
				req.setAttribute("msg", "用户名或密码");
				req.getRequestDispatcher("/page/day19_2/exercise/login.jsp").forward(req, resp);
			}
		}else if("reg".equals(mark)){
			
		}

	}

}
