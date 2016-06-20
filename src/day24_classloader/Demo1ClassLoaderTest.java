package day24_classloader;

import java.net.URL;
import org.junit.Test;
import sun.misc.Launcher;
import sun.misc.URLClassPath;
import sun.security.ec.CurveDB;

public class Demo1ClassLoaderTest {

	//引导类加载器
	@Test
	public void fun1(){
//		ClassLoader classLoader = String.class.getClassLoader();//String在rt.jar下
//		System.out.println(classLoader);
		
		URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
		URL[] urLs = bootstrapClassPath.getURLs();
		for(int i=0;i<urLs.length;i++){
			System.out.println(urLs[i].toExternalForm());
		}
	}
	
	//扩展类加载器
	@Test
	public void fun2(){
		ClassLoader classLoader = CurveDB.class.getClassLoader();
		System.out.println(classLoader);
	}
	
	//应用类加载器
	@Test
	public void fun3(){
		ClassLoader classLoader = this.getClass().getClassLoader();
		System.out.println(classLoader);
	}
}
