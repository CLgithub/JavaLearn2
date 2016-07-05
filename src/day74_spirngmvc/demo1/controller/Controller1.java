package day74_spirngmvc.demo1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import day72_mybatis.demo.eneity.Items;

/*
 * 第一个handler
 */
public class Controller1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		//将itemsList保存到request域
//		request.setAttribute("itemsList", itemsList);
		//相当于将数据填充到request域
		modelAndView.addObject("itemsList",itemsList);
		//转发到目标页面
//		request.getRequestDispatcher("/page/day74_spingmvc/itemsList.jsp").forward(request, response);
		//指定要目标页面
		modelAndView.setViewName("/page/day74_spingmvc/itemsList.jsp");
		return modelAndView;
	}

}
