package day1;

import java.util.Collection;

/*
 
 泛型的好处：
  		1.将运行时的异常提前至了编译时
  		2.避免了无谓的强制类型转换
  	
 范型方法
 自定义泛型：自定义泛型就是一个数据类型的占位符T或者是 一个数据类型的变量T,T可以是String、Integer等
 方法上自定义泛型格式：
		修饰符 <声明自定义的泛型>返回值类型 函数名(使用自定义泛型...){
		}
 方法泛型注意的事项：
		1.在方法上自定义泛型，这个自定义泛型的具体数据类型是在调用该方法的时候传入实参时确定的
		2.自定义泛型只要符合标识符的命名即可。但是我们一般都习惯使用一个大写字母表示。T Type E Element
		
 泛型类：
	泛型类的定义格式：
	class 类名<声明自定义泛型>{
	}
	泛型类要注意的事项：
		1.在类上自定义泛型的具体数据类型是在使用该类创建对象的时候确定的
		2.如果一个类在类上已经声明了自定义泛型，如果使用该类型创建对象的时候没有指定具体泛型类型，默认为object
		3.在类上自定义的泛型不能作用于静态的方法，如果静态的方法需要使用自定义泛型，那么需要自己声明
		
 泛型接口
	泛型接口的定义格式：
	interface 接口名<声明自定义泛型>{
	}
 	泛型接口要注意的问题：
		1.接口上自定义的泛型的具体数据类型是在实现接口的时候指定的
		2.接口上自定义的泛型，在实现接口时如果不指定具体数据类型，默认为Object类型
  		
泛型的上下限：
	需求：定义一个函数可以接受任意类型的集合对象，要求集合对象只能吃醋integer或integer的父类类型数据
	泛型中的通配符：? super Integer
	需求2：定义一个函数可以接受任意类型的集合对象，要求集合对象只能吃醋Number或Number的子类类型数据
  		
*/
public class MyDemo2 {
	public static void main(String[] args) {
		String aString=method1("aa");
		Integer integer=method1(1);
	}
	
	public static <T>T method1(T t) {
		Class<? extends Object> clazz=t.getClass();
		System.out.println(clazz.getName());
		return t;
	}
	
	
	//Collection里面的数据类型是泛型，该泛型是Integer或Integer的父类类型，下限
	public static void method1(Collection<? super Integer> c){}
	//Collection里面的数据类型是泛型，该泛型继承Number，是Number或Number的子类类型，上限
	public static void method2(Collection<? extends Number> c){}
}

class MyList<T>{
	Object[] arr=new Object[10];
	int inxex=0;
	public MyList() {
	}
	
	public void add(T t) {
		arr[inxex++]=t;
	}
}

