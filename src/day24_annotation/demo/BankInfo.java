package day24_annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)	//该注解在方法上使用
@Retention(value=RetentionPolicy.RUNTIME)	//运行时，可反射
public @interface BankInfo {
	int maxMoney();
}
