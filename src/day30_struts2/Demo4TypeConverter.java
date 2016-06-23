package day30_struts2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class Demo4TypeConverter extends StrutsTypeConverter{

	//接收页面传递的数据，封装到javabean
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
//		System.out.println(context);	//ognl.OgnlContext@1f4243e1
//		System.out.println(Arrays.toString(values));		//[2016/06/23]
//		System.out.println(toClass);	//class java.util.Date
		//很奇怪的一个问题，再这方法里只能访问一次三个参数，不如就会不进来
		
		Date date=null;
		try {
			SimpleDateFormat sFormat=new SimpleDateFormat("yyyy/MM/dd");
			date = sFormat.parse(values[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	
	@Override
	public String convertToString(Map context, Object o) {
		return null;
	}

	
	

}

