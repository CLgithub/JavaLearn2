package day23;


import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class Demo4_test {
	//创建一个date对象，把date对象中表示日期部分的时间值，已经表示时间部分的时间值
	//分部以short，long模式进行格式化输出（国家设置为中国）
	@Test
	public void fun1(){
		Date date=new Date();
		DateFormat dFormat=DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.LONG);
		System.out.println(dFormat.format(date));
	}
	
	//将时间值09-11-28 上午10时25分39秒CST，转换成date对象
	@Test
	public void fun2() throws ParseException{
		String str = "09-11-28 上午10时25分39秒CST";
		DateFormat dFormat = DateFormat.getDateTimeInstance
					(DateFormat.SHORT, DateFormat.LONG);
		Date date = dFormat.parse(str);
		System.out.println(date);
	}
	//将整数198，输出为货币形式：$198，并且将￥58反向输出成198
	@Test
	public void fun3() throws ParseException{
		int i=198;
		NumberFormat nFormat=NumberFormat.getCurrencyInstance(Locale.US);
		nFormat.setMaximumFractionDigits(0);//设置小数
		String string = nFormat.format(i);
		System.out.println(string);
		
		String str2="￥58";
		NumberFormat nFormat2=NumberFormat.getCurrencyInstance(Locale.JAPAN);
		Number number = nFormat2.parse(str2);
		System.out.println(number.intValue());
	}
	//将0.78943432，输出百分比个数，保留两位小数
	@Test
	public void fun4(){
		double d=0.78943432;
		NumberFormat nFormat=NumberFormat.getPercentInstance();
		nFormat.setMinimumFractionDigits(2);	//保留两位小数
		System.out.println(nFormat.format(d));
	}
}
