package day67webservice.demo3;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class PersonServer {

	List<Person> plist = new ArrayList<>();

	//添加
	public void addPersion(Person person) {
		plist.add(person);
	}
	
	public List<Person> getPersonAll(){
		return plist;
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:8092/person", new PersonServer());
	}
}
