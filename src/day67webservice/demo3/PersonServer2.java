package day67webservice.demo3;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

//通过配置这个注解的属性，修改wsdl文档的标签属性名
@WebService(
		serviceName="serviceName1",	
		portName="portName1",
		name="typeName1",		//typeName
		targetNamespace="person.cl"		//修改targetNamespace="http://demo3.day67webservice/"
)
public class PersonServer2 {

	List<Person> plist = new ArrayList<>();

	//添加
	public void addPersion(Person person) {
		plist.add(person);
	}
	
	@WebResult(name="PersonAllReturn")
	public List<Person> getPersonAll(){
		return plist;
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:8092/person", new PersonServer());
	}
}
