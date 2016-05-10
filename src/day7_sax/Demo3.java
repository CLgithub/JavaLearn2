package day7_sax;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
	读取xml信息封装到对象
*/
public class Demo3 {
	public static void main(String[] args) throws Exception {
		SAXParser saxParser=SAXParserFactory.newInstance().newSAXParser();
		List<Contact> list=new ArrayList<>();
		saxParser.parse(new File("/Users/L/javaProjectE/javaLearn2/src/day7_sax/Demo1xml1.xml"), new MyDefaultHandler3(list));
		for(Contact contact:list){
			System.out.println(contact);
		}
	}
}

class MyDefaultHandler3 extends DefaultHandler{

	List<Contact> list;
	Contact contact;
	String curTag="";	//用于零时存储当前标签
	
	public MyDefaultHandler3(List<Contact> list) {
		this.list = list;
	}
	
	//1,创建对象
	//2.把一个contact标签内容存入对象
	

	//开始标签
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("contact")){
			contact=new Contact();
			contact.setId(attributes.getValue("id"));
		}
		curTag=qName;
	}

	//文本
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//当前文本内容
		String str=new String(ch, start, length);
		
		if("name".equals(curTag)){
			contact.setName(str);
		}
		if("age".equals(curTag)){
			contact.setAge(str);
		}
		if("phone".equals(curTag)){
			contact.setPhone(str);
		}
		if("email".equals(curTag)){
			contact.setEmail(str);
		}
		if("qq".equals(curTag)){
			contact.setQq(str);
		}
	}
	
	//结束标签
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("contact")){
			list.add(contact);
		}
		curTag="";
	}
	
}