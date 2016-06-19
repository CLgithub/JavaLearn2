package day24_annotation;

//@MyAnnotaton1		//自定义注解
public class Demo2MyAnnotation {

}

@interface MyAnnotaton1{
	//基本类型
	int i();	
	char c();
	boolean b();
	
	//String类型
	String s();
	
	//Class类型
	Class class1();
	
	//枚举类型
	E1 e();
	
	//注解类型
	MyAnnotaton2 myAnnota();
	
	//以上类型的一维数组
	Class[] class2();
	String[] str();
	
}

@interface MyAnnotaton2{
	
}

enum E1{
	A,B;
}