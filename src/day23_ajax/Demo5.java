package day23_ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import net.sf.json.JSONArray;

public class Demo5 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		List<Product> productList=new ArrayList<>();
		productList.add(new Product(1, "洗衣机", 3200));
		productList.add(new Product(2, "手机", 3200));
		productList.add(new Product(3, "macBookPro", 16200));
		productList.add(new Product(4, "电冰箱", 3700));
		productList.add(new Product(5, "电视", 5200));
		
		//返回json数据
//		resp.getWriter().print("[{'id':'1','name':'洗衣机','price':'1800'},{'id':'2','name':'电视机','price':'3800'}]");
		
		String json = JSONArray.fromObject(productList).toString();
		resp.getWriter().write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

