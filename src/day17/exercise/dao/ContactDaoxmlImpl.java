package day17.exercise.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import day17.exercise.entity.Contact17;


public class ContactDaoxmlImpl implements ContactDao{
	static File xml;
	static Document document;
	
	static{
		String string = ContactDaoxmlImpl.class.getResource("").toString();
//		xml=new File("/Users/L/Downloads/aaa/ContactDB.xml");
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

	@Override
	public List<Contact17> findAll() {
		List<Node> contacts = document.selectNodes("/contactList/contact");
		List<Contact17> list=new LinkedList<>();
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		for(Node c:contacts){
			Contact17 contact = new Contact17();
			Element element=(Element) c;
			contact.setId(Integer.valueOf(element.attributeValue("id")));
			contact.setName(element.elementText("name"));
			String age = element.elementText("age");
			if("".equals(age)){
				contact.setAge(null);
			}else{
				contact.setAge(Integer.valueOf(element.elementText("age")));
			}
			contact.setPhone(element.elementText("phone"));
			contact.setEmail(element.elementText("email"));
			String dataTest = element.elementText("dateTest");
			if("".equals(dataTest)){
				contact.setDateTest(null);
			}else{
				try {
					contact.setDateTest(sDateFormat.parse(dataTest));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			list.add(contact);
		}
		return list;
	}

	@Override
	public void addOrUpdate(Contact17 contact) {
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Integer contactId = contact.getId();
		if(contactId==null||contactId==0){	//新增
			Integer id=1;
			List<Node> contacts = document.selectNodes("/contactList/contact");
			if(contacts.size()!=0){
				Element elementC = (Element) contacts.get(contacts.size()-1);
				id=1+Integer.parseInt(elementC.attributeValue("id"));
			}
			Element contactE = document.getRootElement().addElement("contact");
			contactE.addAttribute("id", id.toString());
			contactE.addElement("name").setText(contact.getName());
			Integer age = contact.getAge();
			if(null==age){
				contactE.addElement("age").setText("");
			}else {
				contactE.addElement("age").setText(age.toString());
			}
			contactE.addElement("phone").setText(contact.getPhone());
			contactE.addElement("email").setText(contact.getEmail());
			Date dateTest = contact.getDateTest();
			if(dateTest==null){
				contactE.addElement("dateTest").setText("");
			}else {
				contactE.addElement("dateTest").setText(sDateFormat.format(dateTest));
			}
		}else {
			Node selectSingleNode = document.selectSingleNode("//contact[@id='"+contactId+"']");
			Element contactE = (Element)selectSingleNode ;
			contactE.attributeValue("id", contactId+"");
			contactE.element("name").setText(contact.getName());
			Integer age = contact.getAge();
			if(null==age){
				contactE.element("age").setText("");
			}else {
				contactE.element("age").setText(age.toString());
			}
			contactE.element("phone").setText(contact.getPhone());
			contactE.element("email").setText(contact.getEmail());
			Date dateTest = contact.getDateTest();
			if(dateTest==null){
				contactE.element("dateTest").setText("");
			}else {
				contactE.element("dateTest").setText(sDateFormat.format(dateTest));
			}
			
		}
		saveXML(xml, document);
	}

	@Override
	public Contact17 findById(String id) {
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Node selectSingleNode = document.selectSingleNode("//contact[@id='"+id+"']");
		Element contactE = (Element)selectSingleNode ;
		Contact17 contact = new Contact17();
		contact.setId(Integer.valueOf(contactE.attributeValue("id")));
		contact.setName(contactE.elementText("name"));
		String age = contactE.elementText("age");
		if("".equals(age)){
			contact.setAge(null);
		}else{
			contact.setAge(Integer.valueOf(contactE.elementText("age")));
		}
		contact.setPhone(contactE.elementText("phone"));
		contact.setEmail(contactE.elementText("email"));
		String dataTest = contactE.elementText("dateTest");
		if("".equals(dataTest)){
			contact.setDateTest(null);
		}else {
			try {
				contact.setDateTest(sDateFormat.parse(dataTest));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return contact;
	}

	@Override
	public void deleteC(String id) {
		Node selectSingleNode = document.selectSingleNode("//contact[@id='"+id+"']");
		Element contactE = (Element)selectSingleNode ;
		contactE.detach();
		saveXML(xml, document);
	}
	

	

}
