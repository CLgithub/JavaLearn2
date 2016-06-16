package day23;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class Demo3 {
	
	//无参构造
	@Test
	public void fun1(){
		Date date=new Date();
		DateFormat df1=DateFormat.getDateInstance();		//只有年月日
		DateFormat df2=DateFormat.getTimeInstance();		//只有时间
		DateFormat df3=DateFormat.getDateTimeInstance();	//既有日期又有时间
		System.out.println(df1.format(date));
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
	}
	
	//有参构造，指定样式
	@Test
	public void fun2(){
		Date date=new Date();
		DateFormat df1=DateFormat.getDateInstance(DateFormat.FULL);							//只有年月日
		DateFormat df2=DateFormat.getTimeInstance(DateFormat.MEDIUM);						//只有时间
		DateFormat df3=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM);	//既有日期又有时间
		System.out.println(df1.format(date));
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
	}
	
	//国际化的格式
	@Test
	public void fun3(){
		Date date=new Date();
		DateFormat df1=DateFormat.getDateInstance(DateFormat.FULL,Locale.US);						//只有年月日
		DateFormat df2=DateFormat.getTimeInstance(DateFormat.MEDIUM,Locale.US);						//只有时间
		DateFormat df3=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM,Locale.US);	//既有日期又有时间
		System.out.println(df1.format(date));
		System.out.println(df2.format(date));
		System.out.println(df3.format(date));
	}
	
	//关于parse方法，反向解析
	@Test
	public void fun4() throws ParseException{
		DateFormat dFormat=DateFormat.getDateTimeInstance();
		Date date=new Date();
		System.out.println(dFormat.format(date));

		Date date2=dFormat.parse("2015-09-05 11:40:29");
		System.out.println(date2);
//		SimpleDateFormat
	}
	
	
}
