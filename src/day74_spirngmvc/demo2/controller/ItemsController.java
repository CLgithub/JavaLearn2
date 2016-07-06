package day74_spirngmvc.demo2.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import day74_spirngmvc.demo2.entity.Items;
import day74_spirngmvc.demo2.service.ItemsService;

@Controller
@RequestMapping("/itemsController")	//定义url的根路径
public class ItemsController {
	
	@Resource
	private ItemsService itemsService;
	
	//到达商品列表也
	@RequestMapping("/toList")
	public ModelAndView toList(){
		List<Items> itemsList = itemsService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}
	
	//到达新增或修改商品页面
	//method={RequestMethod.GET,RequestMethod.POST}限制只能使用get和post提交
	@RequestMapping(value="/toEditOrAddItemPage",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toEditOrAddItemPage(int id){
		ModelAndView modelAndView = new ModelAndView();
		try {
			Items items = itemsService.findbyId(id);
			modelAndView.addObject("items", items);
			modelAndView.setViewName("editItem");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	//方法返回字符串，直接返回逻辑视图，数据可以在形参上加一个model，对model添加属性
	@RequestMapping(value="/toEditOrAddItemPage2",method={RequestMethod.GET,RequestMethod.POST})
	public String toEditOrAddItemPage2(int id, Model model){
		try {
			Items items = itemsService.findbyId(id);
			model.addAttribute("items", items);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "editItem";
	}

	//方法返回void，可以用请求转发，数据存入request中，类似servlet开发
	@RequestMapping(value="/toEditOrAddItemPage3",method={RequestMethod.GET,RequestMethod.POST})
	public void toEditOrAddItemPage3(int id, HttpServletRequest request, HttpServletResponse response){
		try {
			Items items = itemsService.findbyId(id);
			request.setAttribute("items", items);
			//如果使用转发，这里必须填写完整路径，不能只是逻辑视图名
			request.getRequestDispatcher("/page/day74_spingmvc/editItem.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改商品信息
	//方法返回字符串,redirect重定向，forward转发
	@RequestMapping(value="/doEditOrAddItems")
	public String doEditOrAddItems(Items items){
//		itemsService.doEditOrAddItems(items);
//		return "redirect:toList.action";	//重定向
		return "forward:toList.action";		//转发
	}
}
