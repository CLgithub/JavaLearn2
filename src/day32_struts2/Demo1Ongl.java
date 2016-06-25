package day32_struts2;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Demo1Ongl {
	public static void main(String[] args) throws OgnlException {
//		method1();
//		method2();
		method3();
	}
	
	public static void method1() throws OgnlException{
//		System.out.println("aaa".length());
		//使用ognl来完成上面操作
		//1.创建一个ognl上下文对象
		OgnlContext oContext=new OgnlContext();
		
		Object object = Ognl.getValue("'aaa'.length()", oContext.getRoot());
		System.out.println(object);
	}
	
	public static void method2() throws OgnlException{
//		System.out.println(Math.max(10, 20));
//		System.out.println(Math.PI);
		//使用ognl来完成上面操作
		OgnlContext oContext=new OgnlContext();
		Object object = Ognl.getValue("@java.lang.Math@max(10,20)", oContext.getRoot());
		Object object2 = Ognl.getValue("@java.lang.Math@PI", oContext.getRoot());
		
		System.out.println(object);
		System.out.println(object2);
	}
	
	public static void method3() throws OgnlException {
		//创建一个ognl上下文对象
		OgnlContext oContext=new OgnlContext();	//本质上就是一个map集合
		Person p1 = new Person("小新");
		p1.setMyDog(new Dog("小白"));
		oContext.setRoot(p1);
		
		Dog doudou = new Dog("豆豆");
		doudou.setMyPerson(new Person("小明"));
		oContext.put("doudou",doudou );

		//获取root数据
		Object object1 = Ognl.getValue("#root", oContext,oContext.getRoot());
		System.out.println(object1);
		//获取dog数据
		Object object2 = Ognl.getValue("#doudou", oContext,oContext.getRoot());
		System.out.println(object2);
		
		//获取小新的🐶的名字
		Object object3 = Ognl.getValue("#root.myDog.name", oContext,oContext.getRoot());
		System.out.println(object3);
		//使用ognl获取根中的数据	获取根中数据，不需要加#（其实是"#root"可以省略不写）
		Object object5 = Ognl.getValue("myDog.name", oContext,oContext.getRoot());
		System.out.println(object5);
		
		//获取豆豆的主人的名字
		Object object4 = Ognl.getValue("#doudou.myPerson.name", oContext,oContext.getRoot());
		System.out.println(object4);
		//使用ognl来获取非根中的数据		获取非根中数据，需要加#（非"#root"不能省略）
		Object object6=Ognl.getValue("#doudou.myPerson.name", oContext,oContext.getRoot());
		System.out.println(object6);
		
	}
}


