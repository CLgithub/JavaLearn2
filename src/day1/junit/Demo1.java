package day1.junit;

import java.util.Arrays;

import org.junit.Test;

/*
 junit（单元测试框架）
 目前存在的问题：
 	1.目前的方法如果需要测试，都需要用mian方法调用
 	2.目前都结果都需要人工对比
 	
 junit要注意的细节：
 	1.如果使用junit测试一个方法的时候，如果在junit窗口上显示绿条，那么代表测试通过，红条代表不通过
 	2.如果点击方法名，类名，包名，工程名运行junit分别测试的是对应的junit
 	3.@Test方法不能是静态,也不能带有型参
 	4. 如果测试一个方法的时候需要准备测试的环境或者是清理测试的环境，那么可以@Before、 @After 、@BeforeClass、 @AfterClass这四个注解。
		@Before、 @After 是在每个测试方法测试的时候都会调用一次， @BeforeClass、 @AfterClass是在所有的测试方法测试之前与测试之后调用一次而已。
 
 junit使用规范
 	1.一个类如果需要测试，那么该类就应该对应者一个测试类，测试类的命名规范，被测试的类名＋Test
 	2.一个方法如果需要测试，那么该方法应该对应着一个测试方法，测试方法的命名规范，test＋被测试的方法名
 	
 */
public class Demo1 {
	public static void main(String[] args) {
//		new Demo1().sort();;
	}
	
	@Test	//注解
	public void sort() {
		int[] arr={1,54,16,23};
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					arr[j]=arr[j]^arr[j+1];
					arr[j+1]=arr[j]^arr[j+1];
					arr[j]=arr[j]^arr[j+1];
				}
			}
		}
		System.out.println(Arrays.toString(arr));
//		throw new RuntimeException();
	}
	
	
	@Test
	public static void getMax(int a,int b) {
//		int a=3;
//		int b=5;
		int max=a>b?a:b;
		System.out.println(max);
	}
}
