package day74_spirngmvc.demo2.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import day74_spirngmvc.demo2.entity.Items;
import day74_spirngmvc.demo2.entity.ItemsCustom;
import day74_spirngmvc.demo2.entity.ItemsQueryVo;
import day74_spirngmvc.demo2.service.ItemsService;

/*
此页面知识点总结：
	使用@RequestMapping注解定义url路径，此注解还可以此方法的访问方法（get/post）
	方法可以返回：
		ModelAndView
		String
			可以直接返回逻辑视图名
			return "redirect:toList.action";	//重定向
			return "forward:toList.action";		//转发
		void
			和原始servlet开发类似，也可以用response返回json
	方法参数绑定：
		默认：request，response，session，model(用于将数据填充的request中的)
		使用@RequestParam注解：用于绑定单个请求参数，常用于简单类型（integer，string，float。。。）参数绑定
			不用这个注解，要求请求参数名称和方法形式参数名一致
		对应简单类型的日期型：
			需要使用
				自定义属性编辑器（早期）
				自定义类型转换器Converter
		实体类，包装实体类
		绑定集合类型：
			数组，list，map...
		
	公共方法：
		使用@ModelAttribute注解向model添加属性，在jsp各处就可以取出公共数据
		
		
	springMVC上传图片：
		配置图片上传解析器
		使用MultipartFile接收图片
		
	
springMVC和struts2的区别：
	spingMVC
		通过方法接收参数，在使用时可以以单例方式使用，建议使用单例
		基于方法开发，一个请求的一个method和handler进行绑定
		方法更贴近service（业务方法）
	
	struts2
		是通过成员变量接收参数，在霍思燕时不能以单例方式使用
		基于类开发
		
		经过测试，struts标签解析速度比较慢
	
	
	
	
*/
@Controller
@RequestMapping("/itemsController")	//定义url的根路径
public class ItemsController {
	
	@Resource
	private ItemsService itemsService;
	
	//单独将商品类型的方法提出来，将方法放回值填充到request，在页面显示，jsp多个地方可以得到这个地方传递的数据
	//在ModelAttribute中 指定的名称就是要填充到model的key，在页面中通过这个key来取数据
	//通常使用这种方法将公用的数据传到页面
	@ModelAttribute("itemsType")
	public Map<String, String> getItemsType(){
		HashMap<String, String> itemsType=new HashMap<>();
		itemsType.put("001", "数码");
		itemsType.put("002", "服装");
		return itemsType;
	}
	
	//到达商品列表页
	@RequestMapping("/toList")
	public ModelAndView toList(){
		List<Items> itemsList = itemsService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}
	
	//到达批量修改商品列表页
	@RequestMapping("/toEditList")
	public ModelAndView toEditList(){
		List<Items> itemsList = itemsService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("editList");
		return modelAndView;
	}
	
	//到达新增或修改商品页面
	//method={RequestMethod.GET,RequestMethod.POST}限制只能使用get和post提交
	@RequestMapping(value="/toEditOrAddItemPage",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toEditOrAddItemPage(int id){
		ModelAndView modelAndView = new ModelAndView();
		try {
			ItemsCustom itemsCustom = itemsService.findbyId(id);
			modelAndView.addObject("itemsCustom", itemsCustom);
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
			ItemsCustom items = itemsService.findbyId(id);
			request.setAttribute("items", items);
			//如果使用转发，这里必须填写完整路径，不能只是逻辑视图名
			request.getRequestDispatcher("/page/day74_spingmvc/editItem.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改商品信息
	//方法返回字符串,redirect重定向，forward转发
	//回显方法二：@ModelAttribute将请求的实体类数据放到model中回显到页面,如果不加，那么name需要各处保存一致才行
	//上传商品图片
	//实际开发中使用专门的图片服务器（http）
	//这里使用图片虚拟目录，通过虚拟目录，访问硬盘上存储的图片目录、
	@RequestMapping(value="/doEditOrAddItems",method={RequestMethod.POST})
	public String doEditOrAddItems(@ModelAttribute(value="itemsCustom") ItemsCustom itemsCustom/*,Model model*/
			//上传图片	用MultipartFile接收
			,MultipartFile pictureFile
			) throws Exception{
		//回显方法一：进行数据回显,提交保存或如果修改不成功，需要返回修改页面
//		model.addAttribute("items", items);
		
		//图片上传
		if(pictureFile!=null){
			//图片上传成功后，要将图片的地址存储到数据库
			String filePaht="E:/develop/upload/";
			//获取图片原始名称
			String originalFilename = pictureFile.getOriginalFilename();
			String newFileNmae=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			File file=new File(filePaht+newFileNmae);
			//将内存中的文件写入磁盘
			pictureFile.transferTo(file);
			//保存图片地址写入数据库
			itemsCustom.setPic("/pic/"+newFileNmae);
		}
		itemsService.doEditOrAddItems(itemsCustom);
		
//		return "editItem";
		return "redirect:toList.action";	//重定向
//		return "forward:toList.action";		//转发
	}
	
	//修改商品信息2		包装类型绑定
	@RequestMapping(value="/doEditOrAddItems2",method={RequestMethod.POST})
	public String doEditOrAddItems2(ItemsCustom items/*简单实体类绑定*/,
			ItemsQueryVo itemsQueryVo/*包装类型*/){
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
	
	//参数绑定集合类型
	//批量删除
	@RequestMapping("/delteItems")
	public String delteItems(Integer[] delete_id){
		System.out.println(Arrays.toString(delete_id));
		//调用service里的方法批量删除商品
		return "success";
	}
	
	//批量修改商品，使用包装类型接收参数，绑定集合类型
	@RequestMapping("doEditList")
	public String doEditList(ItemsQueryVo itemsQueryVo){
		System.out.println(itemsQueryVo);
		
		return "success";
	}
	
	//如果是绑定map
	/*
	 * 页面上属性名		name="itemsMap['price']"
	 * 
	 * */
	
	
	
	
	
	
}
