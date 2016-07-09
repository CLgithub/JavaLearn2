package day74_spirngmvc.demo2.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UrlInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
//		System.out.println(url);
		if(url.contains("/loginController/login.action")){
			return true;
		}else {
			HttpSession session = request.getSession();
			String loginName = (String) session.getAttribute("loginName");
			if("aa".equals(loginName)){
				return true;
			}else {
//				return false;	//false拦截	true放行
				response.sendRedirect(request.getContextPath()+"/page/day74_spingmvc/login.jsp");
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
