package day29_struts2;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo5 extends ActionSupport{

	@Override
	public String execute() throws Exception {
		//1.获取ActionContext 对象
		ActionContext aContext=ActionContext.getContext();
		//获取servlet api	注意：通过actioncontext对象获取的servlet api是一个map集合
		Map<String, Object> application = aContext.getApplication();	//appliction
		Map<String, Object> session = aContext.getSession();			//session
		
		Map<String, Object> parameters = aContext.getParameters();	//获取请求参数,相当于request.getParameters()

		
		System.out.println(application.get("msg1"));
		System.out.println(session);
		System.out.println(parameters);
		
		//向request范围存储数据		actionContext就是request？？？
		aContext.put("userName", "小明");
		
		
		return SUCCESS;
	}
}
