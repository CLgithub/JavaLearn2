package day67webservice.demo2server;

import day67webservice.demo2server.stub.HelloServer;
import day67webservice.demo2server.stub.HelloServerService;

public class Client {
	public static void main(String[] args) {
		HelloServerService helloServerService = new HelloServerService();
		HelloServer helloServerPort = helloServerService.getHelloServerPort();
		String sayHello = helloServerPort.sayHello("中文");
		System.out.println(sayHello);
	}
}
