package day24_annotation;

@MyAnnotation3(st="aa",i=10,i2={2,3,5},value="a")
@MyAnnotation4({"a","b"})
public class Demo3MyAnnotation {

}

@interface MyAnnotation3{
	String st();
	
	String st2() default "abc";	//有默认值使用时就不用赋值
	
	int i();
	
	int[] i2();
	
	String value();
}

@interface MyAnnotation4{
	
	String[] value();
	
}
