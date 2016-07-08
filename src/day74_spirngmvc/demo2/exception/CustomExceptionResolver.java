package day74_spirngmvc.demo2.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常处理器
 * @author L
 * @date 2016年7月8日
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	//前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常,就调用此方法
	//handler其实就是一个handlerMethod
	//ex其实就是异常信息
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//输出异常
		ex.printStackTrace();
		//统一异常代码
		
		try {
			String message=null;
			CustomException customException=null;
			if(ex instanceof CustomException){	//如果预期异常，用这种方法处理
				customException=(CustomException) ex;
			}else {
				//如果不是统一系统异常，就构造一个未知错误异常
				customException = new CustomException("未知错误");
				
			}
			request.setAttribute("message", customException.getMassage());
			//转发到错误页面
			request.getRequestDispatcher("/page/day74_spingmvc/error.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		
		return new ModelAndView();
	}

}
