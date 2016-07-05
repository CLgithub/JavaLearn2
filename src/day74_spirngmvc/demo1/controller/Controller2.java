package day74_spirngmvc.demo1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestHandler;
import day72_mybatis.demo.eneity.Items;

/*
 * 第一个handler
 */
public class Controller2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
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
		
		
		//将itemsList保存到request域
		request.setAttribute("itemsList", itemsList);
		//转发到目标页面
		request.getRequestDispatcher("/page/day74_spingmvc/itemsList.jsp").forward(request, response);
	}

}
