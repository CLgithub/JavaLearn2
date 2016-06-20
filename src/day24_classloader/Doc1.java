package day24_classloader;

import java.net.URL;

import sun.misc.Launcher;
import sun.misc.URLClassPath;
import sun.security.ec.CurveDB;

/*
类加载器
	问题：什么是类加载器，有什么作用？
		类加载器的作用就是将java中的字节码文件（.class）文件转化成Class对象
		
	当 JVM 启动时，会形成由三个类加载器组成的初始类加载器层次结构：
		1.引导类加载器  BootStrap	加载jre/lib/rt.jar
		2.扩展类加载器  ExtClassLoader		加载JRE/lib/ext/*.jar
		3.应用类加载器（系统类加载器）	AppClassLoader SystemClassLoader CLASSPATH指定的所有jar或目录
		
		在java中ClassLoader代表类加载器，使用的类加载器都是ClassLoader的子类，但是BootStrap特殊，它不是不是java实现
		
	演示类加载器：
		类加载器如何获取
		Class.getClassLoader()
		
		1.获取引导类加载器
			ClassLoader classLoader = String.class.getClassLoader();//String在rt.jar下
			System.out.println(classLoader);
			结果null
			原因:引导(也称为原始)类加载器,它负责加载Java的核⼼心类。这个加载器的是⾮常特殊的,
				它实际上不是 java.lang.ClassLoader的⼦子 类,⽽而是由JVM⾃自⾝身实现的。
				可以通过执⾏行以下代码 来获得bootstrap classloader加载了那些核⼼心类库
					URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
					URL[] urLs = bootstrapClassPath.getURLs();
					for(int i=0;i<urLs.length;i++){
						System.out.println(urLs[i].toExternalForm());
					}
				因为JVM在启动的时候就自动加载它们,所以不需要在系统属性CLASSPATH中指定这些类库,(即使用基础类库的时候不需要import)
		2.扩展类加载器
			ClassLoader classLoader = CurveDB.class.getClassLoader();
			System.out.println(classLoader);
			//sun.misc.Launcher$ExtClassLoader@eed1f14

		3.应用类加载器（系统类加载器）
			ClassLoader classLoader = this.getClass().getClassLoader();
			System.out.println(classLoader);
			//sun.misc.Launcher$AppClassLoader@63961c42

－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	全盘负责 委托机制
		全盘负责:即是当一个classloader加载一个Class的时候,这个Class所依赖的和引⽤用的其它Class通常也
			由这个classloader负责载⼊
		委托机制:先让parent(父)类加载器寻找,只有 在parent找不到的时候才从自己的类路径中去寻找
		类加载还采⽤用了cache机制:如果 cache中保存了这 个Class就直接返回它,如果没有才从⽂文件中读取和转
			换成Class,并存入cache,这就是为什么修改了Class但是必须重新启动JVM才能生效,并且类只加载一次的原因
		
			
*/
public class Doc1 {

}
