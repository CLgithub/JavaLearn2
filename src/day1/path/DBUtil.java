package day1.path;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.xml.sax.InputSource;

/*
 如果经常会发生变化的数据我们可以定义在配置文件上，比如说：数据库的用户名与密码
 
 配置文件的路径应该如何写呢？
 	绝对路径：一个文件的完整路径，做不到通用。不安全，不建议
 	
 	相对路径：相对与当前程序的路径,当前路径就是执行java命令的时候，客户端所在的路径（pwd），不安全
 	
 	类文件路径：类文件路径就是使用了classpath的路径去找对应的资源文件
 		如果需要类文件路径，首先先要获取到一个class对象
 	
 	 
 
 */
public class DBUtil {
	static Properties properties;
	static{
		try {
			properties=new Properties();
			//去加载配置文件
			Class<?> clazz=DBUtil.class;
			InputStream iSource=clazz.getResourceAsStream("/db.properties");	// "/"代表了classpath的路径			getResourceAsStream该方法里面是用到路径就是类文件路径
			properties.load(iSource);
//			properties.load(new FileReader("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("当前路径："+new File(".").getAbsolutePath());
		System.out.println("当前路径："+System.getProperty("user.dir"));
		System.out.println("用户名："+properties.getProperty("userName")+",密码："+properties.getProperty("password"));
	}
}
