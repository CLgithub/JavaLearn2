package day10_servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
10.3.3	void setAttribute(java.lang.String name, java.lang.Object object) --和域对象有关的方法
			java.lang.Object getAttribute(java.lang.String name)  
			void removeAttribute(java.lang.String name)
			域对象作用：保存数据，获取数据，可以在不同的动态资源间共享数据
				案例：servlet1有数据需要共享给servlet2
				servlet1						servlet2
				name=eric
				Student student1
			方案一：	传递参数的形式共享数据，局限：只能传字符串
				response.sendRedirect(/servlet2?name=eric)		request.getParameter("name")
			方案二：使用域对象共享数据，好处：可以共享任意类型的数据
				在servlet1中将需要共享的数据保存到域对象中，在servlet2中取出域对象中保存的数据
				域对象相当于一个容器，一个中介
			
			第一个域对象：servletContext
				保存数据：setAttribute(String,Object)	//数据名，数据值
				获取数据：getAttribute(String)			//数据名
				清除数据：removeAttribute(String)		//数据名
		
		ServletContext对象作用域：整个web应用
		
		所有域对象：
			ServletContext
			HttpServletRequest
			HttpSession
			PageContext
			
		
 */
public class Demo5ServletContext2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		resp.getWriter().write("Servlet11<br>");
		//得到域对象servletContext，
		ServletContext servletContext = this.getServletContext();
		//取出保存到在其中的student对象，并显示
		Student student = (Student) servletContext.getAttribute("student1");
		if(student!=null){
			resp.getWriter().write(student.toString());
		}else {
			resp.getWriter().write("没有收到对象");
		}
		
	}
}

class Student {
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

}
