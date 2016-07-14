package smm.day59esayui.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import smm.common.entity.User;
import smm.day59esayui.service.UserService;



@Controller
@RequestMapping("userController")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="getUserByid")
	@ResponseBody
	public Object getUserByid(@RequestParam("id")int id){
		User user = userService.selectByPrimaryKey(id);
		return user;
	}
}
