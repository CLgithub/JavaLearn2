package day1.junit;

import org.junit.Assert;
import org.junit.Test;


//Tool的测试类
public class ToolTest {
	
	@Test
	public void testGetMax() {
		int max=Tool.getMax(5, 10);
		//断言
//		Assert.assertSame(10, max);// expected：期望 actual：真实		相当于==
//		Assert.assertSame(new String("abc"), "abc");	//底层是==
//		Assert.assertEquals(new String("abc"), "abc");	//底层使用equals方法
//		Assert.assertNull(null);
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void testGetMin() {
		int min=Tool.getMin(5,8);
		Assert.assertSame(5, min);
	}
}
