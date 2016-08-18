package day67webservice.demo3;

import java.util.List;
import day67webservice.demo3.stub.Person;
import day67webservice.demo3.stub.PersonServer;
import day67webservice.demo3.stub.PersonServerService;

public class ClientPerson {
	public static void main(String[] args) throws Exception {
		//创建服务访问点集合
		PersonServerService personServerService=new PersonServerService();
		//根据服务器点集合的到绑定类
		PersonServer personServer = personServerService.getPersonServerPort();
		//调用具体业务方法
		Person person = new Person();
		person.setName("小张");
		personServer.addPersion(person);
		
		Person person2 = new Person();
		person2.setName("小强");
		personServer.addPersion(person2);
		
		List<Person> personAll = personServer.getPersonAll();
		System.out.println(personAll);
	}
}
