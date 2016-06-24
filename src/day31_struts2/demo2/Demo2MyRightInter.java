package day31_struts2.demo2;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

import day30_struts2.User;

public class Demo2MyRightInter implements Interceptor{

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionProxy actionProxy = invocation.getProxy();

//		String namespace = actionProxy.getNamespace();		//名称空间	/day31_2
		String actionName = actionProxy.getActionName();	//访问的资源路径
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		User user = (User) session.getAttribute("user");
		if(user!=null){
			if ("admin".equals(user.getName())) {
				invocation.invoke();
			}else {
				if(actionName.contains("search")){
					invocation.invoke();
				}else {
					return "noRight";
				}
			}
		}else {
			return "noRight";
		}
		return null;
	}

}
