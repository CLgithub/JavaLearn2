package day19_2_listener.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener{

	private List<HttpSession> sessions=new LinkedList<>();
//	private List<HttpSession> sessions=Collections.synchronizedList(new ArrayList<>());
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("MyServletContextListener.contextDestroyed()");
		arg0.getServletContext().setAttribute("sessions", sessions);
		
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("扫描");
				for(HttpSession session:sessions){
					long lastAccessedTime = session.getLastAccessedTime();
					long currentTimeMillis = System.currentTimeMillis();
					if (currentTimeMillis-lastAccessedTime>10000) {
						session.invalidate();
						sessions.remove(session);
						System.out.println("销毁："+session.getId());
					}
				}
			}
		}, 1000,2000);
	}

}
