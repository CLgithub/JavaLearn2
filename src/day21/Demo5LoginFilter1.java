package day21;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo5LoginFilter1 implements Filter {

	@Override
	public void destroy() {

	}

	/**
	 * 拦截登录页面，检测是否有cookies，如果有，自动填入用户名密码
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			User user=new User();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userName")) {
					user.setLoginName(cookie.getValue());
				}
				if (cookie.getName().equals("pass")) {
					user.setPassword(cookie.getValue());
				}
				req.getSession().setAttribute("user", user);
			}
		} else {
			System.out.println("没有接收到cookie");
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
