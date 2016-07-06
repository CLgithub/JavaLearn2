package day74_spirngmvc.demo2.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import day74_spirngmvc.demo2.entity.Items;
import day74_spirngmvc.demo2.entity.ItemsCustom;
import day74_spirngmvc.demo2.entity.ItemsQueryVo;
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
	/*
	 * @RequestParam 
	 * 绑定单个请求参数,当不写这个注释时，  只有提交的参数名和方法形参名相同才能绑定.
	 * 使用这个注解
	 * value="id" 			指定绑定哪个提交参数
	 * required=true		这个参数是必须要有
	 * defaultValue="1"		默认1
	 * 
	 */
	@RequestMapping(value="/toEditOrAddItemPage3",method={RequestMethod.GET,RequestMethod.POST})
	public void toEditOrAddItemPage3(@RequestParam(value="id",required=false,defaultValue="1")Integer id, HttpServletRequest request, HttpServletResponse response){
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
	@RequestMapping(value="/doEditOrAddItems",method={RequestMethod.POST})
	public String doEditOrAddItems(ItemsCustom items/*简单实体类绑定*/,
			ItemsQueryVo itemsQueryVo/*包装类型*/){
		itemsService.doEditOrAddItems(items);
		return "redirect:toList.action";	//重定向
//		return "forward:toList.action";		//转发
	}
	
	//修改商品信息2		包装类型绑定
	@RequestMapping(value="/doEditOrAddItems2",method={RequestMethod.POST})
	public String doEditOrAddItems2(ItemsQueryVo itemsQueryVo){
		System.out.println(itemsQueryVo);
//		itemsService.doEditOrAddItems(itemsQueryVo);
		return "redirect:toList.action";	//重定向
	}
	
	//自定义属性编辑器	此方法只能在这个control中使用
//	@InitBinder
//	public void initBinder(WebDataBinder binder) throws Exception {
//		//Date.class是实体类里的日期类型
//		binder.registerCustomEditor(Date.class, 
//				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));	//是否允许为空
//	}
}
