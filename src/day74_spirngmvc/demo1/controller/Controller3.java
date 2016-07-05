package day74_spirngmvc.demo1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import day72_mybatis.demo.eneity.Items;

/*
 * 注解开发handler
 */

@Controller
@RequestMapping("/Controller3")
public class Controller3 {

	@RequestMapping("/queryItems")
	public ModelAndView queryItems() {
		//使用静态数据把商品信息显示在jsp页面上
		List<Items> itemsList = new ArrayList<Items>();
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setCreatetime(new Date());
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		itemsList.add(items_1);
		itemsList.add(items_2);
		
		ModelAndView modelAndView=new ModelAndView();
		
//		//将itemsList保存到request域
//		request.setAttribute("itemsList", itemsList);
		modelAndView.addObject("itemsList", itemsList);
		
		//转发到目标页面		逻辑视图名
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}

}
