package day1.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/*
 以后我们开发框架的时候，我们是经常需要把一些数据封装到对象中的
 
 内省----->一个变态的反射。
 Introspector(自我反省)
 
 内省主要解决的问题：把对象的属性数据封装到对象中
 
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		testProperty();
//		getAllProperty();
	}
	
	public static void getAllProperty() throws Exception {
		//Introspector	内省类
		BeanInfo beanInfo=Introspector.getBeanInfo(Person.class);
		//通过beaninfo获取所有的属性描述
		PropertyDescriptor[] descriptors=beanInfo.getPropertyDescriptors();	//获取一个类中的所有属性描述器
		for(PropertyDescriptor propertyDescriptor:descriptors){
			System.out.println(propertyDescriptor.getReadMethod());
		}
		
		
	}
	
	public static void testProperty() throws Exception {
		Person p=new Person();
		//属性描述器
		PropertyDescriptor descriptor=new PropertyDescriptor("id", Person.class);
		//获取属性对应到get或set方法获得或者设置属性了
		Method mSet=descriptor.getWriteMethod();	//mSet其实就是setId方法
		//执行该方法,设置属性值
		mSet.invoke(p, 2);
		
		Method mGet=descriptor.getReadMethod();		//mGet其实就是getId方法
		System.out.println(mGet.invoke(p, null));
		
		System.out.println(p);
		
	}
}
