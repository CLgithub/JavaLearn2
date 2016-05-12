package day8_web;

/*
4 Tomcat基本使用
	4.1 下载并按照
	1）到apache官网。www.apache.org     http://jakarta.apache.org(产品的主页)
	2）
		安装版：window （exe、msi） linux（rmp）
		压缩版：window（rar，zip） linux（tar，tar.gz）学习时候使用
	3）运行和关闭tomcat
		3.1 启动软件
			a）找到%tomcat%/bin/startup.bat ，双击这个文件
			b）弹出窗口，显示信息（不要关闭次窗口）
			c）打开浏览器，输出以下地址
				http://localhost:8080
			d）看到一只猫画面，证明软件启动成功！

		3.3 关闭软件
			a）找到%tomcat%/bin/shutdown.bat，双击这个文件即可！
			c）打开浏览器，输出以下地址。看到“无法连接”（最好先清空浏览器缓存）
			
		4.2 tomcat软件使用的常见问题
			1）闪退问题
			原因：tomcat软件是java语言开发的。 tomcat软件启动时，会默认到系统的环境变量中查找一个名称叫JAVA_HOME的变量。这个变量的作用找到tomcat启动所需的jvm。
			解决办法； 到环境变量中设置JAVA_HOME的变量
				JAVA_HOME= C:\Program Files\Java\jdk1.6.0_30  (注意别配置到bin目录下)
					
			2）端口占用的错误
			原因： tomcat启动所需的端口被其他软件占用了！
			解决办法： 
				a）关闭其他软件程序，释放所需端口
				b）修改tomcat软件所需端口
			       找到并修改%tomcat%/conf/server.xml文件
						
		  <Connector port="8081" protocol="HTTP/1.1" 
		               connectionTimeout="20000" 
		               redirectPort="8443" />

			3）CATALINA环境变量问题
			原因： tomcat软件启动后，除了查找JAVA_HOME后，还会再查找一个叫CATALINA_HOME变量，这个变量的作用是设置tomcat的根目录。
			解决办法：建议不要设置CATALINA_HOME变量。检查如果有的话，清除掉！！！
			
		4.3 体验tomcat软件作用
				webapps目录： tomcat共享目录。需要共享的本地资源放到此目录中。
				
		4.4 URL
			URL全名叫统一资源定位符，用于定位互联网的资源。
			问题： http://localhost:8081/myweb/test.html  看到文件？
			http://     协议。http协议。
			localhost    域名。为了找到IP地址。
							本地域名： localhost
							外部域名：www.baidu.com
			8081       端口。软件监听的
						8080： tomcat默认的端口
						3306：mysql数据库的端口
						1521： orace数据库的端口。
			/myweb:   web应用的名称。默认情况下，在webapps目录下找
			/test.html  ： 资源名称。
*/
public class Demo2 {

}
