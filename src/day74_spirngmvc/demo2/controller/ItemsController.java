package day74_spirngmvc.demo2.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import day74_spirngmvc.demo2.entity.Items;
import day74_spirngmvc.demo2.service.ItemsService;

@Controller
@RequestMapping("/itemsController")
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
//	@RequestMapping("/toEditOrAddItemPage")
//	public ModelAndView toEditOrAddItemPage(int id){
//		ModelAndView modelAndView = new ModelAndView();
//		
//		try {
//			Items items = itemsService.findbyId(id);
//			modelAndView.addObject("items", items);
//			modelAndView.setViewName("itemsList");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return modelAndView;
//		
//	}
}
