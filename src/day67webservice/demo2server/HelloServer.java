package day67webservice.demo2server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/*
编写webservice服务端
	编写一个类，添加注解@WebService指定将此类发布成一个webservice服务，并提供一个public方法，
	使用Endpoint类的静态方法Endpoint.publish("http://127.0.0.1:8092/hello", new HelloServer())发布服务
	访问http://127.0.0.1:8092/hello?wsdl	查看wsdl
	生成对应的客户端，测试访问
	
	
	
	

 */

@WebService
public class HelloServer {
	/**
	 * 1.需要方法必须是public
	 * 2.不能是final类型（因为在访问调用时，是用代理对象，没有实现接口，代理使用继承完成，所以）
	 * 3.方法不能是静态的
	 */
	public String sayHello(String name){
		return name+",hello!";
	}
	
	@WebMethod(exclude=true)	//使用这个注解排除发布该方法
	public String sayBye(String name){
		return name+",bye!";
	}
	
}
