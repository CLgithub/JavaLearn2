package day6dom4j_read;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
把xml文件信息封装到对象中
*/
public class Demo2 {
	public static void main(String[] args) throws Exception {
		List<Contact> list=new ArrayList<>();
		//读取xml
		SAXReader reader=new SAXReader();
		InputStream iSource=Demo2.class.getResourceAsStream("/day6dom4j_read/2xml解析1.xml");
		Document document = reader.read(iSource);
		//读取contact标签
		Iterator<Element> elementIterator = document.getRootElement().elementIterator("contact");
		while(elementIterator.hasNext()){
			Element contactElement = elementIterator.next();
			Contact contact=new Contact();
			contact.setId(contactElement.attributeValue("id"));
			contact.setName(contactElement.elementText("name"));
			contact.setAge(Integer.parseInt(contactElement.elementText("age")));
			contact.setPhone(contactElement.elementText("phone"));
			contact.setEmail(contactElement.elementText("email"));
			contact.setQq(contactElement.elementText("qq"));
			list.add(contact);
		}
		
		System.out.println(list);
		
		
	}
}

/*
	总结：
		1.xml的作用
			配置文件（）
			作为数据库
		2.xml的语法
		3.xml解析（DOM解析）
			（3.1）dom解析原理
			（3.2）Dom4j工具（基于Dom解析）
				读取：
					节点
						标签
						属性
						文本
		
		
*/