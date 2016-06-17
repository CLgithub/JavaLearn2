package day23_ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo4 extends HttpServlet{
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
		
		req.setAttribute("productList", productList);
		
		req.getRequestDispatcher("/page/day23_ajax/product.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

