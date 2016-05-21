package day10_servlet_exercise;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import day7_sax.Contact;

public class Dao {
	static File xml;
	static Document document;

	static{
		String string = Dao.class.getResource("").toString();
		xml=new File("D:/ContactDB.xml");
		try {
			if (!xml.exists()) {
				document = DocumentHelper.createDocument();
				document.addElement("contactList");
				saveXML(xml, document);
			} else {
				document = new SAXReader().read(xml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void saveXML(File xml2, Document document2)  {
		try {
			OutputFormat format=OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(xml),format);
			xmlWriter.write(document);
			xmlWriter.close();
			System.out.println("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询所有
	public static List<Contact> findAll(){
		List<Node> contacts = document.selectNodes("/contactList/contact");
		List<Contact> list=new LinkedList<>();
		for(Node c:contacts){
			Contact contact = new Contact();
			Element element=(Element) c;
			contact.setId(element.attributeValue("id"));
			contact.setName(element.elementText("name"));
			contact.setAge(element.elementText("age"));
			contact.setPhone(element.elementText("phone"));
			contact.setEmail(element.elementText("email"));
			contact.setQq(element.elementText("qq"));
			list.add(contact);
		}
		return list;
	}

	//新增或修改
	public static void addOrUpdate(Contact contact) {
		String contactId = contact.getId();
		if(contactId==null){	//新增
			Integer id=1;
			List<Node> contacts = document.selectNodes("/contactList/contact");
			if(contacts.size()!=0){
				Element elementC = (Element) contacts.get(contacts.size()-1);
				id=1+Integer.parseInt(elementC.attributeValue("id"));
			}
			Element contactE = document.getRootElement().addElement("contact");
			contactE.addAttribute("id", id.toString());
			contactE.addElement("name").setText(contact.getName());
			contactE.addElement("age").setText(contact.getAge());
			contactE.addElement("phone").setText(contact.getPhone());
			contactE.addElement("email").setText(contact.getEmail());
			contactE.addElement("qq").setText(contact.getQq());
		}else {
			Node selectSingleNode = document.selectSingleNode("//contact[@id='"+contactId+"']");
			Element contactE = (Element)selectSingleNode ;
			contactE.attributeValue("id", contactId);
			contactE.element("name").setText(contact.getName());
			contactE.element("age").setText(contact.getAge());
			contactE.element("phone").setText(contact.getPhone());
			contactE.element("email").setText(contact.getEmail());
			contactE.element("qq").setText(contact.getQq());
		}
		saveXML(xml, document);
	}

	public static Contact findById(String id) {
//		Element rootElement = document.getRootElement();
//		Node selectSingleNode = rootElement.selectSingleNode("/contact[@id='"+id+"']");
		Node selectSingleNode = document.selectSingleNode("//contact[@id='"+id+"']");
		Element contactE = (Element)selectSingleNode ;
		Contact contact = new Contact();
		contact.setId(contactE.attributeValue("id"));
		contact.setName(contactE.elementText("name"));
		contact.setAge(contactE.elementText("age"));
		contact.setPhone(contactE.elementText("phone"));
		contact.setEmail(contactE.elementText("email"));
		contact.setQq(contactE.elementText("qq"));
		return contact;
	}

	//删除自定id的联系人
	public static void deleteC(String id) {
		Node selectSingleNode = document.selectSingleNode("//contact[@id='"+id+"']");
		Element contactE = (Element)selectSingleNode ;
		contactE.detach();
		saveXML(xml, document);
	}

}
