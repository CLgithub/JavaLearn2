package day24_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@MyAnnotation3(st="aa",i=10,i2={2,3,5},value="a")
@MyAnnotation4({"a","b"})
@MyAnnotation5
public class Demo3MyAnnotation {

}

@interface MyAnnotation3{
	String st();
	
	String st2() default "abc";	//有默认值使用时就不用赋值
	
	int i();
	
	int[] i2();
	
	String value();
}
@MyAnnotation5
@interface MyAnnotation4{
	
	String[] value();
	
}

@Target(value=ElementType.TYPE)	//表示MyAnnotation5注解只能在类类或接口上使用
@Retention(RetentionPolicy.RUNTIME)//表示MyAnnotation5注解	jvm加载完成后，还存在。开发人员可以通过反射来获取注解相关信息.
@interface MyAnnotation5{
	String st1() default "abc";
}
