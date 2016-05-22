package day13;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
	设计一个web app，每次产生一个30以内的数字，给5次机会让客户猜测这个数字：
*/
public class Demo2GuessServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		HttpSession session = req.getSession(false);
		if(null==session){	//如果是第一次访问
			//产生随机数，存储在session中
			Random random=new Random();
			int r=(random.nextInt(29)+1);
			session=req.getSession();
			session.setAttribute("num", r);
			session.setAttribute("count", 5);
			//告诉用户开始踩数字
			req.setAttribute("massage", "你现在有"+session.getAttribute("count")+"次机会猜一个1~30的整数");
		}else {
			Object attribute = session.getAttribute("count");
			int conut = (int) attribute;
			if(conut>0){
				int num = (int) session.getAttribute("num");
				int userNum = Integer.parseInt(req.getParameter("userNum"));
				if(num==userNum){
					//猜中
					req.setAttribute("massage", "恭喜你，猜中了，这个数字是"+session.getAttribute("num"));
				}else if(userNum>num){
					//猜错
					req.setAttribute("massage", "大了，还有"+session.getAttribute("count")+"次机会");
				}else if(userNum<num){
					//猜错
					req.setAttribute("massage", "小了，还有"+session.getAttribute("count")+"次机会");
				}
				session.setAttribute("count", conut-1);
			}else {
				//告诉用户已经没有机会了
				req.setAttribute("massage", "没有机会了");
				req.removeAttribute("count");
			}
		}
		this.getServletContext().getRequestDispatcher("/page/day13/Demo2Guess.jsp").forward(req, resp);
	}
}
