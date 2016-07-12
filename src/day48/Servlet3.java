package day48;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

@WebServlet(value="/day48Servlet3")
public class Servlet3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String province = req.getParameter("province");
		//System.out.println(province);
		
		List<String> cityList=findCityByProvince(province);
//		String json = JSONArray.fromObject(cityList).toString();	//此处因为有包冲突，不能转换
//		System.out.println(json);
		//手动拼接
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("[");
		for(String city:cityList){
			sBuffer.append("\'"+city+"\',");
		}
		String string=sBuffer.toString().substring(0, sBuffer.length()-1);
		string+="]";
//		System.out.println(string);
		resp.getWriter().write(string);
	}

	private List<String> findCityByProvince(String province) {
		List<String> cityList=new ArrayList<>();
		if("湖南".equals(province)){
			cityList.add("长沙");
			cityList.add("岳阳");
		}else if("广东".equals(province)){
			cityList.add("深圳");
			cityList.add("佛山");
		}
		return cityList;
	}
}
