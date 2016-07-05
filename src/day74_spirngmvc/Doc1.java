package day74_spirngmvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;

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
	
	
注解映射器和适配器
	文件：
			/org/springframework/web/servlet/DispatcherServlet.properties
		dispatcherServlet前端控制器会加载/DispatcherServlet.properties配置文件，从而默认加载各个组件
			如果在上springmvc.xml配置了处理器映射器和适配器，那么以springmvc.xml为准
	注解映射器：
		在spring3.1之前，默认加载
			org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping
		在spring3.1之后
			org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
	注解适配器
		3.1之前
			org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter
		3.1之后
			org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
				RequestMappingHandlerAdapter不要求实现任何接口，但是要和RequestMappingHandlerMapping配对使用
				配对使用主要是为了解析handler方法中的行参

小结：
	dispatcherServlet：前端控制器，相当于中央调度器，可以降低组件之间的耦合
	HandlerMapping：处理器映射器，负责根据url查找handler
	HandlerAdapter：处理器适配器，负责适配器规则执行handler，可以通过扩展适配器接口HandlerAdapter，让其支持不同的handler
	viewResolver：视图解析器，根据逻辑视图名解析成真正的视图
		真正视图地址=前缀+逻辑视图名+后缀
		
执行过程源码分析：
	DispatcherServlet中，入口方法doDispatch
	方法中对处理器映射器请求查找handler，放回HandlerExecutionChain
	1.DispatcherServlet通过handlerMapping查找handler
		HandlerExecutionChain mappedHandler = getHandler(processedRequest);
			HandlerExecutionChain handler = hm.getHandler(request);
	2.DispatcherServlet通过适配器去执行handler，得到modelandview
		找到HandlerAdapter
			HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
		用HandlerAdapter去执行Handler得到ModelAndView
			mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
	3.视图解析
		得到一个view
	4.视图渲染
		将模型数据填充到request域
		view.render(mv.getModelInternal(), request, response);
			protected void exposeModelAsRequestAttributes(Map<String, Object> model, HttpServletRequest request) throws Exception {
				for (Map.Entry<String, Object> entry : model.entrySet()) {
					String modelName = entry.getKey();
					Object modelValue = entry.getValue();
					if (modelValue != null) {
						request.setAttribute(modelName, modelValue);
						if (logger.isDebugEnabled()) {
							logger.debug("Added model object '" + modelName + "' of type [" + modelValue.getClass().getName() +
									"] to request in view with name '" + getBeanName() + "'");
						}
					}
					else {
						request.removeAttribute(modelName);
						if (logger.isDebugEnabled()) {
							logger.debug("Removed model object '" + modelName +
									"' from request in view with name '" + getBeanName() + "'");
						}
					}
				}
			}
		
	

*/
public class Doc1 {

}
