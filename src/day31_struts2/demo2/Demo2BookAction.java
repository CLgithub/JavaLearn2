package day31_struts2.demo2;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2BookAction extends ActionSupport{
	
	public String search(){
		System.out.println("Demo2BookAction.search()");
		return SUCCESS;
	}
	
	public String add() {
		System.out.println("Demo2BookAction.add()");
		return SUCCESS;
	}
	
	public String update() {
		System.out.println("Demo2BookAction.update()");
		return SUCCESS;
	}
	
	public String delete() {
		System.out.println("Demo2BookAction.delete()");
		return SUCCESS;
	}
}
