package day74_spirngmvc;

/*
springMVC是什么：
	springmvc是spring的一个模块，提供web层解决方案（基于mvc设计架构）

spring执行流程
	1.用户发起request请求，请求至DispatcherServlet前端控制器
	2.DispatcherServlet前端控制器请求HandlerMapping处理器映射器查找Handler
		DispatcherServlet：前端控制器，相当于中央调度器，各各组件都和前端控制器进行交互，降低了各各组			件之间耦合度。
	3.HandlerMapping处理器映射器，根据url及一些配置规则（xml配置、注解配置）查找Handler，将Handler返回给DispatcherServlet前端控制器
	4.前端控制器调用处理器适配器HandlerAdapter，执行Handler，有了适配器，就能在适配器上扩展对不同Handler执行方式（比如：原始servlet开发，注解开发）
	5.适配器执行Handler
		handler是后端处理器，可以当初模型
	6.handler执行完成，返回ModelandView
		ModelAndView：spring的一个对象，对model和view进行封装
	7，适配器Adapter将modelandView返回给前端控制器
	8，DispatcherServlet调用视图解析器进行视图解析，解析后生成view
		视图解析器根据逻辑视图名，解析出真正的视图
		view：spring视图封装对象，提供了很多view，jsp、freemarker、pdf、excel...
	9.视图解析器给前端控制器返回view
	10.前端控制器调用view的渲染视图的方法，将模型数据填充到request域
	11.前端控制器向用户响应结果（jsp页面，json数据...）
	
	DispatcherServlet:		前端控制器，由于springmvc提供
	HandlerMapping：		处理器映射器，由于springmvc提供
	HandlerAdapter：		处理器适配器，由于springmvc提供
	Handler：			处理器，需要程序员开发
	ViewResolver：		view视图解析器，由于spring提供
	view：				真正的视图页面需要有程序员编写
	
	

*/
public class Doc1 {

}
