package day68webservice.demo2;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.xml.sax.InputSource;

import day67webservice.demo1.stub.GlobalWeather;
import day67webservice.demo1.stub.GlobalWeatherSoap;

@WebServlet(urlPatterns={"/WSDemo2CServlet"})
public class Demo2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html; charset=utf-8");
			String cityName = req.getParameter("cityName");
			String string = getw(cityName);
			Document document = new SAXReader().read(new InputSource(new StringReader(string)));
			Node node = document.selectSingleNode("//Temperature");
			resp.getWriter().write(node.getText());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	//返回对应城市的天气☁️信息
	public static String getw(String cityName){
		//创建服务器访问点集合
		GlobalWeather gWeather=new GlobalWeather();
		//根据服务访问点获得绑定的类 wsdl:portType
		GlobalWeatherSoap serviceClass = gWeather.getGlobalWeatherSoap();
		//调用具体业务逻辑
		String result=serviceClass.getWeather(cityName, "");
		return result;
	}
}
