package day1.junit;

import java.io.FileInputStream;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Demo2 {
	
	//准备测试的环境
//	@Before
	@BeforeClass
	public static void beforeResd() {
		System.out.println("准备测试环境完成");
	}
	
	//读取文件数据，把文件数据处理
	@Test
	public void readFile() throws IOException {
		FileInputStream fileInputStream=new FileInputStream("/Users/L/Downloads/aaa/userInfoDB.properties");
		int content=fileInputStream.read();
		System.out.println("内容："+content);
	}
	
	@Test
	public void sort() {
		System.out.println("读取文件数据排序。。");
	}
	
	//准备测试的环境
//	@After
	@AfterClass
	public static void afterResd() {
		System.out.println("清理测试环境完成");
	}
}
