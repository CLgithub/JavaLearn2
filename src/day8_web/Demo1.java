package day8_web;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/*

Web开发入门
	3.1 引入
		之前的程序： java桌面程序，控制台控制，socket gui界面。javase规范
		现在和以后的程序：java web程序。浏览器控制。javaee规范

	3.2 软件的结构
		C/S (Client - Server  客户端-服务器端)
			典型应用：QQ软件 ，飞秋，红蜘蛛。
			特点：
				1）必须下载特定的客户端程序。
				2）服务器端升级，客户端升级。
		B/S （Broswer -Server 浏览器端- 服务器端）
			典型应用： 腾讯官方（www.qq.com）  163新闻网站， 传智官网（俗称：网站）
			特点：
				1）不需要安装特定的客户端（只需要安装浏览器即可！！）
				2）服务器端升级，浏览器不需要升级！！！！
		javaweb的程序就是b/s软件结构！！！
		
	3.3 服务器
		从物理上来说，服务器就是一台PC机器。8核，8G以上，T来计算，带宽100M
		web服务器：PC机器安装一个具有web服务的软件，称之为web服务器
		数据库服务器：PC机器安装一个具有数据管理件服务的软件，称之为数据库服务器。
		邮件服务器：PC机器安装一个具有发送邮件服务的软件，称之为邮件服务器。
		
	3.4 web服务软件
		web服务软件的作用：把本地的资源共享给外部访问。
		
	3.5 常见的市面上web服务软件
		WebLogic: BEA公司的产品。 收费的。支持JavaEE规范。(13种技术)
		WebSphere： IBM公司的产品。收费的。支持JavaEE规范
		JBoss: Redhat公司的产品。收费的。支持JavaEE规范
		Tomcat： 开源组织Apache的产品。免费的。支持部分的JavaEE规范。（servlet、jsp。jdbc，但ejb， rmi不支持）
			javase的规范,包含IO流，线程，集合，socket编程。。。。
*/
public class Demo1 {
	public static void main(String[] args) throws IOException {
		//1.创建服务器端socket
		ServerSocket serverSocket=new ServerSocket(8090);
		//2.监听 得到socket，
		Socket accept = serverSocket.accept();
		//3.发送数据
		FileInputStream fis=new FileInputStream("/Users/L/Downloads/aaa/bbb.html");
		OutputStream outputStream = accept.getOutputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=fis.read(buf))!=-1){
//			System.out.println(new String(buf, 0, len));
			outputStream.write(buf, 0, len);
		}
		//关闭资源
		fis.close();
		outputStream.close();
	}
}

class Server{
	
}
