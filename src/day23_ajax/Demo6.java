package day23_ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import net.sf.json.JSONArray;

public class Demo6 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		Integer sfid = Integer.parseInt(req.getParameter("sfid"));
		//根据省份id得到城市列表
		List<City> citys=this.getCity(sfid);
		//将list以json形式返回
		String json = JSONArray.fromObject(citys).toString();
		resp.getWriter().write(json);
	}

	//根据省份id得到城市列表
	private List<City> getCity(Integer sfid) {
		List<City> cities=new LinkedList<>();
		switch (sfid) {
		case 0:
			cities.add(new City("城市"));
			break;
		case 1:
			cities.add(new City("广州"));
			cities.add(new City("佛山"));
			cities.add(new City("湛江"));
			cities.add(new City("中山"));
			break;
		case 2:
			cities.add(new City("长沙"));
			cities.add(new City("衡阳"));
			cities.add(new City("岳阳"));
			cities.add(new City("郴州"));
			break;
		case 3:
			cities.add(new City("南宁"));
			cities.add(new City("桂林"));
			cities.add(new City("贵港"));
			cities.add(new City("柳州"));
			break;
		default:
			break;
		}
		return cities;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

