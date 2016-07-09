package day74_spirngmvc;

/*
spirngMVC知识点梳理回顾
	执行流程：看图
	基础配置：
		DispatcherServlet前端控制器
			web.xml中配置
		HandlerMapping处理器映射器
			非注解：
				BeanNameUrlHandlerMapping		和SimpleControllerHandlerAdapter配套使用
				SimpleUrlHandlerMapping			和HttpRequestHandlerAdapter配套使用
			注解：
				3.1前 	DefaultAnnotationHandlerMapping
				3.1后 	RequestMappingHandlerMapping	和RequestMappingHandlerAdapter配套使用
		HandlerAdapter处理器适配器
			非注解：
				SimpleControllerHandlerAdapter		要求handler实现Controller接口
				HttpRequestHandlerAdapter			要求handler实现HttpRequestHandler接口
			注解：
				3.1前 	AnnotationMethodHandlerAdapter
				3.1后 	RequestMappingHandlerAdapter	不要求handler实现接口，但需要在handler中添加@controller来标识此类是一个控制器，添加@requestMapping指定handler方法所对应的url
		使用<mvc:annotation-driven />可以代替上面HandlerAdapter和HandlerMapping的配置
		
		配置视图解析器
			在这个视图解析器中，要求将jstl的包加到classpath中
			
	相关功能：
		自定义属性编辑器（早期使用）
		自定义类型转换器：
				定义一个类，实现Converter<String, Date>//原始类型string,目标类型Date接口，配置注册
			handler方法行参默认能绑定：request，response，session，model类型
			使用@RequestParam注解：用于绑定单个请求参数，常用于简单类型（integer，string，float。。。）参数绑定
				不用这个注解，要求请求参数名称和方法形式参数名一致
			对于日期类型：
				需要使用
					自定义属性编辑器（早期）
					自定义类型转换器Converter
			实体类，包装实体类
			绑定集合类型：
				数组，list，map...
		json消息转换器
			当需要使用json交互时，配合@ResponseBody，@RequestBody使用
		图片上传解析器
			配置图片上传解析器	可设置图片最大尺寸
			使用MultipartFile接收图片
		统一异常处理器
				定义一个类，实现HandlerExceptionResolver接口，配置
			controller，service，dao异常都往上抛，最后配置一个统一异常处理器处理
		静态资源解析
			如果配置了restful，会拦截所有/请求，需要配置静态资源解析
			
	方法可以返回：
		ModelAndView
		String
			可以直接返回逻辑视图名
			return "redirect:toList.action";	//重定向
			return "forward:toList.action";		//转发
		void
			和原始servlet开发类似，也可以用response返回json
			
	注解总结：
		@Controller				用于类			标注为控制层
		@RequestMapping			用于类，用于方法	标注handler的访问地址	可以指定访问方法（post/get）
 		@RequestParam			用于形参前			绑定请求参数，不使用这个注解，请求参数名和行参名就必须相同
 		@ModelAttribute			用于方法，用于行参	将被注解的对象存入到model，jsp便可方便的取出这些公共数据
 		@InitBinder				用于方法前			初始化绑定，用于注解自定义属性编辑器
 		@PathVariable			在restful规范开发时，用于绑定url中请求参数到行参
 		@ResponseBody			用在方法前			用于指定方法用json类型返回
 		@RequestBody			用于行参前			用于将json格式的请求绑定到行参
 		
 		
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
public class Doc2 {

}
