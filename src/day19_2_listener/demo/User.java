package day19_2_listener.demo;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable{
	private int id;
	private String name;

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

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("该对象被绑定");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("该对象被取消绑定");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("活化");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("钝化");
	}

}
