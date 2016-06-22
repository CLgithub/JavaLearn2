package day29_struts2;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{

	public String add(){
		System.out.println("BookAction.add()");
		return NONE;
	}
	
	public String update(){
		System.out.println("BookAction.update()");
		return NONE;
	}
	
	public String delete(){
		System.out.println("BookAction.delete()");
		return NONE;
	}
	
	public String query(){
		System.out.println("BookAction.query()");
		return NONE;
	}
}
