package day11;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
cookie练习：
	1.显示用户上次访问的时间
	2.显示用户上次浏览过的商品
*/
public class Demo3Cookie2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
//		getHistoryDate(req, resp);
		getHistorySP(req,resp);
	}

	//查看上次浏览过的商品
	private void getHistorySP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		StringBuffer sBuffer=new StringBuffer();
		sBuffer.append("<form action='/JavaLearn2/Servlet14' method='get'>"
				+ "商品1<input type='checkbox' name='sp' value='1'>"
				+ "商品2<input type='checkbox' name='sp' value='2'>"
				+ "商品3<input type='checkbox' name='sp' value='3'>"
				+ "<input type='submit' value='浏览'>"
				+ "</form>"
				);
		//0.得到用户本次访问的信息
		String[] sps = req.getParameterValues("sp");
		if(null!=sps){	//本次有浏览记录才存储
			//1.创建cookie对象
			Cookie cookie=new Cookie("hsp",Arrays.toString(sps));
			//2.设置cookie有效时长
			cookie.setMaxAge(1*60*60*24*7); 	//一周
			//3.将cookie发送到浏览器
			resp.addCookie(cookie);
		}
		//4.取出浏览器发送回来的cookie，显示上次访问的商品
		Cookie[] cookies = req.getCookies();
		if(null==cookies){
			sBuffer.append("没有你上次浏览过的商品记录");
		}else {
			sBuffer.append("你上次浏览过的商品有:");
			for(Cookie cookie2:cookies){
				if(cookie2.getName().equals("hsp")){
					String value = cookie2.getValue();
					sBuffer.append("商品"+value);
				}
			}
		}
		
		resp.getWriter().write(sBuffer.toString());
	}

	//得到上次访问时间
	private void getHistoryDate(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException, IOException {
		//1.创建cookie对象
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Cookie cookie1=new Cookie("date", sDateFormat.format(new Date()));
		
		//2.设置cookie有效时长
		cookie1.setMaxAge(1*60*60*24*7); 	//一周		如果不设置，默认当浏览器退出时cookie就丢失了
		
		//3.将cookie发送到浏览器
		resp.addCookie(cookie1);
		//4.接收cookie，显示上次访问时间
		Cookie[] cookies = req.getCookies();
		if(null==cookies){
			resp.getWriter().write("本周内第一次访问，当前时间是："+sDateFormat.format(new Date()));
		}else {
			for(Cookie cookie:cookies){
				String dataStr = cookie.getValue();
				resp.getWriter().write("上次访问时间："+dataStr+",当前时间是："+sDateFormat.format(new Date()));
			}
		}
	}
}
