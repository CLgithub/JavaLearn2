package day19_2_listener.demo;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



public class MyHttpSessionListener implements HttpSessionListener{

	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		List<HttpSession> sessions = (List<HttpSession>) arg0.getSession().getServletContext().getAttribute("sessions");
		sessions.add(arg0.getSession());
		System.out.println("add:"+arg0.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
	}

}
