package day19_2_listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/*
演示监听属性变化
	演示监听session的属性变化（MySessionAttributeListener）
*/
public class MySessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
//		arg0.getSource();	//获取事件源
		HttpSession session = arg0.getSession();	//获取事件源，也就是获取session对象
		System.out.println(arg0.getName());
		System.out.println(arg0.getValue());
		System.out.println("向session中添加属性");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("向session中除移属性");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("向session中修改属性");
	}

}
