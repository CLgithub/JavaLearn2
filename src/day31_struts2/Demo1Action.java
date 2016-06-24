package day31_struts2;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		System.out.println("Demo1Action.execute()");
		return null;
	}
}
