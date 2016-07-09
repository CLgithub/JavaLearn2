package day74_spirngmvc.demo2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("loginController")
@Controller
public class LoginController {
	
	//登录
	@RequestMapping("login")
	public String login(String loginName,String password,HttpSession session){
		if("aa".equals(loginName)&&"123".equals(password)){
			session.setAttribute("loginName", loginName);
			return "forward:/itemsController/toList.action";
		}else {
			return "redirect:/page/day74_spingmvc/login.jsp";
		}
		
	}
	
	//登出
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("loginName");
		return "redirect:/page/day74_spingmvc/login.jsp";
	}
}
