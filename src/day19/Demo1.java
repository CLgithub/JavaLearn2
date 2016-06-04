package day19;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;


/*
BeanUtils回顾与加强，前一次学习BeanUtils是在day1.Demo3
使用BenUtils组件：
	•	引入commons-beanutils.jar核心包
	•	引入日志支持包: commons-logging.jar

核心api：
	BeanUtils.copyProperty(user19, "userName", "jack");		属性的拷贝
	BeanUtils.setProperty(user19, "age", 23);
	
	BeanUtils.copyProperties(nUser19, user19);		对象的拷贝
	
	BeanUtils.populate(nUser19, map);			map拷贝到对象中
	
*/
public class Demo1 {
	//1.对javabean的基本操作
	@Test
	public void test1() throws Exception{
		User19 user19=new User19();
//		user19.setUserName("jack");
//		user19.setPassword("999");
		
		//基本数据类型拷贝到对象中
		BeanUtils.copyProperty(user19, "userName", "jack");//setProperty和copyProperty是一样的
		BeanUtils.setProperty(user19, "age", 23);		//实现原理就是反射
		System.out.println(user19);
		
		//对象拷贝
		User19 nUser19=new User19();
		BeanUtils.copyProperties(nUser19, user19);
		System.out.println(nUser19);
		
		//map数据拷贝到对象中，map中key要和javabean中的属性一致
		Map<String, Object> map=new HashMap<>();
		map.put("userName", "aaa");
		
		BeanUtils.populate(nUser19, map);
		System.out.println(nUser19);
	}
	
	@Test
	public void test2() throws Exception{
		//模拟表单提交数据
		String userName="bb";
		String age="20";
		String date1="1990-06-03";
		
		User19 user19=new User19();
		
		//注册一个日期类型转换器，1自定义的方式，如果是需要转换为Date.class类型的，就会使用该转换器转换
//		ConvertUtils.register(new Converter() {
//			@Override
//			public Object convert(Class type, Object value) {
//				//判断如果不是日期类型，就返回
//				if(type!=Date.class){
//					return null;
//				}
//				if(value==null||"".equals(value.toString().trim())){
//					return null;
//				}
//				//把字符串转换成日期
//				SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd");
//				try {
//					return sFormat.parse(value.toString());
//				} catch (ParseException e) {
//					throw new RuntimeException(e);
//				}
//			}
//		}, Date.class);
		
		//注册一个日期类型转换器,2使用组件提供的日期类型转换器工具类
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		//把表单提交数据封装到对象中
		BeanUtils.copyProperty(user19, "userName", userName);
		BeanUtils.copyProperty(user19, "age", age);
		BeanUtils.copyProperty(user19, "date1", date1);
		
		System.out.println(user19);
	}
}


