package day1.introspector;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

/*
 BeanUtils
 BeanUtils主要解决的问题:把对象的属性数据封装到对象中
 
 BeanUtils的好处：
 	1.BeanUtils设置属性值的时候，如果属性类型是基本数据类型，那么BeanUtils会自动更我们转换数据类型
 	2.BeanUtils设置属性的时候，底层是依赖于get或set方法来获取或设置属性值的
 	3.BeanUtils设置属性的时候，如果设置的属性是其他的引用类型数据，那么这时候必须要注册一个类型转换器
 
 BeanUtils的使用步骤：
 	1.导包。commons-beanutils-1.8.0.jar，commons-logging.jar
 	
 */

public class Demo3 {
	public static void main(String[] args) throws Exception {
		//从文件中读取到的数据都是字符串的数据，或者表单提交的数据也是字符串的数据
		String id="110";
		String name="小明";
		String salary="1000";
		String birthday="2013-05-16";
		
		//注册一个类型转换器
		ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class type, Object value) {//type：目前遇到的数据类型，value：目前参数的值
				Date date=null;
				try {
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
					date = simpleDateFormat.parse((String)value);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return date;
			}
		}, Date.class);
		
		
		Emp emp=new Emp();
		BeanUtils.setProperty(emp, "id", id);
		BeanUtils.setProperty(emp, "name", name);
		BeanUtils.setProperty(emp, "salary", salary);
		BeanUtils.setProperty(emp, "birthday", birthday);
		
		System.out.println(emp);
		
		
	}
}
