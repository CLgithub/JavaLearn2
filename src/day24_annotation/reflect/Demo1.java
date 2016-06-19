package day24_annotation.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Test;

/*
 * 反射加强
 */
public class Demo1 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
	}
	
	@Test
	public void fun1() throws Exception{
		Method method = this.getClass().getDeclaredMethod("main", String[].class);
		//此处将数组转换成object，原因：开源码 public Object invoke(Object obj, Object... args)
		//如果不转换成object，会误认为数组是多个参数
		method.invoke(this, (Object)(new String[]{"abc","fds",""}));	
	}
}
