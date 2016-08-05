package day24_annotation;

import java.util.Date;

public class Demo1 implements A{

	@Override	//@Override就是一个注解
	public String toString() {
		return super.toString();
	}

	@Override	//jdk1.5只能描述继承中的重写
	public void show() {
	}

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date.toLocaleString());
		
		@SuppressWarnings("unused")
		int i=0;
	}
	
}
interface A{
	
	@Deprecated
	void show();
}
