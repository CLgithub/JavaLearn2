package day19_2.exercise.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day19_2.exercise.entity.Users;
import day19_2_listener.demo.User;

@WebFilter(value="/ContactMain4")
public class ContactFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fChain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String mark=req.getParameter("mark");
		List<String> list=new ArrayList<>();
		list.add("toAddOrU");
		list.add("doAddOrU");
//		list.add("delete");
		list.add("batchD");
		list.add(null);
		Users user = (Users) request.getSession().getAttribute("user");
		if(user!=null&&list.contains(mark)){
			fChain.doFilter(request, response);
		}else {
			request.setAttribute("msg", "没有权限");
			req.getRequestDispatcher("/page/day19_2/exercise/login.jsp").forward(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
