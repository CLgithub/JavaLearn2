package day23;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

public class Demo4 {
	//数值
	@Test
	public void fun1(){
		NumberFormat nFormat=NumberFormat.getIntegerInstance();
		String s=nFormat.format(19.26564);
		System.out.println(s);
	}
	
	//百分比
	@Test
	public void fun2(){
		NumberFormat nFormat=NumberFormat.getPercentInstance(Locale.FRANCE);
		String s=nFormat.format(0.98);
		System.out.println(s);
	}
	
	//货币
	@Test
	public void fun3(){
		NumberFormat nFormat=NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nFormat.format(1090));
	}
	
}
