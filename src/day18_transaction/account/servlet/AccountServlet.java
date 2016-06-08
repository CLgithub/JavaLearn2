package day18_transaction.account.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import day18_transaction.account.service.AccountService;
import day18_transaction.account.service.AccountServiceImpl;

/*
案例：转账汇款----使用事务
	问题：service调用dao中的两个方法完成一个业务操作，如果其中一个方法执行失败怎么办？
		需求事务控制
	问题：怎么进行事务控制？
		在service层进行事务的开启，回滚已经提交操作
	问题：进行事务操作需要使用connection对象，那么，怎么保证，在service中与dao中所使用的是同一个connection
		在service层创建出connection对象，然后将这个对象传到dao层
		
	注意：connect对象使用完成后，在service层finally中关闭
			而每一个prepareStatement它们在dao层的方法中用完就关闭
	关于程序问题：
		1.对于转入与转出操作，我们需要判断是否成功，如果失败，可以抛出自定义异常在servlet中判断
		进行信息显示
	问题：在设计dao时
		void accountout(String accountout, double money) throws Exception;
		void accountin(String accountin, double money) throws Exception;
		那么要怎样处理，保证connection对象是同一个
		方式1：
			实现类的构造方法里接收connection
		方式2：
			使用ThreadLocal
			threadLocal可以理解成一个map集合
			Map<Thread,Object>
			如果我们是在同一个线程中，只要任意的一个位置存储l数据，在其他位置，就可以获取到这个数据
		
		
*/
public class AccountServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		try {
			//得到请求参数
			String accountin = req.getParameter("accountin");
			String accountout = req.getParameter("accountout");
			double money = Double.parseDouble(req.getParameter("money"));
			
			//2.调用service完成汇款操作
			AccountService service=new AccountServiceImpl();
			service.account(accountin,accountout,money);
			resp.getWriter().write("转账成功");
//			return;
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
//			return;
		}
	}
	
	
}
