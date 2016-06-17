package day23;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;



public class Demo5 {
	public static void main(String[] args) {
		ResourceBundle bundle=ResourceBundle.getBundle("message",Locale.US);
		String pattern = bundle.getString("login.error");
		System.out.println(pattern);
		
		String string = MessageFormat.format(pattern, "aaaaaaa","bb");
		System.out.println(string);
	}
	
	@Test
	public void fun1(){
		// At 12:30 pm on jul 3,1998, a hurricance destroyed 99 houses and caused $1000000 of damage
		String msg = "At {0,time,short} on {0,date,long}, a hurricance destroyed {1,number,integer} houses and caused {2,number,currency} of damage";
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(1998, 6, 3, 12, 30,0);
		
		Date date = new Date(calendar.getTimeInMillis());
		// String value=MessageFormat.format(msg, date,99,1000000);
		// System.out.println(value);
		MessageFormat mf = new MessageFormat(msg, Locale.US);
		String value = mf.format(new Object[] { date, 99, 1000000 });
		System.out.println(value);
	}
		
}
