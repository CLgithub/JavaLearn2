package day1.introspector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
 以后我们开发框架的时候，我们是经常需要把一些数据封装到对象中的
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		Object object=getInstance();
		System.out.println(object);
	}
	//需求：编写一个工厂方法根据配置文件返回对应的对象
	public static Object getInstance() throws Exception {
		BufferedReader bReader=new BufferedReader(new FileReader("info.txt"));
		
		//读取类名
		String className=bReader.readLine();
		//根据类名得到Class对象
		Class clazz=Class.forName(className);
		//用Class对象得到构造函数
		Constructor constructor=clazz.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		//用用构造函数创建对象
		Object object=constructor.newInstance(null);
		//读取其他参数，并符值
		String line="";
		while((line=bReader.readLine())!=null){
			String[] strs=line.split("=");
			Field field=clazz.getDeclaredField(strs[0]);
			field.setAccessible(true);
			if(field.getType().equals(int.class)){
				field.set(object, Integer.parseInt(strs[1]));
			}else {
				field.set(object, strs[1]);
			}
		}
		
		//执行该对象的最后一个方法
//		Method[] methods=clazz.getDeclaredMethods();
//		Method method=methods[methods.length-1];
//		System.out.println(method);
//		method.setAccessible(true);
//		method.invoke(object, 13);
		
		
		return object;
	}
}
