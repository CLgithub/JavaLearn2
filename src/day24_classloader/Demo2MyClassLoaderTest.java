package day24_classloader;

import javax.activation.MimeType;

public class Demo2MyClassLoaderTest {
	public static void main(String[] args) throws Exception {
//		MimeType mt=new MimeType();
//		ClassLoader classLoader = mt.getClass().getClassLoader();
//		System.out.println(classLoader);
		
//		mt.show();//Exception in thread "main" java.lang.NoSuchMethodError
		
		
		//使用自定义类加载器
		String rootDir = Demo1ClassLoaderTest.class.getResource("/").getPath();
		System.out.println(rootDir);
		Demo2MyClassLoader mcl=new Demo2MyClassLoader(rootDir);
		Class<?> clazz = mcl.findClass("javax.activation.MimeType");
		
		//会出错，因为有缓存
//		MimeType mt = (MimeType) clazz.newInstance();
//		mt.show();
		
		clazz.getDeclaredMethod("show").invoke(clazz.newInstance());
	}
}
