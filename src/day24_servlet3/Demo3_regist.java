package day24_servlet3;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/day24_reg",asyncSupported=true)//该servlet支持异步操作
public class Demo3_regist extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		// 注册
		System.out.println("开始注册");
//		resp.getWriter().write("开始注册");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("注册成功");
//		resp.getWriter().write("注册成功");

		// 发送邮件---重新开启一个线程来做
		// 开启线程，完成发邮件操作
		AsyncContext asyncContext = req.startAsync(); // 开启并返回异步上下文对象，
		asyncContext.addListener(new AsyncListener() {
			public void onTimeout(AsyncEvent arg0) throws IOException {
			}

			public void onStartAsync(AsyncEvent arg0) throws IOException {
			}

			public void onError(AsyncEvent arg0) throws IOException {
			}

			// 异步线程结束时调用
			public void onComplete(AsyncEvent arg0) throws IOException {
			}
		});
		sendEmail sendEmail = new sendEmail(asyncContext);
		new Thread(sendEmail).start();
	}
}

class sendEmail implements Runnable{
	AsyncContext asyncContext;
	public sendEmail(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void run() {
		try {
			ServletResponse response = asyncContext.getResponse();
			System.out.println("开始发送邮件");
			Thread.sleep(3000);
			System.out.println("邮件发送成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}