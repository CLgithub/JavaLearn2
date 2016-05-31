package day17;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Demo4Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		User user=doLogin1(name,password);
		if(null!=user){
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	
	//判断是否登录
	private User doLogin1(String name, String password) {
		User user=null;
		Connection connect=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			//可能遭受sql注入攻击
			//' or 1=1 or '
			String sql="select * from users where name='"+name+"' and password='"+password+"'";	
			
			System.out.println("sql:"+sql);
			connect = Demo2JdbcUtil.getConnect();
			statement = connect.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				user=new User();
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Demo2JdbcUtil.closeC(connect, statement, resultSet);
		}
		return user;
	}
	//判断是否登录
	private User doLogin2(String name, String password) {
		User user=null;
		Connection connect=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			String sql="select * from users where name=? and password=?";
			connect = Demo2JdbcUtil.getConnect();
			PreparedStatement prepareStatement = connect.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, password);	
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()){
				user=new User();
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Demo2JdbcUtil.closeC(connect, statement, resultSet);
		}
		return user;
	}
}

class User implements Serializable{
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public User() {
	}
	
}
