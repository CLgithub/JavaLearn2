package day67webservice.demo2server;

import javax.xml.ws.Endpoint;

public class ServerPublic {
	public static void main(String[] args) {
		//jdk 发布webservice服务，第一个参数服务地址，第二个参数具体服务器类
		Endpoint.publish("http://127.0.0.1:8092/hello", new HelloServer());
	}
}
